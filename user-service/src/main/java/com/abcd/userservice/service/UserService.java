package com.abcd.userservice.service;

import com.abcd.userservice.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(Long id){

        return new User(id,"Aditya");

    }

}