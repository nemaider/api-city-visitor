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

    private Profile profile;
    private String position;
}
