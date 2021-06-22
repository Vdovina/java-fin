package com.petshop.javafin.controllers;

import com.petshop.javafin.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {


    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница | Наш сайт");
        return "pets"   ;
    }

    @RequestMapping(value = {"/{[path:[^\\.]*}", "/"})
    public void redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect("/pets");
    }
}
