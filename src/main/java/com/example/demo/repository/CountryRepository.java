package com.example.demo.repository;

import com.example.demo.model.areas.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {
}
