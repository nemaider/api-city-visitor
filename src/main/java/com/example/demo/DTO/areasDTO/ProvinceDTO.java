package com.example.demo.DTO.areasDTO;

import com.example.demo.model.areas.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDTO {
    private String _id;
    private String name;
    private Double rate;
    private List<City> listOfCities;
}
