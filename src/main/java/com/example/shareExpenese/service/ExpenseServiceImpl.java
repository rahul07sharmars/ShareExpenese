package com.example.shareExpenese.service;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.common.MessageConstants;
import com.example.shareExpenese.entity.Expense;
import com.example.shareExpenese.entity.Group;
import com.example.shareExpenese.repository.ExpeneseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Executable;
import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpeneseRepository expeneseRepository;
    private static final Logger LOG = LoggerFactory.getLogger(ExpenseServiceImpl.class);
    @Override
    public ApiResponse<Expense> upsertExpense(Expense expense) throws JsonProcessingException {
        try {
            Expense updateExpense = expeneseRepository.save(expense);
            if (expense.getId() == null){
                expense.setId(UUID.randomUUID().toString());
                LOG.info("Update Object of "+ Expense.class);
                return new ApiResponse<>(200, "", updateExpense);
            } else {
                LOG.info("Created Object of "+ Expense.class);
                return new ApiResponse<>(200, "", updateExpense);
            }
        } catch (Exception e){
            LOG.error("Created Object of "+ Expense.class);
            return new ApiResponse<>(200, "");

        }
    }
}
