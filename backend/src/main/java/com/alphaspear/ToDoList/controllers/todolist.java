package com.alphaspear.ToDoList.controllers;

import com.alphaspear.ToDoList.models.ToDoEntity;
import com.alphaspear.ToDoList.service.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/todo")
public class todolist {
    @Autowired
    private ToDoListRepository toDoListRepository;
    @GetMapping("")
    public List<ToDoEntity> getList(){
        return toDoListRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ToDoEntity> getTodoEntity(@PathVariable int id){
        return toDoListRepository.findById(id);
    }

    @PostMapping("/create")
    public void saveOne(@RequestBody ToDoEntity todo){
        toDoListRepository.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable int id){
        toDoListRepository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateOne(@PathVariable int id, @RequestBody ToDoEntity todoent){
        ToDoEntity todo = toDoListRepository.findById(id).get();
        todo.setDescription(todoent.getDescription());
        todo.setTopic(todoent.getTopic());
        todo.setStatus(todoent.getStatus());
    }


}
