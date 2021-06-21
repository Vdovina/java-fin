package com.petshop.javafin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping("/table")
    public String tableMain(Model model)
    {
        return "table";
    }
}
