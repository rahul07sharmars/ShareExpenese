package com.example.shareExpenese.service;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.entity.Group;
import com.example.shareExpenese.entity.User;
import com.example.shareExpenese.repository.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    private static final Logger LOG = LoggerFactory.getLogger(GroupServiceImpl.class);
    public ApiResponse<Group> upsertGroup(Group group) {
        try {
            Group updateGroup= groupRepository.save(group);
            if( group.getId()!=null){
                LOG.info("Group Created");
                return new ApiResponse<>(200, "Group Created", updateGroup);
            }
            else {
                LOG.info("Group Updated");
                return new ApiResponse<>(200, "Group Updated", updateGroup);
            }

        } catch (Exception e) {
            return new ApiResponse<>(400, e.getMessage());
        }
    }
    

}
