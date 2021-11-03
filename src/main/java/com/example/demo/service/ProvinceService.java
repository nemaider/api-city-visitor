package com.example.demo.service;

import com.example.demo.model.places.City;
import com.example.demo.model.places.Province;
import com.example.demo.repository.ProvinceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final CityService cityService;


    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(String provinceId) {
        return provinceRepository.findById(provinceId).
                orElseThrow(() -> new IllegalStateException("province with "+provinceId+" id does not exists."));
    }


    public Province getProvinceByName(String provinceName) {
        List<Province> listOfProvinces = provinceRepository.findAll();

        for (Province province : listOfProvinces){
            if(province.getName().equals(provinceName)){
                return provinceRepository.findById(province.get_id()).
                        orElseThrow(() -> new IllegalStateException("province with "+provinceName+" name does not exists."));
            }
        }
        return null;
    }


    public void addNewProvince(Province province) {
        provinceRepository.save(province);
    }

    public void deleteProvince(String provinceId) {
        boolean exists = provinceRepository.existsById(provinceId);
        if(!exists) {
            throw new IllegalStateException("province with "+provinceId+" id does not exists.");
        }
        provinceRepository.deleteById(provinceId);
    }

    @Transactional
    public void updateProvince(String provinceId,
                               String name,
                               Double rate) {
        Province province = provinceRepository.findById(provinceId).
                orElseThrow(() -> new IllegalStateException("province with "+provinceId+" id does not exists."));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(province.getName(),name)){
            province.setName(name);
        }

        if(!rate.isNaN() &&
                rate >= 0 &&
                !Objects.equals(province.getRate(),rate)){
            province.setRate(rate);
        }

        provinceRepository.save(province);
    }


    public void attachCityToProvince(String provinceId, String cityId) {
        Province province = getProvinceById(provinceId);
        City city = cityService.getCityById(cityId);

        List<City> listOfCities = province.getListOfCities();
        if(!listOfCities.contains(city)){
            listOfCities.add(city);
            province.setListOfCities(listOfCities);
            provinceRepository.save(province);
        } else {
            throw new IllegalStateException("Given city("+cityId+" id) is already exists in cities list for this province ("+provinceId+" id).");
        }
    }

    public void removeCityFromProvince(String provinceId, String cityId) {
        Province province = getProvinceById(provinceId);
        City city = cityService.getCityById(cityId);

        List<City> listOfCities = province.getListOfCities();
        for(int i=0; i<listOfCities.size(); i++){
            if(listOfCities.get(i).equals(city)){
                listOfCities.remove(i);
                break;
            }
        }

        province.setListOfCities(listOfCities);
        provinceRepository.save(province);
    }
}
