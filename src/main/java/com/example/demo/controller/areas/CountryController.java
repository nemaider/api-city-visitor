package com.example.demo.controller.areas;

import com.example.demo.DTO.areasDTO.CountryDTO;
import com.example.demo.converter.CountryConverter;
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
    private final CountryConverter converter;

    @GetMapping("/all")
    public List<CountryDTO> getAllCountries(){
        return converter.entityToDTO(countryService.getAllCountries());
    }

    @GetMapping
    public CountryDTO getCountryById(@RequestParam(value = "countryId") String provinceId){
        return converter.entityToDTO(countryService.getCountryById(provinceId));
    }

    @GetMapping(path = "/{countryName}")
    public CountryDTO getCountryByName(@PathVariable("countryName") String countryName){
        return converter.entityToDTO(countryService.getCountryByName(countryName));
    }

    @PostMapping(path = "/add")
    public void addNewCountry(@RequestBody CountryDTO country){
        countryService.addNewCountry(converter.dtoToEntity(country));
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
