package com.ch04.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//component써도 되지만 세부적으로 어떤기능인지 알아보기 위해 그 기능의 어노테이션 써주기
@Controller
public class MainController {

    //요청 주소 매핑
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello(){
        System.out.println("hello ...");
    }

    //get 요청 매핑
    @GetMapping("/welcome")
    public void welcome(){
        System.out.println("welcome ...");
    }

    @GetMapping("/greeting")
    public void greeting(){
        System.out.println("greeting ...");
    }
}
