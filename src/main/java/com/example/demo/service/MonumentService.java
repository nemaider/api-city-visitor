package com.example.demo.service;


import com.example.demo.model.Monument;
import com.example.demo.repository.MonumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonumentService {

    private final MonumentRepository monumentRepository;

    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }



}
