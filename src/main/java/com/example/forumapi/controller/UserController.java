package com.example.forumapi.controller;

import com.example.forumapi.model.User;
import com.example.forumapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user=userService.getUser(id);
        if(user.isPresent())
            return user.get();
        return null;
    }
}
