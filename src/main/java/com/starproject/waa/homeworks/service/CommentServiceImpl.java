package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.Comment;
import com.starproject.waa.homeworks.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }


    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment c) {
        commentRepository.save(c);

    }

    @Override
    public void deleteById(Long id) {
       commentRepository.deleteById(id);

    }

    @Override
    public void updatePost(Long id, Comment c) {
        Comment com = commentRepository.findById(id).orElse(null);
        com.setName(c.getName());

    }
}
