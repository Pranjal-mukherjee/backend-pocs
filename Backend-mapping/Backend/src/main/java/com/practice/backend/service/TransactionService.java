package com.practice.backend.service;


import com.practice.backend.dto.TransactionDto;

public interface TransactionService {
    TransactionDto getTransactionByID(int id);
    TransactionDto saveTransaction(TransactionDto transactionDto);
}
