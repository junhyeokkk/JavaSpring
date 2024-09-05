package com.ch05.Controller;

import com.ch05.dto.User5DTO;
import com.ch05.service.User5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User5Controller {

    private final User5Service user5Service;

    @Autowired
    public User5Controller(User5Service user5Service) {
        this.user5Service = user5Service;
    }

    @GetMapping("/user5/list")
    public String list(Model model){
        model.addAttribute("users",user5Service.selectUser5s());
        return "user5/list";
    }

    @GetMapping("/user5/register")
    public String register(){
        return "user5/register";
    }

    @PostMapping("/user5/register")
    public String register(@ModelAttribute User5DTO user5DTO){
        user5Service.insertUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(@RequestParam("seq") String seq, Model model){
        model.addAttribute("user",user5Service.selectUser5(Integer.parseInt(seq)));
        return "user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(@ModelAttribute User5DTO user5DTO){
        user5Service.updateUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/delete")
    public String delete(@RequestParam("seq") String seq){
        user5Service.deleteUser5(Integer.parseInt(seq));
        return "redirect:/user5/list";
    }
}
