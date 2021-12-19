package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "monuments")
public class Monument {

    @Id
    private String _id;

    private String name;
    private String info;
    private Double rate;

    private String website;

    // x,y for any monument
    private Geo geo;

    //category for filter results with all monuments
    private String category;


    public Monument() {

    }

    public Monument(String name, String info, Double rate, Geo geo, String category, String website) {
        this.name = name;
        this.info = info;
        this.rate = rate;
        this.geo = geo;
        this.category = category;
        this.website = website;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
