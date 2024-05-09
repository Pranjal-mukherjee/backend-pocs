package com.practice.backend.service;

import com.practice.backend.dto.TransactionDto;
import com.practice.backend.entity.Product;
import com.practice.backend.entity.Transaction;
import com.practice.backend.exception.NotFoundException;
import com.practice.backend.mapper.ProductMapper;
import com.practice.backend.mapper.TransactionMapper;
import com.practice.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public TransactionDto getTransactionByID(int id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        return TransactionMapper.convertToDto(transaction);    }

    @Override
    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        Transaction transaction = TransactionMapper.convertToEntity(transactionDto);
        transaction = transactionRepository.save(transaction);
        return TransactionMapper.convertToDto(transaction);

    }

}
