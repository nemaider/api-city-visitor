package com.example.demo.service;

import com.example.demo.model.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    public List<Place> getPlaces() {
        return List.of(
                new Place(1L,
                        "Warsaw",
                        "nice city",
                        4.6),
                new Place( 2L,
                        "Kielce",
                        "stash",
                        2.7)
        );
    }
}
