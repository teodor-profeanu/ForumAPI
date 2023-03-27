package com.example.forumapi.service;

import com.example.forumapi.dto.CategoryDTO;
import com.example.forumapi.model.Category;
import com.example.forumapi.model.Forum;
import com.example.forumapi.repos.CategoryRepository;
import com.example.forumapi.repos.ForumRepository;
import com.example.forumapi.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;
    private final ForumRepository forumRepo;

    public List<CategoryDTO> getCategories() {
        List<Category> categories= (List<Category>) categoryRepo.findAll();
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for(Category category:categories)
            categoriesDTO.add(new CategoryDTO(category,(List<Forum>) forumRepo.findAllByCategoryId(category.getId())));
        return categoriesDTO;
    }
}
