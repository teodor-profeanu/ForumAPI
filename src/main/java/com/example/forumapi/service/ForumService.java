package com.example.forumapi.service;

import com.example.forumapi.dto.TopicDTO;
import com.example.forumapi.model.Forum;
import com.example.forumapi.dto.ForumDTO;
import com.example.forumapi.model.Topic;
import com.example.forumapi.repos.ForumRepository;
import com.example.forumapi.repos.TopicRepository;
import com.example.forumapi.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ForumService {
    private final ForumRepository forumRepo;
    private final TopicRepository topicRepo;
    private final UserRepository userRepo;

    public ForumDTO getForum(int id) {
        Optional<Forum> forum = forumRepo.findById(id);
        if(forum.isEmpty())
            return null;
        List<TopicDTO> topics=new ArrayList<>();
        for(Topic topic:topicRepo.findAllByForumId(forum.get().getId())){
            topics.add(new TopicDTO(topic,userRepo.findById(topic.getUserId()).get(),null));
        }
        return new ForumDTO(forum.get(),topics);
    }
}
