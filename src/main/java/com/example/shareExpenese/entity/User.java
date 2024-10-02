package com.example.shareExpenese.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String mobileNumber;
    private String defaultCurrency;
}
