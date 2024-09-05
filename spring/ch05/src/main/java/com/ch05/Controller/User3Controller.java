package com.ch05.Controller;


import com.ch05.dto.User3DTO;
import com.ch05.service.User3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User3Controller {

    private final User3Service user3Service;

    @Autowired
    public User3Controller(User3Service user3Service) {
        this.user3Service = user3Service;
    }


    @GetMapping("/user3/list")
    public String list(Model model){

        model.addAttribute("users",user3Service.selectUser3s());
        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){

        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO){
        user3Service.insertUser3(user3DTO);

        return "redirect:/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(@RequestParam("uid") String uid, Model model){

        model.addAttribute("user",user3Service.selectUser3(uid));

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(@ModelAttribute User3DTO user3DTO){
        user3Service.updateUser3(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(@RequestParam("uid") String uid){
        user3Service.deleteUser3(uid);
        return "redirect:/user3/list";
    }
}
