package com.example.demo.controller.areas;


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

    @GetMapping("/all")
    public List<Province> getAllProvinces(){
        return provinceService.getAllProvinces();
    }

    @GetMapping
    public Province getProvinceById(@RequestParam(value = "provinceId") String provinceId){
        return provinceService.getProvinceById(provinceId);
    }

    @GetMapping(path = "/{provinceName}")
    public Province getProvinceByName(@PathVariable("provinceName") String provinceName){
        return provinceService.getProvinceByName(provinceName);
    }

    @PostMapping(path = "/add")
    public void addNewProvince(@RequestBody Province province){
        provinceService.addNewProvince(province);
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
