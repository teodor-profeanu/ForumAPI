package com.example.forumapi.service;

import com.example.forumapi.dto.TopicDTO;
import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import com.example.forumapi.repos.MessageRepository;
import com.example.forumapi.repos.TopicRepository;
import com.example.forumapi.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository messageRepo;
    private final TopicService topicService;
    private final TopicRepository topicRepo;
    private final UserRepository userRepo;

    public TopicDTO postMessage(int userId, int topicId, String text){
        Message message=new Message(0,text,userId,topicId,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));
        messageRepo.save(message);
        Topic topic=topicRepo.findById(topicId).get();
        topic.setMessageCount(topic.getMessageCount()+1);
        topicRepo.save(topic);
        User user=userRepo.findById(userId).get();
        user.setNrOfMessages(user.getNrOfMessages()+1);
        userRepo.save(user);
        return topicService.getTopic(topicId);
    }
}
