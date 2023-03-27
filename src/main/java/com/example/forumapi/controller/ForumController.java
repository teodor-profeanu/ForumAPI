package com.example.forumapi.controller;

import com.example.forumapi.dto.ForumDTO;
import com.example.forumapi.model.Forum;
import com.example.forumapi.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForumController {

    private ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/forum")
    public ForumDTO getForum(@RequestParam int id) {
        return forumService.getForum(id);
    }
}
