package com.alphaspear.ToDoList.service;

import com.alphaspear.ToDoList.models.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoEntity, Integer> {

}
