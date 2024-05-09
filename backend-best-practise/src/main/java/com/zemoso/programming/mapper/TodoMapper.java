package com.zemoso.programming.mapper;

import com.zemoso.programming.dto.TodoDTO;
import com.zemoso.programming.entity.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    private final ModelMapper modelMapper;
@Autowired
    public TodoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public TodoDTO convertToDTO(Todo todo){
    return modelMapper.map(todo, TodoDTO.class);
    }
    public Todo convertToEntity(TodoDTO todoDTO){
        return modelMapper.map(todoDTO, Todo.class);
    }
}
