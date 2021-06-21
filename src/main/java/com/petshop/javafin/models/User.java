package com.petshop.javafin.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
    private final String id;
    private String username;
    private String email;
    private String password;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.username = name;
        this.email = email;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }


}
