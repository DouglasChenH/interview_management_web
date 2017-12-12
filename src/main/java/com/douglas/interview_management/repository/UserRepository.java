package com.douglas.interview_management.repository;

import com.douglas.interview_management.models.User;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userRepository")
public interface UserRepository {

    User findByEmailAddress(String email);

    User findByNameAndPassword(String username, String password);

    User findByConfirmationToken(String confirmationToken);

    void saveUser(User user);

    List<User> findAll();
}