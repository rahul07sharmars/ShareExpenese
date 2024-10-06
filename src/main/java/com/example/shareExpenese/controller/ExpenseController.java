package com.example.shareExpenese.controller;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.Expense;
import com.example.shareExpenese.service.ExpenseService;
import com.example.shareExpenese.utils.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    private static final Logger LOG = LoggerFactory.getLogger(Expense.class);
    @PatchMapping("/upsert")
    public ResponseEntity<ApiResponse<Expense>> upsertExpense(@RequestBody Expense expense){
        try {
            ApiResponse<Expense> apiResponse = expenseService.upsertExpense(expense);
            return ResponseUtils.createApiResponse(apiResponse.getData(), HttpStatus.OK, apiResponse.getMessage());
        } catch (JsonProcessingException e) {
            LOG.error("Issue: "+ e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
