package com.starproject.waa.homeworks.repository;

import com.starproject.waa.homeworks.domain.Post;
import com.starproject.waa.homeworks.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    public List<Post> findAll();

    @Query(value = "SELECT p FROM Post p WHERE p.title = :title")
    public List<Post> getAllPostsThatMatchsThisTitle(String title);

//    List<Post> findPostByTitle(String title);

//    @Query(value = "select u from User u Join u.posts p where p.title = :title")
//    public List<User> getUsersByPostTitle(@Param("title") String title);
}
