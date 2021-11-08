package com.example.demo.converter;

import com.example.demo.DTO.areasDTO.CountryDTO;
import com.example.demo.model.areas.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryConverter {

    public static Country dtoToEntity(CountryDTO dto){
        Country entity = new Country();
        entity.set_id(dto.get_id());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setListOfProvinces(dto.getListOfProvinces());

        return entity;
    }

    public static List<Country> dtoToEntity(List<CountryDTO> dto){
        return dto.stream().map(CountryConverter::dtoToEntity).collect(Collectors.toList());
    }


    public static CountryDTO entityToDTO(Country entity){
        CountryDTO dto = new CountryDTO();
        dto.set_id(entity.get_id());
        dto.setName(entity.getName());
        dto.setRate(entity.getRate());
        dto.setListOfProvinces(entity.getListOfProvinces());

        return dto;
    }

    public static List<CountryDTO> entityToDTO(List<Country> entity){
        return entity.stream().map(CountryConverter::entityToDTO).collect(Collectors.toList());
    }
}
