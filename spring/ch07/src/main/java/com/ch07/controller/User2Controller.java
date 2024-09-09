package com.ch07.controller;


import com.ch07.dto.User2DTO;
import com.ch07.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2/list")
    public String list(Model model){
        model.addAttribute("users",user2Service.selectUser2s());
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(@ModelAttribute User2DTO user2DTO){
        user2Service.insertUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam String uid, Model model){
        User2DTO user = user2Service.selectUser2(uid);
        model.addAttribute("user",user);
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(@ModelAttribute User2DTO user2DTO){
        user2Service.updateUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam String uid){
        user2Service.deleteUser2(uid);
        return "redirect:/user2/list";
    }
}
