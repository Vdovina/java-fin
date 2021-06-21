package com.petshop.javafin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pets")
public class Pet {
    @Id
    private final String id;
    private String category;
    private String name;
    private String[] photoUrls;
    private String[] tags;
    private String status;

    public Pet(String category, String name, String[] photoUrls, String[] tags, String status) {
        this.id = "0";
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public String getId() { return id; }
    public String getCategory() { return category; }
    public String getName() { return name; }
    public String[] getPhotoUrls() { return photoUrls; }
    public String[] getTags() { return tags; }
    public String getStatus() { return status; }

}
