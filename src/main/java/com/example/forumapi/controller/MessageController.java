package com.example.forumapi.controller;

import com.example.forumapi.dto.MessageDTO;
import com.example.forumapi.dto.TopicDTO;
import com.example.forumapi.model.Topic;
import com.example.forumapi.service.MessageService;
import com.example.forumapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message/new")
    public TopicDTO postMessage(@RequestParam int userId, @RequestParam int topicId, @RequestParam String message) {
        return messageService.postMessage(userId,topicId,message);
    }
}
