package com.Leox0.todosbackend.dao;

import com.Leox0.todosbackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
