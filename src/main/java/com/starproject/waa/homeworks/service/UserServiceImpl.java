package com.starproject.waa.homeworks.service;

import com.starproject.waa.homeworks.domain.Comment;
import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.domain.User;
import com.starproject.waa.homeworks.dto.CommentDto;
import com.starproject.waa.homeworks.dto.PostDto;
import com.starproject.waa.homeworks.dto.UserDto;
import com.starproject.waa.homeworks.helper.ListMapper;
import com.starproject.waa.homeworks.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private final PostService postService;

    @Autowired
    ListMapper<User, UserDto> listMapper;

    @Autowired
    ListMapper<Post, PostDto> postListMapper;

    @Autowired
    ListMapper<Comment, CommentDto> commentListMapper;

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(PostService postService, UserRepository userRepository) {
        this.postService = postService;
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
        userRepository.save(user);

    }

    @Override
    public List<PostDto> findPostsById(int id) {
        return (List<PostDto>)postListMapper.mapList(userRepository.findById(id).get().getPosts(), new PostDto());
    }

    @Override
    public List<UserDto> usersWithMoreThanOnePosts() {
        return  (List<UserDto>)listMapper.mapList(userRepository.usersWithMoreThanOnePosts(),new UserDto());
    }

    @Override
    public List<PostDto> findPostsByPostId(Integer uId, Long pId) {
        List<Post> posts = userRepository.findById(uId).orElse(null).getPosts()
                .stream()
                .filter(p -> p.getId() == pId)
                .collect(Collectors.toList());
        return (List<PostDto>)postListMapper.mapList(posts, new PostDto());
    }

    @Override
    public List<CommentDto> findCommentsById(Integer userId, Long postId) {
        List<Post> posts = userRepository.findById(userId).orElse(null).getPosts();
        List<Comment> comments = posts.stream()
                .filter(p -> p.getId() == postId)
                .flatMap(p -> p.getComments().stream())
                .collect(Collectors.toList());
        return (List<CommentDto>)commentListMapper.mapList(comments, new CommentDto());
    }

    @Transactional
    @Override
    public void savePost(Integer userId, Post post) {
        User user = userRepository.findById(userId).orElse(null);
        user.getPosts().add(post);
    }

    @Transactional
    @Override
    public void saveComment(Integer userId, Long postId, Comment comment) {
        User user = userRepository.findById(userId).orElse(null);
        user.getPosts().stream()
                .filter(p -> p.getId() == postId)
                .findFirst().orElse(null)
                .getComments().add(comment);
    }

    @Override
    public List<PostDto> getAllPostsThatMatchsThisTitle(String title) {
        return postService.getAllPostsThatMatchsThisTitle(title);
    }

}

