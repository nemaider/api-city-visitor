package com.example.demo.controller.areas;

import com.example.demo.model.areas.Country;
import com.example.demo.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/all")
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping
    public Country getCountryById(@RequestParam(value = "countryId") String provinceId){
        return countryService.getCountryById(provinceId);
    }

    @GetMapping(path = "/{countryName}")
    public Country getCountryByName(@PathVariable("countryName") String countryName){
        return countryService.getCountryByName(countryName);
    }

    @PostMapping(path = "/add")
    public void addNewCountry(@RequestBody Country country){
        countryService.addNewCountry(country);
    }

    @DeleteMapping(path = "/delete/{countryId}")
    public void deleteCountry(@PathVariable("countryId") String countryId){
        countryService.deleteCountry(countryId);
    }


    @PatchMapping(path = "/update/{countryId}")
    public void updateCountry(@PathVariable("countryId") String countryId,
                               @RequestParam(required = false, value = "name") String name,
                               @RequestParam(required = false, value = "rate") Double rate){
        countryService.updateCountry(countryId,name,rate);
    }

    @PatchMapping(path = "/attach/province-to-country")
    public void attachProvinceToCountry(@RequestParam(value = "countryId") String countryId,
                                        @RequestParam(value = "provinceId") String provinceId){
        countryService.attachProvinceToCountry(countryId,provinceId);
    }

    @PatchMapping(path = "/remove/province-from-country")
    public void removeProvinceFromCountry(@RequestParam(value = "countryId") String countryId,
                                          @RequestParam(value = "provinceId") String provinceId){
        countryService.removeProvinceFromCountry(countryId,provinceId);
    }

}
