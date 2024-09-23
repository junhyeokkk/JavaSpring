package com.ch08.controller;

import com.ch08.entity.User;
import com.ch08.security.MyUserDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Log4j2
@Controller
public class MainController {

    @GetMapping(value = {"/","/index"})
    public String index(Model model) {

        // SecurityContextHolder를 참조해서 authentication 구하면 로그인을 하지 않아도 익명사용자 authentication를 가져옴
        // security 설정에서 annoymous를 사용안함(disable)으로 설정해서 로그인 안했을때 authentication 값을 null로 가져오게함
        // 로그인 사용자 인증 객체 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);

        if(authentication != null && authentication.getPrincipal() instanceof MyUserDetails) {
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myUserDetails.getUser();
            model.addAttribute("user", user);
        }

        return "index";
    }

    @GetMapping(value = {"/admin","/admin/index"})
    public String adminIndex() {
        return "/admin/index";
    }

    @GetMapping(value = {"/manager","/manager/index"})
    public String managerIndex() {
        return "/manager/index";
    }

    @GetMapping(value = {"/staff","/staff/index"})
    public String staffIndex() {
        return "/staff/index";
    }
}
