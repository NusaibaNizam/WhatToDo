package com.example.whattodo.service;

import com.example.whattodo.model.ManOfAction;
import com.example.whattodo.model.Role;
import com.example.whattodo.repository.IUserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.whattodo.utill.Constants.USERNAME_NOT_FOUND;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ManOfAction saveUser(@NotNull ManOfAction user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public ManOfAction changeRole(String username, Role newRole){
        ManOfAction user = userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
        user.setRole(newRole);
        return userRepository.save(user);
    }

    @Override
    public ManOfAction findByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public ManOfAction findByUsernameOrThrow(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(USERNAME_NOT_FOUND));
    }

    @Override
    public List<ManOfAction> findAllUser(){
        return userRepository.findAll();
    }
}
