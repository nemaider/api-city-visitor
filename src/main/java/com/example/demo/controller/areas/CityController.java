package com.example.demo.controller.areas;

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

    @GetMapping("/all")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping
    public City getCityById(@RequestParam(value = "cityId") String cityId){
        return cityService.getCityById(cityId);
    }

    @GetMapping(path = "/{cityName}")
    public City getCityByName(@PathVariable("cityName") String cityName){
        return cityService.getCityByName(cityName);
    }

    @PostMapping(path = "/add")
    public void addNewCity(@RequestBody City city){
        cityService.addNewCity(city);
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
