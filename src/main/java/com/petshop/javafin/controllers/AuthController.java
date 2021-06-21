package com.petshop.javafin.controllers;

import com.petshop.javafin.models.User;
import com.petshop.javafin.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class AuthController {
    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return ("<h1>Welcome</h1>");
    }

    //@GetMapping("/all")
    //public List<User> getAll() {
    //    List<User> users = this.userRepository.findAll();
    //    System.out.println(users);
    //    return users;
    //}

    @PutMapping
    public void register(@RequestBody User user) {
        this.userRepository.insert(user);
    }

    @PostMapping
    public void update(@RequestBody User user) {
        this.userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.userRepository.deleteById(id);
    }

}
