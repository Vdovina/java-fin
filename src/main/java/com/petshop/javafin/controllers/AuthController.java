package com.petshop.javafin.controllers;

import com.petshop.javafin.controllers.auth.MongoUserDetailsService;
import com.petshop.javafin.models.User;
import com.petshop.javafin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/pets")
public class AuthController {
    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private MongoUserDetailsService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        System.out.println("login test");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        System.out.println("signup test");
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        System.out.println("test");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createNewUser(User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByName(user.getName());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user",
                    "Пользователь с таким именем уже существует!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        }
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Вы успешно зарегистрировались!");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
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