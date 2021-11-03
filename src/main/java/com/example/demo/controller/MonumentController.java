package com.example.demo.controller;

import com.example.demo.model.Monument;
import com.example.demo.service.MonumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/monuments")
@AllArgsConstructor
public class MonumentController {

    private final MonumentService monumentService;

    @GetMapping("/all")
    public List<Monument> getAllMonuments(){
        return monumentService.getAllMonuments();
    }

    @GetMapping
    public Monument getMonumentById(@RequestParam(value = "monumentId") String monumentId){
        return monumentService.getMonumentById(monumentId);
    }

    @PostMapping(path = "/add")
    public void addNewMonument(@RequestBody Monument monument){
        monumentService.addNewMonument(monument);
    }

    @DeleteMapping(path = "/delete/{monumentId}")
    public void deleteMonument(@PathVariable("monumentId") String monumentId){
         monumentService.deleteMonument(monumentId);
    }

    @PatchMapping(path = "/update/{monumentId}")
    public void updateMonument(@PathVariable("monumentId") String monumentId,
                               @RequestParam(required = false, value = "name") String name,
                               @RequestParam(required = false, value = "info") String info) {
        monumentService.updateMonument(monumentId,name,info);
    }

}
