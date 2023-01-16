package com.example.forumapi.service;

import com.example.forumapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users;

    public UserService(){
        users=new ArrayList<>();
        users.add(new User(1, "Teo","stas","teo.stas@gmail.com",420,69));
        users.add(new User(2, "ajutor","send","help@plz.com",419,68));
    }

    public Optional<User> getUser(Integer id){
        Optional optional=Optional.empty();
        for(User user:users){
            if(id == user.getId()){
                optional=Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
