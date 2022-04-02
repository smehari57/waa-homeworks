package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.Comment;
import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.dto.CommentDto;
import com.starproject.waa.homeworks.dto.PostDto;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment c);

    public void deleteById(Long id);

    public void updatePost(Long id, Comment c);


}
