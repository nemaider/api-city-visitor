package com.example.demo.model.users;

import com.example.demo.model.Monument;
import com.example.demo.model.Profile;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection = "tourists")
public class Tourist {

    @Id
    private String _id;
    @Indexed(unique = true)
    private String email;

    private Profile profile;
    private List<Monument> favouriteMonuments;

    public Tourist() {
    }

    public Tourist(String email, Profile profile, List<Monument> favouriteMonuments) {
        this.email = email;
        this.profile = profile;
        this.favouriteMonuments = favouriteMonuments;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Monument> getFavouriteMonuments() {
        return favouriteMonuments;
    }

    public void setFavouriteMonuments(List<Monument> favouriteMonuments) {
        this.favouriteMonuments = favouriteMonuments;
    }
}
