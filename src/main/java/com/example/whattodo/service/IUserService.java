package com.example.whattodo.service;

import com.example.whattodo.model.ManOfAction;
import com.example.whattodo.model.Role;

import java.util.List;

public interface IUserService {
    public ManOfAction saveUser(ManOfAction user);

    public ManOfAction changeRole(String username, Role newRole);

    ManOfAction findByUsername(String username);

    ManOfAction findByUsernameOrThrow(String username);

    List<ManOfAction> findAllUser();
}
