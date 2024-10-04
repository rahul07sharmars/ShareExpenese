package com.example.shareExpenese.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "group_expenese")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    // One Group can have many Users (members)
    @ManyToMany
    @JoinTable(
            name = "group_members", // Name of the join table
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;
    private String defaultGroupCurrency;
    // One Group can have many Expenses
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, targetEntity = Expense.class)
    private List<Expense> expenses;




}
