package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(Long id);

    void save(Post p);

    public void deleteById(Long id);

    public void updatePost(Long id, Post p);

    public List<PostDto> getAllPostsThatMatchsThisTitle(String title);

}
