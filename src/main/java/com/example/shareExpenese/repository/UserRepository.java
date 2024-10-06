package com.example.shareExpenese.repository;

import com.example.shareExpenese.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {

}
