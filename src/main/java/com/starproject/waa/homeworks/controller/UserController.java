package com.starproject.waa.homeworks.controller;

import com.starproject.waa.homeworks.Aspect.ExecutionTme;
import com.starproject.waa.homeworks.domain.Comment;
import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.domain.User;
import com.starproject.waa.homeworks.dto.CommentDto;
import com.starproject.waa.homeworks.dto.PostDto;
import com.starproject.waa.homeworks.dto.UserDto;
import com.starproject.waa.homeworks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    @ExecutionTme
    public UserDto getUserById(@PathVariable("id") int id){
        return userService.findById(id);
    }
    @GetMapping("/{id}/posts")
    public List<PostDto> findPostsById(@PathVariable("id") int id){
        return userService.findPostsById(id);
    }
    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        userService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user){
        userService.updateUser(id, user);
    }
    @GetMapping("/moreThanOnePosts")
    public List<UserDto> getUsersWithMoreThanOnePosts(){
        return userService.usersWithMoreThanOnePosts();
    }

    @GetMapping("/getPostsWhichMatchsThisTitle")
    public List<PostDto> getPostsWhichMatchsThisTitle(String title){
        return userService.getAllPostsThatMatchsThisTitle(title);
    }

    @GetMapping("/{uId}/posts/{pId}")
    public List<PostDto> getUserPostsById(@PathVariable("uId")Integer uId, @PathVariable("pId")Long pId){
        return userService.findPostsByPostId(uId, pId);
    }

    @GetMapping("/{userId}/posts/{postId}/comments")
    public List<CommentDto> getCommentsById(@PathVariable("uId")Integer uId, @PathVariable("pId")Long pId){
        return userService.findCommentsById(uId, pId);
    }

    @PostMapping("/{userId}/add-post")
    public void savePost(@PathVariable("uId")Integer uId,
                         @RequestBody Post p){
        userService.savePost(uId, p);
    }

    @PostMapping("/{userId}/posts/{postId}/add-comment")
    public void saveComment(@PathVariable("uId")Integer uId,
                            @PathVariable("pId")Long pId,
                            @RequestBody Comment c){
        userService.saveComment(uId, pId, c);
    }

}
