package com.example.shareExpenese.controller;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.User;
import com.example.shareExpenese.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PutMapping("/upsert")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user){

        System.out.println("usercreating functionmk");
        try {
            ApiResponse<User> apiResponse = userService.upsertUser(user);
            return ResponseEntity.status(apiResponse.getStatus())
                    .body(apiResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
