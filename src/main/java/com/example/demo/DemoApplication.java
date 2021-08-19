package com.example.demo;

import com.example.demo.model.Place;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public List<Place> hello() {
        return List.of(
                new Place(1L,
                        "Warsaw",
                        "nice city",
                        4.6)
                );
    }
}
