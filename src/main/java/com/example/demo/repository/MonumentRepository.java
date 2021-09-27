package com.example.demo.repository;

import com.example.demo.model.Monument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentRepository extends MongoRepository<Monument, String> {


}
