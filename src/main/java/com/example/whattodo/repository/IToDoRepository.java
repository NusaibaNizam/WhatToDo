package com.example.whattodo.repository;

import com.example.whattodo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUserIdAndDoneFalse(Long userId);
}
