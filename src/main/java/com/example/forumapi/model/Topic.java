package com.example.forumapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Date;


@Entity
@Table(name = "TOPIC")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "FORUMID")
    private int forumId;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATECREATED")
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    @Column(name = "LASTPOSTED")
    private Date lastPosted;

    @Column(name = "MESSAGECOUNT")
    private int messageCount=1;
}
