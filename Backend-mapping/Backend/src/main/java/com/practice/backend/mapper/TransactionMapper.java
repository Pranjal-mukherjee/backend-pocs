package com.practice.backend.mapper;


import com.practice.backend.dto.TransactionDto;
import com.practice.backend.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionMapper {
    @Autowired
    private static ModelMapper modelMapper;

    static{
        modelMapper = new ModelMapper();
    }

    public static Transaction convertToEntity(TransactionDto transactionDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(transactionDto, Transaction.class);
    }

    public static TransactionDto convertToDto(Transaction transaction)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(transaction,TransactionDto.class);
    }
}
