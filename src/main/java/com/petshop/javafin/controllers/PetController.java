package com.petshop.javafin.controllers;

import com.petshop.javafin.models.Pet;
import com.petshop.javafin.repository.PetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/all")
    public List<Pet> getAll() {
        List<Pet> pets = this.petRepository.findAll();
        return pets;
    }
}
