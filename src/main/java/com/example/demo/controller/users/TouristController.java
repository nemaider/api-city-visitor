package com.example.demo.controller.users;
import com.example.demo.DTO.usersDTO.TouristDTO;
import com.example.demo.converter.TouristConverter;
import com.example.demo.model.users.Tourist;
import com.example.demo.service.TouristService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tourists")
@AllArgsConstructor
public class TouristController {
    private final TouristService touristService;
    private final TouristConverter converter;

    @GetMapping("/all")
    public List<TouristDTO> getAllTourists() {
        return converter.entityToDTO(touristService.getAllTourists());
    }

    @GetMapping
    public TouristDTO getTouristById(@RequestParam(value = "touristId") String touristId){
        return converter.entityToDTO(touristService.getTouristById(touristId));
    }

    @PostMapping(path = "/add")
    public void addNewTourist(@RequestBody TouristDTO tourist){
        touristService.addNewTourists(converter.dtoToEntity(tourist));
    }

    @DeleteMapping("/delete/{touristId}")
    public void deleteTourist(@PathVariable("touristId") String touristId){
        touristService.deleteTourist(touristId);
    }

    @PatchMapping(path = "/change-password/{touristId}")
    public void changeTouristPassword(@PathVariable("touristId") String touristId,
                                    @RequestParam(value = "password") String password){
        touristService.changeTouristPassword(touristId,password);
    }

    @PatchMapping("/change-email/{touristId}")
    public void changeTouristEmail(@PathVariable("touristId") String touristId,
                                   @RequestParam(value = "email") String email){
        touristService.changeTouristEmail(touristId,email);
    }

    @PatchMapping("/add-to-favourite")
    public void addMonumentToFavourite(@RequestParam(value = "touristId") String touristId,
                                       @RequestParam(value = "monumentId") String monumentId){
        touristService.addMonumentToFavourite(touristId,monumentId);
    }

    @PatchMapping("/remove-from-favourite")
    public void removeMonumentFromFavourite(@RequestParam(value = "touristId") String touristId,
                                            @RequestParam(value = "monumentId") String monumentId){
        touristService.removeMonumentFromFavourite(touristId,monumentId);
    }


}
