package com.example.shareExpenese.controller;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.User;
import com.example.shareExpenese.service.UserService;
import com.example.shareExpenese.utils.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @PatchMapping("/upsert")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user){
        System.out.println("usercreating functionmk");
        try {
            ApiResponse<User> apiResponse = userService.upsertUser(user);
            return ResponseUtils.createApiResponse(apiResponse.getData(), HttpStatus.OK, apiResponse.getMessage());
        } catch (JsonProcessingException e) {
            LOG.error("Issue: "+ e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
