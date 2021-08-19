package com.example.demo.model;

public class Place {
    private Long id;
    private String name;
    private String info;
    private Double rate;

    public Place() {

    }

    public Place(Long id,
                 String name,
                 String info,
                 Double rate) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.rate = rate;
    }

    public Place(String name,
                 String info,
                 Double rate) {
        this.name = name;
        this.info = info;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public Double getRate() {
        return rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", rate=" + rate +
                '}';
    }
}
