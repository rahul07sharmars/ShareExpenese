package com.example.shareExpenese.repository;

import com.example.shareExpenese.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpeneseRepository extends JpaRepository<Expense, String> {
}
