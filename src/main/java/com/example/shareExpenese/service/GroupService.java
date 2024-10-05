package com.example.shareExpenese.service;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.Group;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface GroupService {

    ApiResponse<Group> upsertGroup(Group group) throws JsonProcessingException;
}
