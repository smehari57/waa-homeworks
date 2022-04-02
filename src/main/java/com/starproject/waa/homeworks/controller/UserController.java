package com.starproject.waa.homeworks.controller;

import com.starproject.waa.homeworks.domain.User;
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
    public UserDto findById(@PathVariable("id") int id){
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
}
