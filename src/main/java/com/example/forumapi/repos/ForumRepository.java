package com.example.forumapi.repos;

import com.example.forumapi.model.Forum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends CrudRepository<Forum,Integer> {
    Iterable<Forum> findAllByCategoryId(int categoryId);
}
