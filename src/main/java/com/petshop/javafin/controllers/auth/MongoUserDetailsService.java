package com.petshop.javafin.controllers.auth;

import com.petshop.javafin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String name) throws UsernameNotFoundException {
        com.petshop.javafin.models.User user = userRepository.findByUsername(name);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

        return new User(user.getName(), user.getPassword(), authorities);
    }

    public com.petshop.javafin.models.User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public void saveUser(com.petshop.javafin.models.User user) {
        userRepository.save(user);
    }

    private UserDetails buildUserForAuthentication(User user, List<SimpleGrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}