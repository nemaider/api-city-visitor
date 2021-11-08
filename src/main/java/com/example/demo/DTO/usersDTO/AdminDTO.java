package com.example.demo.DTO.usersDTO;

import com.example.demo.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private String _id;
    private String email;
    private String password;
    private Profile profile;
    private String position;
}
