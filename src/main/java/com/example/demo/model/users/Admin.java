package com.example.demo.model.users;

import com.example.demo.model.Profile;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "admins")
public class Admin {

    @Id
    private String _id;
    @Indexed(unique = true)
    private String email;

    private String password;
    private Profile profile;
    private String position;

    public Admin() {
    }

    public Admin(String email, String password, Profile profile, String position) {
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
