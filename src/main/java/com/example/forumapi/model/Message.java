package com.example.forumapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "MESSAGE")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "TOPICID")
    private int topicId;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATECREATED")
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "LASTEDITED")
    private Date lastEdited;
}
