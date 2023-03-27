package com.example.forumapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @NotNull
    @Column(name = "NAME",unique = true)
    private String name;

    @Column(name = "ORDERNR")
    private int orderNr;
}
