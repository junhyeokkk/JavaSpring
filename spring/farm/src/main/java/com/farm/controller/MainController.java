package com.farm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        String group = "product";
        String cate = "register";
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "index";
    }

}
