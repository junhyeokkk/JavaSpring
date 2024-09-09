package com.ch06.Controller;

import com.ch06.DTO.User1DTO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

// 로그 어노테이션
@Log4j2
@Controller
public class MainController {

    @GetMapping(value ={"/", "/index"})
    public String index(Model model) {
        String str1 = "hello world";
        String str2 = "hello Sping boot";

        // DTO 생성 - 생성자 초기화
        User1DTO user1 = new User1DTO("a101","김유신","1999-11-11","011-1234-1234",21);
        log.info(user1);

        // DTO 생성 - SETTER 초기화
        User1DTO user2 = new User1DTO();
        user2.setUid("a102");
        user2.setName("김춘추");
        user2.setBirth("1998-11-11");
        user2.setHp("010-1234-1234");
        user2.setAge(22);
        log.info(user2);

        // DTO 생성 - 빌더 초기화
        User1DTO user3 = User1DTO.builder()
                                            .uid("a103")
                                            .name("장보고")
                                            .birth("1994-11-11")
                                            .hp("010-1234-1233")
                                            .age(21)
                                            .build();
        log.info(user3);

        List<User1DTO> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);
        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        model.addAttribute("user3", user3);
        model.addAttribute("users", users);

        return "index";
    }

    @GetMapping("/sub1/hello")
    public String hello(){
        return "/sub1/hello";
    }

    @GetMapping("/sub1/welcome")
    public String welcome(){
        return "/sub1/welcome";
    }

    @GetMapping("/sub1/greeting")
    public String greeting(){
        return "/sub1/greeting";
    }

}
