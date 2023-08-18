package com.example.whattodo.service;

import com.example.whattodo.model.ToDo;
import com.example.whattodo.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToDoService implements IToDoService{

    @Autowired
    IToDoRepository toDoRepository;

    @Autowired
    IUserService userService;

    @Override
    public ToDo saveTodo(ToDo toDo, String username){
        toDo.setUserId(userService.findByUsername(username).getId());
        toDo.setCreateDate(LocalDateTime.now());
        toDo.setUpdateDate(LocalDateTime.now());
        toDo.setDone(false);
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo completeTodo(Long id){
        ToDo toDo=toDoRepository.getReferenceById(id);
        toDo.setDone(true);
        toDo.setUpdateDate(LocalDateTime.now());
        return toDoRepository.save(toDo);
    }

    @Override
    public List<ToDo> findTodosToBeDone(String username){
        return toDoRepository.findByUserIdAndDoneFalse(userService.findByUsername(username).getId());
    }

    @Override
    public List<ToDo> findTodosOfAManOfAction(String username){
        return toDoRepository.findByUserId(userService.findByUsername(username).getId());
    }
}
