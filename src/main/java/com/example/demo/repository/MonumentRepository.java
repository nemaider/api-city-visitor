package com.example.demo.repository;

import com.example.demo.model.Monument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MonumentRepository extends MongoRepository<Monument, Long> {


}
