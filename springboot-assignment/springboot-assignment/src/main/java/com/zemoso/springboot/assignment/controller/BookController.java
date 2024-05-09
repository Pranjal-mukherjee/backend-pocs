package com.zemoso.springboot.assignment.controller;

import com.zemoso.springboot.assignment.DTO.BookDTO;
import com.zemoso.springboot.assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {


    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // add mapping for GET /Books
    @GetMapping("/")
    public List<BookDTO> getAllBook() {
        return bookService.getAllBooks();

    }

    // add mapping for GET /Books/{BookId}
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {

        BookDTO bookDTO = bookService.getBookById(id);

        return bookDTO;

    }

    // add mapping for POST /Books - add new Book
    @PostMapping("/")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {

        return bookService.createBook(bookDTO);


    }

    // add mapping for UPDATE /Books/{BookId} - update existing Books
    @PutMapping("/")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO) {

      return  bookService.updateBook(bookDTO);

    }

    // add mapping for DELETE /Books/{BookId} - delete Books by id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);
        return "Book Deleted With ID : " + id;


    }
}
