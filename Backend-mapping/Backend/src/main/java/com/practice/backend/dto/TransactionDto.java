package com.practice.backend.dto;

import com.practice.backend.Enum.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private int id;
    private Date soldDate;
    private Date purchasedDate;
    private Payment payment;
    private int user_id;
}
