package com.example.demo.controller.areas;


import com.example.demo.DTO.areasDTO.ProvinceDTO;
import com.example.demo.converter.ProvinceConverter;
import com.example.demo.model.areas.Province;
import com.example.demo.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/provinces")
@AllArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;
    private final ProvinceConverter converter;

    @GetMapping("/all")
    public List<ProvinceDTO> getAllProvinces(){
        return converter.entityToDTO(provinceService.getAllProvinces());
    }

    @GetMapping
    public ProvinceDTO getProvinceById(@RequestParam(value = "provinceId") String provinceId){
        return converter.entityToDTO(provinceService.getProvinceById(provinceId));
    }

    @GetMapping(path = "/{provinceName}")
    public ProvinceDTO getProvinceByName(@PathVariable("provinceName") String provinceName){
        return converter.entityToDTO(provinceService.getProvinceByName(provinceName));
    }

    @PostMapping(path = "/add")
    public void addNewProvince(@RequestBody ProvinceDTO province){
        provinceService.addNewProvince(converter.dtoToEntity(province));
    }

    @DeleteMapping(path = "/delete/{provinceId}")
    public void deleteProvince(@PathVariable("provinceId") String provinceId){
        provinceService.deleteProvince(provinceId);
    }


    @PatchMapping(path = "/update/{provinceId}")
    public void updateProvince(@PathVariable("provinceId") String provinceId,
                               @RequestParam(required = false, value = "name") String name,
                               @RequestParam(required = false, value = "rate") Double rate){
        provinceService.updateProvince(provinceId,name,rate);
    }

    @PatchMapping(path = "/attach/city-to-province")
    public void attachCityToProvince(@RequestParam(value = "provinceId") String provinceId,
                                     @RequestParam(value = "cityId") String cityId){
        provinceService.attachCityToProvince(provinceId,cityId);
    }

    @PatchMapping(path = "/remove/city-from-province")
    public void removeCityFromProvince(@RequestParam(value = "provinceId") String provinceId,
                                       @RequestParam(value = "cityId") String cityId){
        provinceService.removeCityFromProvince(provinceId,cityId);
    }


}
