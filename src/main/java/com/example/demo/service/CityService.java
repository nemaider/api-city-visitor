package com.example.demo.service;

import com.example.demo.model.Monument;
import com.example.demo.model.places.City;
import com.example.demo.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final MonumentService monumentService;


    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    public City getCityById(String cityId) {
        return cityRepository.findById(cityId).
                orElseThrow(() -> new IllegalStateException("city with "+cityId+" id does not exists."));
    }


    public City getCityByName(String cityName) {
        List<City> listOfCities = cityRepository.findAll();

        for (City city : listOfCities) {
            if (city.getName().equals(cityName)) {
                return cityRepository.findById(city.get_id()).
                        orElseThrow(() -> new IllegalStateException("city with " + cityName + " name does not exists."));
            }
        }
        return null;
    }


    public void addNewCity(City city) {
        cityRepository.save(city);
    }

    public void deleteCity(String cityId) {
        boolean exists = cityRepository.existsById(cityId);
        if(!exists) {
            throw new IllegalStateException("city with "+cityId+" id does not exists.");
        }
        cityRepository.deleteById(cityId);
    }

    @Transactional
    public void updateCity(String cityId,
                           String name,
                           Double rate) {
        City city = cityRepository.findById(cityId).
                orElseThrow(() -> new IllegalStateException("city with "+cityId+" id does not exists."));

        if(name != null &&
                name.length() > 0 &&
                    !Objects.equals(city.getName(),name)){
            city.setName(name);
        }

        if(!rate.isNaN() &&
                rate >= 0 &&
                    !Objects.equals(city.getRate(),rate)){
            city.setRate(rate);
        }

        cityRepository.save(city);
    }

    public void attachMonumentToCity(String cityId, String monumentId) {
        City city = getCityById(cityId);
        Monument monument = monumentService.getMonumentById(monumentId);

        List<Monument> listOfMonuments = city.getListOfMonuments();
        if(!listOfMonuments.contains(monument)){
            listOfMonuments.add(monument);
            city.setListOfMonuments(listOfMonuments);
            cityRepository.save(city);
        } else {
            throw new IllegalStateException("Given momument("+monumentId+" id) is already exists in monuments for this city ("+cityId+" id).");
        }
    }


    public void removeMonumentFromCity(String cityId, String monumentId) {
        City city = getCityById(cityId);
        Monument monument = monumentService.getMonumentById(monumentId);

        List<Monument> listOfMonuments = city.getListOfMonuments();
        for(int i=0; i<listOfMonuments.size(); i++){
            if(listOfMonuments.get(i).equals(monument)){
                listOfMonuments.remove(i);
                break;
            }
        }

        city.setListOfMonuments(listOfMonuments);
        cityRepository.save(city);
    }
}
