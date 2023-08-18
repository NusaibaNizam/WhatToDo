package com.example.whattodo.controller;

import com.example.whattodo.model.ToDo;
import com.example.whattodo.service.IToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    IToDoService toDoService;

    @PostMapping
    public ResponseEntity<ToDo> saveTodo(Principal principal, @RequestBody ToDo toDo){
        return ResponseEntity.ok(toDoService.saveTodo(toDo, principal.getName()));
    }

    @PutMapping("{id}")
    public ResponseEntity<ToDo> completeTodo(@PathVariable Long id){
        return ResponseEntity.ok(toDoService.completeTodo(id));
    }

    @GetMapping("notdone")
    public  ResponseEntity<List<ToDo>> getNotDoneToDos(Principal principal){
        return ResponseEntity.ok(toDoService.findTodosToBeDone(principal.getName()));
    }

    @GetMapping("all")
    public  ResponseEntity<List<ToDo>> getAllToDos(Principal principal){
        return ResponseEntity.ok(toDoService.findTodosOfAManOfAction(principal.getName()));
    }
}
