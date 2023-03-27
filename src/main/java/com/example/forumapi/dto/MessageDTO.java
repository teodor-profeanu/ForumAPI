package com.example.forumapi.dto;

import com.example.forumapi.model.Message;
import com.example.forumapi.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Data

public class MessageDTO {
    private int id;
    private String text;
    private int userId;
    private User user;
    private int topicId;
    private Date dateCreated;
    private Date lastEdited;

    public MessageDTO(Message message, User user){
        this.id= message.getId();
        this.text= message.getText();
        this.userId= message.getUserId();
        this.user=user;
        this.topicId= message.getTopicId();
        this.dateCreated=message.getDateCreated();
        this.lastEdited=message.getLastEdited();
    }
}
