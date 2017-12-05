package com.douglas.interview_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import com.douglas.interview_management.models.User;
import com.douglas.interview_management.repository.UserRepository;


public class UserService implements UserRepository{



    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public User findByEmailAddress(String emailAddress) {
        Criteria criteria=Criteria.where("emailAddress").is(emailAddress);
        User user = getMongoTemplate().findOne(new Query(criteria), User.class);
        return user;
    }

    @Override
    public User findByNameAndPassword(String fullName, String password) {
        Criteria criteria=Criteria.where("fullName").is(fullName).and("password").is(password);
        User user = getMongoTemplate().findOne(new Query(criteria), User.class);
        return user;
    }

    @Override
    public User findByConfirmationToken(String confirmationToken) {
        Criteria criteria=Criteria.where("confirmationToken").is(confirmationToken);
        User user = getMongoTemplate().findOne(new Query(criteria), User.class);
        return user;
    }

    @Override
    public void save(User user) {
        getMongoTemplate().save(user);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


}