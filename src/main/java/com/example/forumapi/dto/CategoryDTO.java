package com.example.forumapi.dto;
import com.example.forumapi.model.Category;
import com.example.forumapi.model.Forum;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private int id;
    private String name;
    private int orderNr;
    private List<Forum> forums;

    public CategoryDTO(Category category, List<Forum> forums){
        this.id=category.getId();
        this.name= category.getName();
        this.orderNr=category.getOrderNr();
        this.forums=forums;
    }
}
