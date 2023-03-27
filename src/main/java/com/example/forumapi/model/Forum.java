package com.example.forumapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "FORUM")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORDERNR")
    private int orderNr;

    @Column(name = "CATEGORYID")
    private int categoryId;
}
