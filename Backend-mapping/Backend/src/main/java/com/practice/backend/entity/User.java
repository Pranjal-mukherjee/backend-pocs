package com.practice.backend.entity;

import com.practice.backend.Enum.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Product> productList;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Transaction> transactionList;
}
