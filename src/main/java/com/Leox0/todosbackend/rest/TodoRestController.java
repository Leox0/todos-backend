package com.Leox0.todosbackend.rest;

import com.Leox0.todosbackend.entity.Todo;
import com.Leox0.todosbackend.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public List<Todo> findAl1l() {
        return this.todoService.findAll();
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable int todoId) {
        Todo theTodo = this.todoService.findById(todoId);
        if (theTodo == null) {
            throw new RuntimeException("Did not find todo with id - " + todoId);
        }
        return theTodo;
    }

    @PostMapping("/todo")
    public Todo save(@RequestBody Todo theTodo) {
        theTodo.setId(0);
        this.todoService.save(theTodo);
        return theTodo;
    }

    @PutMapping("/todo")
    public Todo update(@RequestBody Todo theTodo) {
        this.todoService.save(theTodo);
        return theTodo;
    }

    @DeleteMapping("/todo/{todoId}")
    public String delete(@PathVariable int todoId) {
        Todo theTodo = this.todoService.findById(todoId);
        if (theTodo == null) {
            throw new RuntimeException("Did not find todo with id - " + todoId);
        }
        this.todoService.deleteById(todoId);
        return "todo with id - " + todoId + " deleted";
    }

}
