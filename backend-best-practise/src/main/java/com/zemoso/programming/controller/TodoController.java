package com.zemoso.programming.controller;

import com.zemoso.programming.dto.TodoDTO;
import com.zemoso.programming.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoDTO> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoDTO getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public TodoDTO saveTodo(@Valid @RequestBody TodoDTO todoDTO) {
        return todoService.saveTodo(todoDTO);
    }

    @PutMapping("/{id}")
    public TodoDTO updateTodo(@Valid @RequestBody TodoDTO todoDTO,@PathVariable int id) {
        return todoService.updateTodo(todoDTO,id);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        return todoService.deleteTodoById(id);
    }
}
