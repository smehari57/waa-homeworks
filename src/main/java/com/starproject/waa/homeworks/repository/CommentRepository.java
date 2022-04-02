package com.starproject.waa.homeworks.repository;

import com.starproject.waa.homeworks.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findAll();
}
