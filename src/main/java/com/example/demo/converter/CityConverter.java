package com.example.demo.converter;

import com.example.demo.DTO.areasDTO.CityDTO;
import com.example.demo.model.areas.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityConverter {
    public static City dtoToEntity(CityDTO dto){
        City entity = new City();
        entity.set_id(dto.get_id());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setListOfMonuments(dto.getListOfMonuments());

        return entity;
    }

    public static List<City> dtoToEntity(List<CityDTO> dto){
        return dto.stream().map(CityConverter::dtoToEntity).collect(Collectors.toList());
    }

    public static CityDTO entityToDTO(City entity){
        CityDTO dto = new CityDTO();
        dto.set_id(entity.get_id());
        dto.setName(entity.getName());
        dto.setRate(entity.getRate());
        dto.setListOfMonuments(entity.getListOfMonuments());

        return dto;
    }

    public static List<CityDTO> entityToDTO(List<City> entity){
        return entity.stream().map(CityConverter::entityToDTO).collect(Collectors.toList());
    }
}
