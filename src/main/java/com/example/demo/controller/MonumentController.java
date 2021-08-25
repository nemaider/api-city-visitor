package com.example.demo.controller;

import com.example.demo.model.Monument;
import com.example.demo.service.MonumentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/monuments")
@AllArgsConstructor
public class MonumentController {

    private final MonumentService monumentService;

    @GetMapping
    public List<Monument> fetchAllMonuments(){
        return monumentService.getAllMonuments();
    }

/*
    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
*/
}
