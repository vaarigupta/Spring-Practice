package com.practice.auth.learn.controller;

import com.practice.auth.learn.model.User;
import com.practice.auth.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/home/users
    @GetMapping("/users")
    public List<User> getUsers(){

        return this.userService.getUsers();
    }


}
