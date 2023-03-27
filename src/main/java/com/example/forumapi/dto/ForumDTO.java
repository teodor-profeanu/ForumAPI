package com.example.forumapi.dto;

import com.example.forumapi.dto.TopicDTO;
import com.example.forumapi.model.Forum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ForumDTO {
    private int id;
    private String name;
    private int orderNr;
    private int categoryId;
    private List<TopicDTO> topics;

    public ForumDTO(Forum forum, List<TopicDTO> topics){
        this.id=forum.getId();
        this.name=forum.getName();
        this.orderNr= forum.getOrderNr();
        this.categoryId=forum.getCategoryId();
        this.topics=topics;
    }
}
