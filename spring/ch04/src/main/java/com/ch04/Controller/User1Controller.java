package com.ch04.Controller;

import com.ch04.Dto.User1DTO;
import com.ch04.Service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User1Controller {

    private User1Service serivce;

    @Autowired
    public User1Controller(User1Service serivce) {
        this.serivce = serivce;
    }

    // controller는 crud 생각하여 해당 방식으로 설계
    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto){
        System.out.println(dto.toString());

        serivce.insertUser1(dto);

        return "redirect:/user1/list";
    }

    @GetMapping("/user1/list")
    public String list(Model model){
        //조회
        List<User1DTO> users = serivce.selectUser1s();

        //모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);

        System.out.println(users.toString());

        return "user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        System.out.println("uid : "+ uid);

        //수정 회원 조회
        User1DTO user = serivce.selectUser1(uid);

        //모델 참조
        model.addAttribute(user); //타입명으로 저장(소문자 시작 -> user1DTO)

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(@ModelAttribute  User1DTO dto, Model model){
        System.out.println(dto.toString());

        //수정
        serivce.updateUser1(dto);

        //리다이렉트
        return "redirect:/user1/list";

    }

    @GetMapping("/user1/delete")
    public String delete(@RequestParam("uid") String uid){
        System.out.println("delete uid : "+ uid);
        serivce.deleteUser1(uid);

        return "redirect:/user1/list";
    }
}
