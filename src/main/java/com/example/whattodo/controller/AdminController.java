package com.example.whattodo.controller;

import com.example.whattodo.model.ManOfAction;
import com.example.whattodo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    IUserService userService;

    @GetMapping("all")
    public ResponseEntity<List<ManOfAction>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUser());
    }

}
