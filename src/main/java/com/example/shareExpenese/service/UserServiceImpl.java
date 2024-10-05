package com.example.shareExpenese.service;

import com.example.shareExpenese.common.ApiResponse;
import com.example.shareExpenese.common.MessageConstants;
import com.example.shareExpenese.entity.User;
import com.example.shareExpenese.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public ApiResponse<User> upsertUser(User user){
        try {
            User createUser= userRepository.save(user);
            if( user.getId()==null){
                LOG.info(MessageConstants.userCreatedMessage);
                return new ApiResponse<>(200, MessageConstants.userCreatedMessage, createUser);
            }
            else {
                LOG.info(MessageConstants.userUpdatedMessage);
                return new ApiResponse<>(200, MessageConstants.userUpdatedMessage, createUser);
            }
        }
        catch (Exception e) {
            LOG.error(MessageConstants.userFailureMessage+e.getMessage());
            return new ApiResponse<>(400, e.getMessage());
        }
    }
}
