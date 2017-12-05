package com.douglas.interview_management.repository;

import com.douglas.interview_management.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

    User findByEmailAddress(String email);

    User findByConfirmationToken(String confirmationToken);

}