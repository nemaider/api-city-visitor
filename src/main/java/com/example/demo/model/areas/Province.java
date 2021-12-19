package com.example.demo.model.areas;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "provinces")
public class Province {
    @Id
    private String _id;

    private String name;
    private Double rate;
    @DBRef(lazy = true)
    private List<City> listOfCities;

    public Province() {
    }

    public Province(String name, Double rate, List<City> listOfCities) {
        this.name = name;
        this.rate = rate;
        this.listOfCities = listOfCities;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<City> getListOfCities() {
        return listOfCities == null ? new ArrayList<>() : listOfCities;
    }

    public void setListOfCities(List<City> listOfCities) {
        this.listOfCities = listOfCities;
    }
}


