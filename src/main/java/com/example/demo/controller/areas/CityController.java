package com.example.demo.controller.areas;

import com.example.demo.DTO.areasDTO.CityDTO;
import com.example.demo.converter.CityConverter;
import com.example.demo.model.areas.City;
import com.example.demo.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;
    private final CityConverter converter;

    @GetMapping("/all")
    public List<CityDTO> getAllCities() {
        return converter.entityToDTO(cityService.getAllCities());
    }

    @GetMapping
    public CityDTO getCityById(@RequestParam(value = "cityId") String cityId){
        return converter.entityToDTO(cityService.getCityById(cityId));
    }

    @GetMapping(path = "/{cityName}")
    public CityDTO getCityByName(@PathVariable("cityName") String cityName){
        return converter.entityToDTO(cityService.getCityByName(cityName));
    }

    @PostMapping(path = "/add")
    public void addNewCity(@RequestBody CityDTO city){
        cityService.addNewCity(converter.dtoToEntity(city));
    }

    @DeleteMapping(path = "/delete/{cityId}")
    public void deleteCity(@PathVariable("cityId") String cityId){
        cityService.deleteCity(cityId);
    }

    @PatchMapping(path = "/update/{cityId}")
    public void updateCity(@PathVariable("cityId") String cityId,
                           @RequestParam(required = false, value = "name") String name,
                           @RequestParam(required = false, value = "rate") Double rate){
        cityService.updateCity(cityId, name, rate);
    }

    @PatchMapping(path = "/attach/monument-to-city")
    public void attachMonumentToCity(@RequestParam(value = "cityId") String cityId,
                                     @RequestParam(value = "monumentId") String monumentId){
        cityService.attachMonumentToCity(cityId,monumentId);
    }

    @PatchMapping(path = "/remove/monument-from-city")
    public void removeMonumentFromCity(@RequestParam(value = "cityId") String cityId,
                                       @RequestParam(value = "monumentId") String monumentId){
        cityService.removeMonumentFromCity(cityId,monumentId);
    }



}
