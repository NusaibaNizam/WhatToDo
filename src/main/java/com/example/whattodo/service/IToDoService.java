package com.example.whattodo.service;

import com.example.whattodo.model.ToDo;

import java.util.List;

public interface IToDoService {
    ToDo saveTodo(ToDo toDo, String username);

    ToDo completeTodo(Long id);

    List<ToDo> findTodosToBeDone(String username);

    List<ToDo> findTodosOfAManOfAction(String username);
}
