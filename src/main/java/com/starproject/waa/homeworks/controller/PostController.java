package com.starproject.waa.homeworks.controller;

import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.dto.PostDto;
import com.starproject.waa.homeworks.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/posts")
public class PostController {

private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<PostDto> findAll(){
       return postService.findAll();
    }
    @GetMapping("/{id}")
    public PostDto findById(@PathVariable("id") Long id){
        return postService.findById(id);
    }
   @PostMapping
   public  void save(@RequestBody Post p){
        postService.save(p);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);
    }
   @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody Post p){
        postService.updatePost(id, p);
    }
}
