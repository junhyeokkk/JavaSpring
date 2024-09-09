package com.ch07.controller;

import com.ch07.dto.User4DTO;
import com.ch07.repository.User4Repository;
import com.ch07.service.User4Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class User4Controller {

    private final User4Service user4Service;

    @GetMapping("/user4/list")
    public String list(Model model){
        model.addAttribute("users", user4Service.selectUser4s());
        return "/user4/list";
    }

    @GetMapping("/user4/register")
    public String register(){
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(@ModelAttribute User4DTO user4DTO){
        user4Service.insertUser4(user4DTO);

        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(@RequestParam String uid, Model model){
        User4DTO user= user4Service.selectUser4(uid);
        model.addAttribute("user",user);
        return "/user4/modify";
    }

    @PostMapping("/user4/modify")
    public String modify(@ModelAttribute User4DTO user4DTO){
        user4Service.updateUser4(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/delete")
    public String delete(@RequestParam String uid){
        user4Service.deleteUser4(uid);
        return "redirect:/user4/list";
    }
}
