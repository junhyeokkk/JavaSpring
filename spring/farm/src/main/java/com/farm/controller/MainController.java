package com.farm.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        String group = "main";
        String cate = "main";
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "index";
    }

    @GetMapping(value = "/page")
    public String page(Model model, @RequestParam("group") String group, @RequestParam("cate") String cate) {
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "index";
    }
}
