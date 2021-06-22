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
                "female",
                "Мери",
                "Ласковая кошечка",
                new String[]{""},
                new String[]{""},
                true
        );
        Pet dog = new Pet(
                new ObjectId(),
                "Dogs",
                "male",
                "Джек",
                "",
                new String[]{""},
                new String[]{""},
                true
        );
        Pet cat2 = new Pet(
                new ObjectId(),
                "Cats",
                "male",
                "Пушистик",
                "Любит покушать",
                new String[]{""},
                new String[]{""},
                true
        );
        Pet dog2 = new Pet(
                new ObjectId(),
                "Dogs",
                "male",
                "Рекс",
                "",
                new String[]{""},
                new String[]{""},
                false
        );

        this.petRepository.deleteAll();

        List<Pet> pets = Arrays.asList(cat, dog, cat2, dog2);
        System.out.println(pets);
        this.petRepository.saveAll(pets);
        System.out.println("Pets were added");

//        for (Pet pet : petRepository.findByName("Jack")) {
//            System.out.println(pet);
//        }
//        for (Pet pet : petRepository.findByCategory("Cats")) {
//            System.out.println(pet);
//        }
    }

}
