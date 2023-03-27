package com.example.forumapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @NotNull
    @Column(name = "USERNAME",unique = true)
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "EMAIL",unique = true)
    @Pattern(regexp = "\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})")
    private String email;

    @Column(name = "NROFMESSAGES")
    private int nrOfMessages;

    @Column(name = "NROFTOPICS")
    private int nrOfTopics;
}
