package com.ch06.Controller;

import com.ch06.DTO.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class User1ControllerTest {

    @Autowired
    private MockMvc mockMvc; //MVC 테스트를 위한 가상 MVC 객체

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/user1/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("/user1/list"))
                .andDo(print());
    }

    @Test
    void modify() throws Exception {
        mockMvc.perform(get("/user1/modify")
                        .param("uid" , "a111"))
                .andExpect(status().isOk())
                .andExpect(view().name("/user1/modify"))
                .andDo(print());
    }


    @Test
    void register() throws Exception {
        mockMvc.perform(post("/user1/register")
                        .param("uid", "a111")
                        .param("name", "테스트")
                        .param("birth", "1990-01-01")
                        .param("hp", "010-1234-1001")
                        .param("age", "22"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user1/list"))
                .andDo(print());
    }
    @Test
    void delete() throws Exception {
        mockMvc.perform(get("/user1/delete")
                        .param("uid", "a201"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user1/list"))
                .andDo(print());
    }
}