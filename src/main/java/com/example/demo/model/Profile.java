package com.example.demo.model;
import java.time.LocalDate;

public class Profile {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate created;

    public Profile() {

    }

    public Profile( String firstName, String lastName, Integer age, LocalDate created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.created = created;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
