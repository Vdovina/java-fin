package com.petshop.javafin.controllers;

import com.petshop.javafin.models.Pet;
import com.petshop.javafin.models.User;
import com.petshop.javafin.repository.PetRepository;
import com.petshop.javafin.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MainController {
    private UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница | Наш сайт");
        return "home";
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users = this.userRepository.findAll();
        System.out.println(users);
        return users;
    }
}
