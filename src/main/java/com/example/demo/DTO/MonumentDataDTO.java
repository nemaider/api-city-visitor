package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonumentDataDTO {
    private FiltersDTO filtersDTO;
    private List<MonumentDTO> MonumentDTO;
}
