package com.starproject.waa.homeworks.repository;

import com.starproject.waa.homeworks.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Integer> {

    List<Logger> findAll();
}
