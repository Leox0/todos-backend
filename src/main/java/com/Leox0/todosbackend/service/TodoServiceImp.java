package com.Leox0.todosbackend.service;

import com.Leox0.todosbackend.dao.TodoRepository;
import com.Leox0.todosbackend.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImp implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImp(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return this.todoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) {
        Optional<Todo> results = this.todoRepository.findById(theId);
        Todo theTodo;
        if (results.isPresent()) {
            theTodo = results.get();
        } else {
            throw new RuntimeException("Did not find todo with id - " + theId);
        }
        return theTodo;
    }

    @Override
    public void save(Todo theTodo) {
        this.todoRepository.save(theTodo);
    }

    @Override
    public void deleteById(int theId) {
        this.todoRepository.deleteById(theId);
    }
}
