package com.starproject.waa.homeworks.repository;

import com.starproject.waa.homeworks.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findAll();

    @Query(value = "SELECT u FROM User u WHERE u.posts.size > 1")
    public  List<User> usersWithMoreThanOnePosts();

    @Query(value = "select u from User u Join u.posts p where p.title = :title")
    public List<User> getUsersByPostTitle(@Param("title") String title);
}
