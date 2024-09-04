package com.ch04.Controller;

import com.ch04.Dto.User2DTO;
import com.ch04.Service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User2Controller {

    private User2Service servcie;

    @Autowired
    public User2Controller(User2Service servcie) {
        this.servcie = servcie;
    }

    @GetMapping("/user2/register")
    public String register(){

        return "user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        servcie.insertUser2(dto);

        return "user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model){

        model.addAttribute("users", servcie.selectUser2s());
        return "user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        System.out.println(uid);

        model.addAttribute("user2DTO", servcie.selectUser2(uid));
        return "user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(@ModelAttribute User2DTO dto, Model model){

        servcie.updateUser2(dto);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid, Model model){
        servcie.deleteUser2(uid);

        return "redirect:/user2/list";
    }

}
