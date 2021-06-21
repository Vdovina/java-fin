package com.petshop.javafin.repository;

import com.petshop.javafin.models.Pet;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    private PetRepository petRepository;

    public DBSeeder(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Pet cat = new Pet(
                new ObjectId(),
                "Cats",
                "Mary",
                new String[]{""},
                new String[]{""},
                "available"
        );
        Pet dog = new Pet(
                new ObjectId(),
                "Dogs",
                "Jack",
                new String[]{""},
                new String[]{""},
                "available"
        );

        this.petRepository.deleteAll();

        List<Pet> pets = Arrays.asList(cat, dog);
        System.out.println(pets);
        this.petRepository.saveAll(pets);
        System.out.println("Pets were added");

        for (Pet pet : petRepository.findByName("Jack")) {
            System.out.println(pet);
        }
        for (Pet pet : petRepository.findByCategory("Cats")) {
            System.out.println(pet);
        }
    }

}
