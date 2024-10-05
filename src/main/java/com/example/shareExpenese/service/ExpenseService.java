package com.example.shareExpenese.service;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.Expense;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ExpenseService {
    ApiResponse<Expense> upsertExpense(Expense expense) throws JsonProcessingException;
}
