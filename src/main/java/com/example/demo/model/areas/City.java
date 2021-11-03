package com.example.demo.model.areas;

import com.example.demo.model.Monument;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "cities")
public class City {
    @Id
    private String _id;

    private String name;
    private Double rate;
    private List<Monument> listOfMonuments;

    public City(String name, Double rate, List<Monument> listOfMonuments) {
        this.name = name;
        this.rate = rate;
        this.listOfMonuments = listOfMonuments;
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

    public List<Monument> getListOfMonuments() {
        return listOfMonuments == null ? new ArrayList<>() : listOfMonuments;
    }

    public void setListOfMonuments(List<Monument> listOfMonuments) {
        this.listOfMonuments = listOfMonuments;
    }
}
