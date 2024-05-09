package com.zemoso.programming.service;

import com.zemoso.programming.dto.TodoDTO;
import com.zemoso.programming.entity.Todo;
import com.zemoso.programming.exception.TodoNotFound;
import com.zemoso.programming.mapper.TodoMapper;
import com.zemoso.programming.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TodoImpl implements TodoService{
    private TodoRepo todoRepo;
    private TodoMapper todoMapper;
@Autowired
    public TodoImpl(TodoRepo todoRepo, TodoMapper todoMapper) {
        this.todoRepo = todoRepo;
        this.todoMapper = todoMapper;
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<Todo> todoList = todoRepo.findAll();
        return todoList.stream()
                .map(todoMapper :: convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDTO getTodoById(int id) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new TodoNotFound("Todo not found by this id : " + id));
        return todoMapper.convertToDTO(todo);
    }

    @Override
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = todoMapper.convertToEntity(todoDTO);
        Todo savedTodo = todoRepo.save(todo);
        return todoMapper.convertToDTO(savedTodo);
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO,int id) {
        Todo existingTodo = todoRepo.findById(id)
                .orElseThrow(()->new TodoNotFound("Todo not found by this id : " + todoDTO.getId()));
        existingTodo.setDescription(todoDTO.getDescription());
        existingTodo.setTitle(todoDTO.getTitle());
        existingTodo.setCompletionStatus(todoDTO.isCompletionStatus());
        Todo updatedTodo = todoRepo.save(existingTodo);
        return todoMapper.convertToDTO(updatedTodo);
    }

    @Override
    public String deleteTodoById(int id) {
        Todo existingTodo = todoRepo.findById(id)
                .orElseThrow(()->new TodoNotFound("Todo not found by this id : " + id));
        todoRepo.deleteById(id);
        return "Todo deleted with id : " + id;
    }
}
