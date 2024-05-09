package com.practice.backend.service;

import com.practice.backend.dto.UserDto;
import com.practice.backend.entity.User;
import com.practice.backend.exception.NotFoundException;
import com.practice.backend.mapper.UserMapper;
import com.practice.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;
    @Override
    public UserDto getUserByID(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        return UserMapper.convertToDto(user);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User saveUser = UserMapper.convertToEntity(userDto);
        saveUser = userRepository.save(saveUser);
        return UserMapper.convertToDto(saveUser);
    }

    @Override
    public UserDto updateUser(int id,UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        existingUser.setUserName(userDto.getUserName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setRoles(userDto.getRoles());

        User updateUser = userRepository.save(existingUser);
        return UserMapper.convertToDto(updateUser);
    }

    @Override
    public void deleteUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        userRepository.deleteById(id);
    }
}
