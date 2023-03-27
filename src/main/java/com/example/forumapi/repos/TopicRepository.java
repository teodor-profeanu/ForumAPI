package com.example.forumapi.repos;

import com.example.forumapi.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic,Integer> {
    Iterable<Topic> findAllByForumId(int forumId);
    Iterable<Topic> findAllByUserId(int userId);
}
