package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.dto.User2DTO;
import com.ch09.entity.User1;
import com.ch09.entity.User2;
import com.ch09.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class User2Controller {

    private final User2Service user2Service;

    @ResponseBody
    @GetMapping("/user2")
    public List<User2DTO> list(){
        List<User2DTO> users= user2Service.selectUser2s();
        return users;
    }

    @ResponseBody
    @GetMapping("/user2/{uid}")
    public User2DTO user2(@PathVariable("uid") String uid){
        User2DTO user2= user2Service.selectUser2(uid);

        return user2;
    }

    @PostMapping("/user2")
    public ResponseEntity<User2> register(@RequestBody User2DTO user2){
        User2 saveduser = user2Service.insertUser2(user2);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saveduser);
    }

    @PutMapping("/user2")
    public ResponseEntity modify(@RequestBody User2DTO user2DTO){
        User2 modifiedUser2 = user2Service.updateUser2(user2DTO);

        // ResponseEntity로 반환할 경우  @ResponseBody 생략
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //202
                .body(modifiedUser2);
    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        try {
            user2Service.deleteUser2(uid);
            return ResponseEntity
                    .status(HttpStatus.OK) //200
                    .body("success");
        } catch (EntityActionVetoException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
