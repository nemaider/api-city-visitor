package com.example.demo.converter;

import com.example.demo.DTO.MonumentDTO;
import com.example.demo.model.Monument;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MonumentConverter {

    public static Monument dtoToEntity(MonumentDTO dto){
        Monument monument = new Monument();

        monument.set_id(dto.get_id());
        monument.setName(dto.getName());
        monument.setInfo(dto.getInfo());
        monument.setRate(dto.getRate());
        monument.setGeo(dto.getGeo());
        monument.setCategory(dto.getCategory());
        monument.setWebsite(dto.getWebsite());

        return monument;
    }

    public static List<Monument> dtoToEntity(List<MonumentDTO> dto){
        return dto.stream().map(MonumentConverter::dtoToEntity).collect(Collectors.toList());
    }

    public static MonumentDTO entityToDTO(Monument entity){
        MonumentDTO monumentDTO = new MonumentDTO();
        monumentDTO.set_id(entity.get_id());
        monumentDTO.setName(entity.getName());
        monumentDTO.setInfo(entity.getInfo());
        monumentDTO.setRate(entity.getRate());
        monumentDTO.setGeo(entity.getGeo());
        monumentDTO.setCategory(entity.getCategory());
        monumentDTO.setWebsite(entity.getWebsite());

        return monumentDTO;
    }

    public static List<MonumentDTO> entityToDTO(List<Monument> entity){
        return entity.stream().map(MonumentConverter::entityToDTO).collect(Collectors.toList());
    }
}
