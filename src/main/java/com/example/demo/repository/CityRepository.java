package com.example.demo.repository;

import com.example.demo.model.Cities;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<Cities,String> {
    List<Cities> findByName(String name);
}
