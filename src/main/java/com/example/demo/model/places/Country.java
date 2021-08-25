package com.example.demo.model.places;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "countries")
public class Country {
    @Id
    private String _id;

    private String name;
    private Double rate;
    private List<Province> listOfProvinces;

    public Country() {
    }

    public Country(String name, Double rate, List<Province> listOfProvinces) {
        this.name = name;
        this.rate = rate;
        this.listOfProvinces = listOfProvinces;
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

    public List<Province> getListOfProvinces() {
        return listOfProvinces;
    }

    public void setListOfProvinces(List<Province> listOfProvinces) {
        this.listOfProvinces = listOfProvinces;
    }
}
