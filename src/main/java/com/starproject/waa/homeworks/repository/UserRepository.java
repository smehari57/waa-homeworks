package com.starproject.waa.homeworks.repository;

import com.starproject.waa.homeworks.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findAll();
}
