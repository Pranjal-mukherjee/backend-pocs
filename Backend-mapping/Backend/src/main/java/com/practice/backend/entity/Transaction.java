package com.practice.backend.entity;

import com.practice.backend.Enum.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sold_date")
    private Date soldDate;
    @Column(name = "purchased_date")
    private Date purchasedDate;
    @Column(name = "payment")
    @Enumerated(EnumType.STRING)
    private Payment payment;

    private int user_id;
}
