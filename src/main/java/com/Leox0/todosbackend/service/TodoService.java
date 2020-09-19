package com.Leox0.todosbackend.service;

import com.Leox0.todosbackend.entity.Todo;

import java.util.List;

public interface TodoService {

    public List<Todo> findAll();

    public Todo findById(int theId);

    public void save(Todo todo);

    public void deleteById(int theId);

}
