package com.petshop.javafin.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Pets")
public class Pet {
    @Id
    private final ObjectId id;

    @Field(value = "category")
    private String category;

    @Field(value = "name")
    private String name;

    @Field(value = "photoUrls")
    private String[] photoUrls;

    @Field(value = "tags")
    private String[] tags;

    @Field(value = "status")
    private String status;

    public Pet(ObjectId id, String category, String name, String[] photoUrls, String[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public ObjectId getId() { return id; }
    public String getCategory() { return category; }
    public String getName() { return name; }
    public String[] getPhotoUrls() { return photoUrls; }
    public String[] getTags() { return tags; }
    public String getStatus() { return status; }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id:" + this.id
                + ", category: " + category
                + ", name: " + this.name
                + ", photoUrls: " + this.photoUrls
                + ", tags: " + this.tags
                + ", status: " + this.status;
    }
}
