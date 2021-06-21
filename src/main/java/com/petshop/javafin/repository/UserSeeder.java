package com.petshop.javafin.repository;

import com.petshop.javafin.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {
    private UserRepository userRepository;

    public UserSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(
                "admin",
                "staylimmk@gmail.com",
                "12345qwerty"
        );

        //this.userRepository.save(user1);
        //System.out.println("User was added");
    }
}