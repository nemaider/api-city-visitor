package com.example.demo.controller;

import com.example.demo.DTO.MonumentDTO;
import com.example.demo.converter.MonumentConverter;
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
    private final MonumentConverter converter;

    @GetMapping("/all")
    public List<MonumentDTO> getAllMonuments(){
        return converter.entityToDTO(monumentService.getAllMonuments());

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
