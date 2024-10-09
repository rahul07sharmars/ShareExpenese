package com.example.shareExpenese.controller;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.Expense;
import com.example.shareExpenese.service.DataStorageService;
import com.example.shareExpenese.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class DataStoreageController {
    @Autowired
    private DataStorageService service;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<String>> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        ApiResponse<String> apiResponse = service.uploadFile(file);
        return ResponseUtils.createApiResponse(apiResponse.getData(), HttpStatus.OK, apiResponse.getMessage());
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        ApiResponse<byte[]> apiResponse = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(apiResponse.getData());
        return ResponseEntity
                .ok()
                .contentLength(apiResponse.getData().length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<ApiResponse<String>> deleteFile(@PathVariable String fileName) {
        ApiResponse<String> apiResponse = service.deleteFile(fileName);
        return ResponseUtils.createApiResponse(apiResponse.getData(), HttpStatus.OK, apiResponse.getMessage());
    }
}
