package com.example.demo.service;

import com.example.demo.model.Monument;
import com.example.demo.model.Profile;
import com.example.demo.model.users.Tourist;
import com.example.demo.repository.TouristRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TouristService {
    private final TouristRepository touristRepository;
    private final MonumentService monumentService;

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    public Tourist getTouristById(String touristId) {
        return touristRepository.findById(touristId).
                orElseThrow(() -> new IllegalStateException(
                        "Tourist with "+touristId+" id does not exists."));
    }

    public void addNewTourists(Tourist tourist) {
        Profile profile = tourist.getProfile();
        profile.setCreated(LocalDate.now(ZoneId.of("Europe/Paris")));
        tourist.setProfile(profile);
        touristRepository.save(tourist);
    }

    public void deleteTourist(String touristId) {
        boolean exists = touristRepository.existsById(touristId);

        if(!exists){
            throw new IllegalStateException("Tourist with "+touristId+" does not exists.");
        }

        touristRepository.deleteById(touristId);
    }

    @Transactional
    public void changeTouristPassword(String touristId, String password) {
        Tourist tourist = touristRepository.findById(touristId).
                orElseThrow(()-> new IllegalStateException(
                        "Tourist with "+touristId+" id does not exists."));

        if(password != null &&
                password.length()>3 &&
                !Objects.equals(tourist.getPassword(), password)){
            tourist.setPassword(password);
        } else {
            throw new IllegalStateException(
                    "New password is the same like an old password for admin with "+touristId+" id or is less than 3 characters.");
        }

        touristRepository.save(tourist);
    }

    @Transactional
    public void changeTouristEmail(String touristId, String email) {
        Tourist tourist = touristRepository.findById(touristId).
                orElseThrow(() -> new IllegalStateException(
                        "Tourist with "+touristId+" id does not exists."));

        // TODO validate email has correctly form
        if(email != null &&
                !Objects.equals(tourist.getEmail(), email)){
            tourist.setEmail(email);
        } else {
            throw new IllegalStateException("Error with changing tourist email.");
        }

        touristRepository.save(tourist);
    }


    public void addMonumentToFavourite(String touristId, String monumentId) {
        Tourist tourist = getTouristById(touristId);
        Monument monument = monumentService.getMonumentById(monumentId);

        List<Monument> listOfMonuments = tourist.getFavouriteMonuments();
        if(!(listOfMonuments.contains(monument))) {
            listOfMonuments.add(monument);
            tourist.setFavouriteMonuments(listOfMonuments);
            touristRepository.save(tourist);
        } else {
            throw new IllegalStateException("Given momument("+monumentId+" id) is already exists in favourites for given tourist ("+touristId+" id).");
        }
    }

    public void removeMonumentFromFavourite(String touristId, String monumentId) {
        Tourist tourist = getTouristById(touristId);
        Monument monument = monumentService.getMonumentById(monumentId);

        List<Monument> listOfMonuments = tourist.getFavouriteMonuments();
        for(int i=0; i< listOfMonuments.size(); i++){
            if(listOfMonuments.get(i).equals(monument)){
                listOfMonuments.remove(i);
                break;
            }
        }

        tourist.setFavouriteMonuments(listOfMonuments);
        touristRepository.save(tourist);
    }

    public List<Monument> getAllFavouriteMonuments(String touristId){
        Tourist tourist = getTouristById(touristId);
        return tourist.getFavouriteMonuments();
    }
}
