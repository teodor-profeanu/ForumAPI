package com.example.forumapi.controller;

import com.example.forumapi.dto.TopicDTO;
import com.example.forumapi.model.Topic;
import com.example.forumapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/topic/new")
    public TopicDTO postTopic(@RequestParam int userId, @RequestParam int forumId, @RequestParam String name,@RequestParam String message) {
        return topicService.postTopic(userId,forumId,name,message);
    }

    @GetMapping("/topic")
    public TopicDTO getTopic(@RequestParam int id) {
        return topicService.getTopic(id);
    }

    @GetMapping("/topic/user")
    public List<Topic> getTopicsByUser(@RequestParam int id) {
        return topicService.getTopicsByUser(id);
    }
}
