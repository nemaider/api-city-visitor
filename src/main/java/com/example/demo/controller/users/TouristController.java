package com.example.demo.controller.users;
import com.example.demo.model.users.Tourist;
import com.example.demo.service.TouristService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tourists")
@AllArgsConstructor
public class TouristController {
    TouristService touristService;

    @GetMapping("/all")
    public List<Tourist> getAllTourists() {
        return touristService.getAllTourists();
    }

    @GetMapping
    public Tourist getTouristById(@RequestParam(value = "touristId") String touristId){
        return touristService.getTouristById(touristId);
    }

    @PostMapping(path = "/add")
    public void addNewTourist(@RequestBody Tourist tourist){
        touristService.addNewTourists(tourist);
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
