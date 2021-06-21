package com.petshop.javafin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "Users")
public class User {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String password;

    public User() {}

    public User(String name, String email, String password) {
        this.username = name;
        this.email = email;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setName(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}