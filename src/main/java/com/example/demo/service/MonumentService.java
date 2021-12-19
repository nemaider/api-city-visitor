package com.example.demo.service;


import com.example.demo.DTO.FiltersDTO;
import com.example.demo.model.Monument;
import com.example.demo.repository.MonumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MonumentService {

    private final MonumentRepository monumentRepository;

    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }

    public FiltersDTO getAllCategories(){
        FiltersDTO filtersDTO = new FiltersDTO(monumentRepository.findAll()
                .stream().map(Monument::getCategory)
                .collect(Collectors.toSet()));
        return filtersDTO;
    }

    public Monument getMonumentById(String monumentId) {
        return monumentRepository.findById(monumentId)
                .orElseThrow(() -> new IllegalStateException(
                        "monument with " + monumentId + " does not exists."));
    }

    public void addNewMonument(Monument monument) {
        monumentRepository.save(monument);
    }

    public void deleteMonument(String monumentId) {
        boolean exists = monumentRepository.existsById(monumentId);
        if (!exists) {
            throw new IllegalStateException("Monument with " + monumentId +" id does not exists.");
        }
        monumentRepository.deleteById(monumentId);

    }

    @Transactional
    public void updateMonument(String monumentId,
                               String name,
                               String info) {
        Monument monument = monumentRepository.findById(monumentId)
                .orElseThrow(() -> new IllegalStateException(
                        "monument with " + monumentId + " does not exists."));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(monument.getName(), name)) {
            monument.setName(name);
        }

        if (info != null &&
                info.length() > 0 &&
                !Objects.equals(monument.getInfo(), info)) {
            monument.setInfo(info);
        }

        monumentRepository.save(monument);
    }


}
