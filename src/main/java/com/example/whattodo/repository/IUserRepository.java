package com.example.whattodo.repository;

import com.example.whattodo.model.ManOfAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<ManOfAction, Long> {
    Optional<ManOfAction> findByUsername(String username);
}
