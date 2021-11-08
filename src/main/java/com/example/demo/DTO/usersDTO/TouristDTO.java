package com.example.demo.DTO.usersDTO;

import com.example.demo.model.Monument;
import com.example.demo.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TouristDTO {
    private String _id;
    private String email;
    private String password;
    private Profile profile;
    private List<Monument> favouriteMonuments;
}
