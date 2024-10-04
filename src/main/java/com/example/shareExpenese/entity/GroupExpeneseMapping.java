package com.example.shareExpenese.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table( name = "expense_group_mapping")
public class GroupExpeneseMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
//    @OneToOne(mappedBy = "id", targetEntity = Group.class,  cascade = CascadeType.ALL)
//    private Group groupId;
//    @OneToOne(mappedBy = "id", targetEntity = Expense.class, cascade = CascadeType.ALL)
//    private Expense expenseId;

}

