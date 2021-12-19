package com.example.demo.converter;

import com.example.demo.DTO.usersDTO.TouristDTO;
import com.example.demo.model.users.Tourist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TouristConverter {
    public static Tourist dtoToEntity(TouristDTO dto){
        Tourist entity = new Tourist();
        entity.set_id(dto.get_id());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setProfile(dto.getProfile());
        entity.setFavouriteMonuments(dto.getFavouriteMonuments());

        return entity;
    }

    public static List<Tourist> dtoToEntity(List<TouristDTO> dto){
        return dto.stream().map(TouristConverter::dtoToEntity).collect(Collectors.toList());
    }

    public static TouristDTO entityToDTO(Tourist entity){
        TouristDTO dto = new TouristDTO();
        dto.set_id(entity.get_id());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setProfile(entity.getProfile());
        dto.setFavouriteMonuments(entity.getFavouriteMonuments());

        return dto;
    }

    public static List<TouristDTO> entityToDTO(List<Tourist> entity){
        return entity.stream().map(TouristConverter::entityToDTO).collect(Collectors.toList());
    }
}
