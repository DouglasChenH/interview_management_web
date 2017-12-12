package com.douglas.interview_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import com.douglas.interview_management.models.User;
import com.douglas.interview_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements UserRepository{

    @Autowired
    MongoTemplate mongoTemplate;


    public User findByEmailAddress(String emailAddress) {
        Criteria criteria=Criteria.where("emailAddress").is(emailAddress);
        User user = getMongoTemplate().findOne(new Query(criteria), User.class);
        return user;
    }


    public User findByNameAndPassword(String username, String password) {
        Criteria criteria=Criteria.where("username").is(username).and("password").is(password);
        User user = getMongoTemplate().findOne(new Query(criteria), User.class);
        return user;
    }


    public User findByConfirmationToken(String confirmationToken) {
        Criteria criteria=Criteria.where("confirmationToken").is(confirmationToken);
        User user = getMongoTemplate().findOne(new Query(criteria), User.class);
        return user;
    }


    public void saveUser(User user) {
        getMongoTemplate().save(user);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<User> findAll() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));

        List<User> userList=  mongoTemplate.find(query, User.class);
        return userList;
    }
}