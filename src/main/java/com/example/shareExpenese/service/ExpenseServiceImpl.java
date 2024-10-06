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
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpeneseRepository expeneseRepository;
    private static final Logger LOG = LoggerFactory.getLogger(ExpenseServiceImpl.class);
    @Override
    public ApiResponse<Expense> upsertExpense(Expense expense) throws JsonProcessingException {
        try {
            if (expense.getId() != null) {
                Optional<Expense> optionalExpense = expeneseRepository.findById(expense.getId());
                Expense updateGroup= expeneseRepository.save(expense);
                if (!optionalExpense.isPresent()) {
                    LOG.info(MessageConstants.expensesCreatedMessage);
                    return new ApiResponse<>(200, MessageConstants.expensesCreatedMessage, updateGroup);
                } else {
                    LOG.info(MessageConstants.expensesUpdatedMessage);
                    return new ApiResponse<>(200, MessageConstants.expensesUpdatedMessage, updateGroup);
                }
            }
            else {
                Expense updateGroup= expeneseRepository.save(expense);
                LOG.info(MessageConstants.expensesCreatedMessage);
                return new ApiResponse<>(200, MessageConstants.expensesCreatedMessage, updateGroup);
            }
        } catch (Exception e) {
            LOG.error(MessageConstants.expeneseFailurMessage+e.getMessage());
            return new ApiResponse<>(400, e.getMessage());
        }
    }
}
