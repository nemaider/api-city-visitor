package com.example.demo.DTO.areasDTO;

import com.example.demo.model.Monument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private String _id;
    private String name;
    private Double rate;
    private List<Monument> listOfMonuments;
}
