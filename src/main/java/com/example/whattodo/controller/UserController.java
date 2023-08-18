package com.example.whattodo.controller;

import com.example.whattodo.model.ManOfAction;
import com.example.whattodo.model.Role;
import com.example.whattodo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseEntity<ManOfAction> register(@RequestBody ManOfAction user){
        if(Objects.nonNull(userService.findByUsername(user.getUsername()))){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("login")
    public ResponseEntity<ManOfAction> login(HttpServletRequest request){
        Principal userPrincipal = request.getUserPrincipal();
        if(Objects.isNull(userPrincipal) || Objects.isNull(userPrincipal.getName())){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userService.findByUsername(userPrincipal.getName()), HttpStatus.OK);
    }

    @PostMapping("change/{role}")
    public ResponseEntity<ManOfAction> changeRole(Principal principal, @PathVariable Role role){
        return ResponseEntity.ok(userService.changeRole(principal.getName(), role));
    }
}
