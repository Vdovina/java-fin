package com.petshop.javafin.repository;

import com.petshop.javafin.models.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
    public List<Pet> findByCategory(String category);
    public List<Pet> findByName(String name);
}
