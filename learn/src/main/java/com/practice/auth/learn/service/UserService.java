package com.practice.auth.learn.service;

import com.practice.auth.learn.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    public UserService(){
        userList.add(new User(UUID.randomUUID().toString(),"vaari","vaari@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"raavi","raavi@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"yashu","yashu@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(),"himanshu","himansu@gmail.com"));
    }

    public List<User> getUsers(){
        return  userList;
    }

}
