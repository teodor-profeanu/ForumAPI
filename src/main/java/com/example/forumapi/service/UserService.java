package com.example.forumapi.service;

import com.example.forumapi.model.User;
import com.example.forumapi.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public User login(String username, String password){
        Optional<User> requestedUser=userRepo.findByUsername(username);
        if(requestedUser.isPresent()){
            if(requestedUser.get().getPassword().compareTo(password)==0){
                System.out.println(username+" "+password+"\n");
                return requestedUser.get();
            }
            return null;
        }
        return null;
    }

    public User register(String email, String username, String password, String repeatPassword){
        if(password.compareTo(repeatPassword)!=0)
            return null;
        Optional<User> usernameOptional=userRepo.findByUsername(username);
        if(usernameOptional.isPresent())
            return null;
        Optional<User> emailOptional=userRepo.findByEmail(email);
        if(emailOptional.isPresent())
            return null;
        User user=new User(0,username,password,email,0,0);
        userRepo.save(user);
        user=userRepo.findByUsername(username).get();
        return user;
    }

    public User getUser(int id){
        Optional<User> user=userRepo.findById(id);
        if(user.isPresent())
            return user.get();
        return null;
    }

    public boolean changePassword(int userId, String oldPassword, String newPassword){
        Optional<User> user=userRepo.findById(userId);
        if(user.isEmpty())
            return false;
        if(user.get().getPassword().compareTo(oldPassword)!=0)
            return false;
        user.get().setPassword(newPassword);
        userRepo.save(user.get());
        return true;
    }
}
