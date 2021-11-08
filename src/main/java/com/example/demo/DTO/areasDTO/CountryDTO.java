package com.example.demo.DTO.areasDTO;

import com.example.demo.model.areas.Province;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    private String _id;
    private String name;
    private Double rate;
    private List<Province> listOfProvinces;
}
