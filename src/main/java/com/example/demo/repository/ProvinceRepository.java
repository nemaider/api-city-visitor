package com.example.demo.repository;

import com.example.demo.model.places.Province;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinceRepository extends MongoRepository<Province, String> {
}
