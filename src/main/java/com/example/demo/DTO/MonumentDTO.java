package com.example.demo.DTO;

import com.example.demo.model.Geo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonumentDTO {
    private String _id;
    private String name;
    private String info;
    private Double rate;
    private Geo geo;
    private String category;
    private String website;
}
