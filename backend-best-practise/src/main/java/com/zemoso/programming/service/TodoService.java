package com.zemoso.programming.service;

import com.zemoso.programming.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    public List<TodoDTO> getAllTodos();
    public TodoDTO getTodoById(int id);
    public TodoDTO saveTodo(TodoDTO todoDTO);
    public TodoDTO updateTodo(TodoDTO todoDTO,int id);
    public String deleteTodoById(int id);
}
