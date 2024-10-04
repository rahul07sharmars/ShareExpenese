package com.example.shareExpenese.service;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
    ApiResponse<User> upsertUser(User user) throws JsonProcessingException;
}
