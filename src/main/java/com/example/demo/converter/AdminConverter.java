package com.example.demo.converter;

import com.example.demo.DTO.usersDTO.AdminDTO;
import com.example.demo.model.users.Admin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminConverter {

    public static Admin dtoToEntity(AdminDTO dto) {
        Admin entity = new Admin();
        entity.set_id(dto.get_id());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPosition(dto.getPosition());
        entity.setProfile(dto.getProfile());

        return entity;
    }

    public static List<Admin> dtoToEntity(List<AdminDTO> dto) {
        return dto.stream().map(AdminConverter::dtoToEntity).collect(Collectors.toList());
    }

    public static AdminDTO entityToDTO(Admin entity){
        AdminDTO dto = new AdminDTO();
        dto.set_id(entity.get_id());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setPosition(entity.getPosition());
        dto.setProfile(entity.getProfile());

        return dto;
    }

    public static List<AdminDTO> entityToDTO(List<Admin> admin) {
        return admin.stream().map(AdminConverter::entityToDTO).collect(Collectors.toList());
    }
}
