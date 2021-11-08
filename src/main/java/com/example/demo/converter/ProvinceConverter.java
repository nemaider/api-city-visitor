package com.example.demo.converter;

import com.example.demo.DTO.areasDTO.ProvinceDTO;
import com.example.demo.model.areas.Province;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinceConverter {
    public static Province dtoToEntity(ProvinceDTO dto){
        Province entity = new Province();
        entity.set_id(dto.get_id());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setListOfCities(dto.getListOfCities());

        return entity;
    }

    public static List<Province> dtoToEntity(List<ProvinceDTO> dto){
        return dto.stream().map(ProvinceConverter::dtoToEntity).collect(Collectors.toList());
    }

    public static ProvinceDTO entityToDTO(Province entity){
        ProvinceDTO dto = new ProvinceDTO();
        dto.set_id(entity.get_id());
        dto.setName(entity.getName());
        dto.setRate(entity.getRate());
        dto.setListOfCities(entity.getListOfCities());

        return dto;
    }

    public static List<ProvinceDTO> entityToDTO(List<Province> entity){
        return entity.stream().map(ProvinceConverter::entityToDTO).collect(Collectors.toList());
    }
}
