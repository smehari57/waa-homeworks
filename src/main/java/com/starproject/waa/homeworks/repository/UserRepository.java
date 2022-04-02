package com.starproject.waa.homeworks.repository;

import com.starproject.waa.homeworks.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findAll();

    @Query(value = "SELECT u FROM User u WHERE u.posts.size > 1")
    public  List<User> usersWithMoreThanOnePosts();


}
