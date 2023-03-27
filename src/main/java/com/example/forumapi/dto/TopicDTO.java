package com.example.forumapi.dto;

import com.example.forumapi.model.Message;
import com.example.forumapi.model.Topic;
import com.example.forumapi.model.User;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.util.List;


@Data
public class TopicDTO {
    private int id;
    private String name;
    private int userId;
    private User user;
    private int forumId;
    private Date dateCreated;
    private Date lastPosted;
    private int messageCount;
    private List<MessageDTO> messages;

    public TopicDTO(Topic topic, User user, List<MessageDTO> messages){
        this.id=topic.getId();
        this.name=topic.getName();
        this.userId=topic.getUserId();
        this.forumId=topic.getForumId();
        this.dateCreated=topic.getDateCreated();
        this.lastPosted=topic.getLastPosted();
        this.messageCount=topic.getMessageCount();
        this.user=user;
        this.messages=messages;
    }
}
