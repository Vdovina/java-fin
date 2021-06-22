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

    @Field(value = "sex")
    private String sex;

    @Field(value = "name")
    private String name;

    @Field(value = "description")
    private String description;

    @Field(value = "photoUrls")
    private String[] photoUrls;

    @Field(value = "tags")
    private String[] tags;

    @Field(value = "available")
    private Boolean available;

    public Pet(ObjectId id, String category, String sex, String name, String description, String[] photoUrls, String[] tags, Boolean available) {
        this.id = id;
        this.category = category;
        this.sex = sex;
        this.name = name;
        this.description = description;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.available = available;
    }

    public Boolean isCat() { return category == "Cats"; }
    public Boolean isDog() { return category == "Dogs"; }

    public ObjectId getId() { return id; }
    public String getCategory() { return category; }
    public String getName() { return name; }
    public String[] getPhotoUrls() { return photoUrls; }
    public String[] getTags() { return tags; }
    public Boolean getAvailable() { return available; }
    public String getSex() {
        return sex;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
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
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "id:" + this.id
                + ", category: " + category
                + ", name: " + this.name
                + ", photoUrls: " + this.photoUrls
                + ", tags: " + this.tags
                + ", available: " + this.available;
    }
}
