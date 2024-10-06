package com.example.shareExpenese.controller;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.Group;
import com.example.shareExpenese.service.GroupService;
import com.example.shareExpenese.utils.ResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    private static final Logger LOG = LoggerFactory.getLogger(GroupController.class);
    @PatchMapping("/upsert")
    public ResponseEntity<ApiResponse<Group>> upsertGroup(@RequestBody Group group) {
        System.out.println("usercreating functionmk");
        try {
            ApiResponse<Group> apiResponse = groupService.upsertGroup(group);
            return ResponseUtils.createApiResponse(apiResponse.getData(), HttpStatus.OK, apiResponse.getMessage());

        } catch (JsonProcessingException e) {
            LOG.error("Issue: "+ e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
