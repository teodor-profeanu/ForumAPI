package com.example.forumapi.controller;

import com.example.forumapi.model.User;
import com.example.forumapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/login")
    public User login(@RequestParam @DefaultValue("") String username, @DefaultValue("") String password){
        if(username==null||password==null)
            return null;
        if(username.length()==0||password.length()==0)
            return null;
        return userService.login(username,password);
    }

    @PostMapping("/user/register")
    public User register(@RequestParam @DefaultValue("") String email, @DefaultValue("") String username, @DefaultValue("") String password, @DefaultValue("") String repeatPassword){
        if(email==null||username==null||password==null||repeatPassword==null)
            return null;
        if(email.length()==0||username.length()==0||password.length()==0||repeatPassword.length()==0)
            return null;
        return userService.register(email, username, password, repeatPassword);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        return userService.getUser(id);
    }

    @PostMapping("/user/change-password")
    public boolean changePassword(@RequestParam int id, @DefaultValue("") String oldPassword, @DefaultValue("") String newPassword){
        if(oldPassword==null||newPassword==null)
            return false;
        if(oldPassword.length()==0||newPassword.length()==0)
            return false;
        return userService.changePassword(id,oldPassword,newPassword);
    }
}
