package com.practice.backend.controller;

import com.practice.backend.dto.TransactionDto;
import com.practice.backend.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@Validated
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getUserById(@PathVariable int id){
        return new ResponseEntity<>(transactionService.getTransactionByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionDto> saveUser(@Valid @RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionService.saveTransaction(transactionDto), HttpStatus.CREATED);
    }
}
