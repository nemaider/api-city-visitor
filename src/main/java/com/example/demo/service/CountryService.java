package com.example.demo.service;

import com.example.demo.model.areas.Country;
import com.example.demo.model.areas.Province;
import com.example.demo.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final ProvinceService provinceService;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country getCountryById(String countryId){
        return countryRepository.findById(countryId).
                orElseThrow(() -> new IllegalStateException("country with "+countryId+" does not exists."));
    }

    public Country getCountryByName(String countryName){
        List<Country> listOfCountries = countryRepository.findAll();

        for (Country country : listOfCountries){
            if(country.getName().equals(countryName)){
                return countryRepository.findById(country.get_id()).
                        orElseThrow(() -> new IllegalStateException("country with "+countryName+" name does not exists."));
            }
        }
        return null;
    }

    public void addNewCountry(Country country) {
        countryRepository.save(country);
    }


    public void deleteCountry(String countryId) {
        boolean exists = countryRepository.existsById(countryId);
        if(!exists) {
            throw new IllegalStateException("country with "+countryId+" id does not exists.");
        }
        countryRepository.deleteById(countryId);
    }

    @Transactional
    public void updateCountry(String countryId,
                              String name,
                              Double rate) {
        Country country = countryRepository.findById(countryId).
                orElseThrow(() -> new IllegalStateException("country with "+countryId+" id does not exists."));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(country.getName(),name)){
            country.setName(name);
        }

        if(!rate.isNaN() &&
                rate >= 0 &&
                !Objects.equals(country.getRate(),rate)){
            country.setRate(rate);
        }

        countryRepository.save(country);
    }


    public void attachProvinceToCountry(String countryId, String provinceId) {
        Country country = getCountryById(countryId);
        Province province = provinceService.getProvinceById(provinceId);

        List<Province> listOfProvinces = country.getListOfProvinces();
        if(!listOfProvinces.contains(province)){
            listOfProvinces.add(province);
            country.setListOfProvinces(listOfProvinces);
            countryRepository.save(country);
        } else {
            throw new IllegalStateException("Given province("+provinceId+" id) is already exists in provinces list for this country ("+countryId+" id).");
        }
    }

    public void removeProvinceFromCountry(String countryId, String provinceId) {
        Country country = getCountryById(countryId);
        Province province = provinceService.getProvinceById(provinceId);

        List<Province> listOfProvinces = country.getListOfProvinces();
        for(int i=0; i<listOfProvinces.size(); i++){
            if(listOfProvinces.get(i).equals(province)){
                listOfProvinces.remove(i);
                break;
            }
        }

        country.setListOfProvinces(listOfProvinces);
        countryRepository.save(country);
    }
}
