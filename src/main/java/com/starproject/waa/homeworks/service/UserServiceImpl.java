package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.domain.User;
import com.starproject.waa.homeworks.dto.PostDto;
import com.starproject.waa.homeworks.dto.UserDto;
import com.starproject.waa.homeworks.helper.ListMapper;
import com.starproject.waa.homeworks.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapper;

    @Autowired
    ListMapper<Post, PostDto> postListMapper;

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapper.mapList(userRepository.findAll(), new UserDto());
    }

    @Override
    public UserDto findById(int id) {
        return modelMapper.map(userRepository.findById(id).orElse(null), UserDto.class);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteById(int userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public void updateUser(int id, User u) {
        User user = userRepository.findById(id).orElse(null);
        user.setName(u.getName());

    }

    @Override
    public List<PostDto> findPostsById(int id) {
        return (List<PostDto>)postListMapper.mapList(userRepository.findById(id).get().getPosts(), new PostDto());
    }
}
