package com.petshop.javafin.controllers;

import com.petshop.javafin.models.Pet;
import com.petshop.javafin.repository.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PetsController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping("/pets")
    public String getAllPets(Model model)
    {
        Iterable<Pet> pets = petRepository.findAll();
        model.addAttribute("pets", pets);
        return "pets";
    }

    @GetMapping("/pets/add")
    public String getAddNewPet(Model model)
    {
        Iterable<Pet> pets = petRepository.findAll();
        model.addAttribute("pets", pets);
        return "addPet";
    }

    @PostMapping("/pets/add")
    public String postAddNewPet(@RequestParam String category,
                                @RequestParam String name,
                                @RequestParam String status, Model model)
    {
        Pet pet = new Pet(new ObjectId(), category, name, new String[]{""}, new String[]{""}, status);
        petRepository.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pet/{id}")
    public String getPet(@PathVariable(value = "id") ObjectId id, Model model)
    {
        if (!petRepository.existsById(id.toString()))
        { return "redirect:/error"; }

        Optional<Pet> pet = petRepository.findById(id.toString());
        ArrayList<Pet> res = new ArrayList<>();
        pet.ifPresent(res::add);
        model.addAttribute("pet", res);
        return "petDetails";
    }

    @GetMapping("/pet/{id}/edit")
    public String getEditPet(@PathVariable(value = "id") ObjectId id, Model model)
    {
        if (!petRepository.existsById(id.toString()))
        { return "redirect:/error"; }

        Optional<Pet> pet = petRepository.findById(id.toString());
        ArrayList<Pet> res = new ArrayList<>();
        pet.ifPresent(res::add);
        model.addAttribute("pet", res);
        return "editPet";
    }

    @PostMapping("/pet/{id}/edit")
    public String postEditNewPet(@PathVariable(value = "id") ObjectId id,
                                @RequestParam String category,
                                @RequestParam String name,
                                @RequestParam String status, Model model)
    {
        Pet pet = petRepository.findById(id.toString()).orElseThrow();
        pet.setCategory(category);
        pet.setName(name);
        pet.setStatus(status);
        petRepository.save(pet);
        return "redirect:/pet/{id}";
    }

    @PostMapping("/pet/{id}/delete")
    public String postDeleteNewPet(@PathVariable(value = "id") ObjectId id, Model model)
    {
        Pet pet = petRepository.findById(id.toString()).orElseThrow();
        petRepository.delete(pet);
        return "redirect:/pets";
    }
}
