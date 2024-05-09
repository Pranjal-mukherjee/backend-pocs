package com.practice.backend.service;

import com.practice.backend.dto.UserDto;

public interface UserService {
    UserDto getUserByID(int id);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(int id, UserDto userDto);

    void deleteUserById(int id);
}
