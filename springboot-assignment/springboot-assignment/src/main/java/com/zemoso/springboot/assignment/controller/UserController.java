package com.zemoso.springboot.assignment.controller;

import com.zemoso.springboot.assignment.DTO.UserDTO;
import com.zemoso.springboot.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add mapping for GET /Books
    @GetMapping("/")
    public List<UserDTO> getAllUser() {
        return userService.getAllUsers();

    }

    // add mapping for GET /Books/{BookId}
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);

    }

    // add mapping for POST /Books - add new Book
    @PostMapping("/")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
       return userService.createUser(userDTO);

    }

    // add mapping for UPDATE /Books/{BookId} - update existing Books
    @PutMapping("/")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);

    }

    // add mapping for DELETE /Books/{BookId} - delete Books by id
    @DeleteMapping("/{id}")
    public String deleteUsere(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User Deleted With ID : " + id;

    }
}
