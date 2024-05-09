package com.zemoso.springboot.assignment.service;

import com.zemoso.springboot.assignment.DTO.UserDTO;
import com.zemoso.springboot.assignment.entity.Book;
import com.zemoso.springboot.assignment.entity.User;
import com.zemoso.springboot.assignment.repository.BookRepository;
import com.zemoso.springboot.assignment.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private BookRepository bookRepository;

    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id " + id));

        return convertToDto(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        Book book = bookRepository.findById(userDTO.getBookId())
                .orElseThrow(() ->
                        new NoSuchElementException(("Book not found with id " +
                                userDTO.getBookId())));

        User user = convertToEntity(userDTO);
        user.setBook(book);

        // Clear the ID to ensure it is generated by the database
        user.setId(null);

        user = userRepository.save(user);
        System.out.println(user.toString());
        return convertToDto(user);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(()
                -> new NoSuchElementException("User not found with id " + userDTO.getId()));

        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        Book book = bookRepository.findById(userDTO.getBookId())
                .orElseThrow(()
                        -> new NoSuchElementException("User not found with id " + userDTO.getBookId()));
        existingUser.setBook(book);

        User user = userRepository.save(existingUser);
        return convertToDto(user);
    }

    public String deleteUser(Long id) {

        User user = userRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("User not found with id " + id));



        userRepository.deleteById(id);
        return "User Deleted With ID : " + id;
    }

    private UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBookId(user.getBook().getId());

        return userDTO;
    }
    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
