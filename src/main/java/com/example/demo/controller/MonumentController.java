package com.example.demo.controller;

import com.example.demo.model.Monument;
import com.example.demo.model.users.Tourist;
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

    @PostMapping()
    public void addNewMonument(@RequestBody Monument monument){
        monumentService.addNewMonument(monument);
    }

    @DeleteMapping(path = "{monumentId}")
    public void deleteMonument(@PathVariable("monumentId") String monumentId){
         monumentService.deleteMonument(monumentId);
    }

    @PutMapping(path = "{monumentId}")
    public void updateMonument(@PathVariable("monumentId") String monumentId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String info) {
        monumentService.updateMonument(monumentId,name,info);
    }
/*
    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
*/
}
