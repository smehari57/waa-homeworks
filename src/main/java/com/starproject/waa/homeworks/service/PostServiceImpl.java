package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.domain.dto.PostDto;
import com.starproject.waa.homeworks.repository.PostRepository;
import com.starproject.waa.homeworks.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapper;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapper.mapList(postRepository.findAll(), new PostDto());
    }

    @Override
    public PostDto findById(Long id) {
        return modelMapper.map(postRepository.findById(id).orElse(null), PostDto.class);
    }

    @Override
    public void save(Post p) {
       postRepository.save(p);
    }

    @Override
    public void deleteById(Long id) {
      postRepository.deleteById(id);
    }

    @Override
    public void updatePost(Long id, Post p) {
        Post posts = postRepository.findById(id).orElse(null);
        posts.setTitle(p.getTitle());
        posts.setContent(p.getContent());
        posts.setAuthor(p.getAuthor());

    }

    @Override
    public List<PostDto> getAllPostsThatMatchsThisTitle(String title) {
        return (List<PostDto>)listMapper.mapList(postRepository.getAllPostsThatMatchsThisTitle(title),new PostDto());
    }


}
