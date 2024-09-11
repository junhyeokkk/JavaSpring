package com.farm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        String str1 = "Y";
        model.addAttribute("str1", str1);
        return "index";
    }

}
