package com.example.forumapi.repos;

import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Integer> {
    Iterable<Message> findAllByTopicId(int topicId);
}
