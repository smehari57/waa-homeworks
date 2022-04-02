package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.User;
import com.starproject.waa.homeworks.dto.PostDto;
import com.starproject.waa.homeworks.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(int id);

    void save(User user);

    public void deleteById(int id);

    public void updateUser(int id, User user);

    List<PostDto> findPostsById(int id);
}
