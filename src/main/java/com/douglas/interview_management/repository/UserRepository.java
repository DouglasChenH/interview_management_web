package com.douglas.interview_management.repository;

import com.douglas.interview_management.models.User;



public interface UserRepository{

    User findByEmailAddress(String email);

    User findByNameAndPassword(String fullName, String password);

    User findByConfirmationToken(String confirmationToken);

    void save(User user);
}