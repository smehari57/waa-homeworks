package com.starproject.waa.homeworks.controller;

import com.starproject.waa.homeworks.domain.Comment;
import com.starproject.waa.homeworks.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }
    @GetMapping("/{id}")
    public Comment findById(@PathVariable("id") Long id){
        return commentService.findById(id);
   }
    @PostMapping
    public void save(@RequestBody Comment c){
        commentService.save(c);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        commentService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody Comment c){
        commentService.updatePost(id, c);
    }


}
