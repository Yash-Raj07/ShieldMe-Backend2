package com.shieldme.authentication.service;

import com.shieldme.authentication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public UserService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void updatePassword(String email, String newPassword) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update().set("password", newPassword);
        mongoTemplate.updateFirst(query, update, User.class);
    }
}
