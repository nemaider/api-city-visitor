package com.example.demo.controller;

import com.example.demo.DTO.FiltersDTO;
import com.example.demo.DTO.DataDTO;
import com.example.demo.DTO.MonumentDTO;
import com.example.demo.DTO.MonumentDataDTO;
import com.example.demo.converter.MonumentConverter;
import com.example.demo.service.MonumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/monuments")
@AllArgsConstructor
public class MonumentController {

    private final MonumentService monumentService;
    private final MonumentConverter converter;

    @GetMapping("/all")
    public DataDTO getAllMonuments(){
        return new DataDTO(converter.entityToDTO(monumentService.getAllMonuments()));
    }

    @GetMapping("/all-data")
    public MonumentDataDTO getAllData(){
        return new MonumentDataDTO(monumentService.getAllCategories(),converter.entityToDTO(monumentService.getAllMonuments()));

    }

    @GetMapping("/categories")
    public FiltersDTO getAllCategories(){
        return monumentService.getAllCategories();
    }

    @GetMapping
    public MonumentDTO getMonumentById(@RequestParam(value = "monumentId") String monumentId){
        return converter.entityToDTO(monumentService.getMonumentById(monumentId));
    }

    @PostMapping(path = "/add")
    public void addNewMonument(@RequestBody MonumentDTO monument){
        monumentService.addNewMonument(converter.dtoToEntity(monument));
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
