package com.example.shareExpenese.utils;

import com.example.shareExpenese.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    private ResponseUtils() {
        throw new IllegalStateException("Utility class Issue");
    }

    public static <T> ResponseEntity<ApiResponse<T>> createApiResponse(T data, HttpStatus httpStatus, String message) {
        ApiResponse<T> response;
        if (data == null) {
            response = new ApiResponse<>(httpStatus.value(), message, null);
        } else {
            response = new ApiResponse<>(httpStatus.value(), message, data);
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
