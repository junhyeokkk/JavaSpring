package co.kr.junhyeok.controller;

import co.kr.junhyeok.document.user1Document;
import co.kr.junhyeok.service.user1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class user1Controller {

    private final user1Service service;

    @GetMapping("/user1")
    public ResponseEntity<List<user1Document>> findAllUser1s() {
        List<user1Document> list = service.findAllUser1s();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);

    }
    @GetMapping("/user1/{uid}")
    public ResponseEntity<user1Document> findUser1(@PathVariable("uid") String uid) {

        user1Document user1 = service.findUser1(uid);

        if(user1 != null) {
            return ResponseEntity.ok().body(user1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/user1")
    public ResponseEntity<user1Document> insertUser1(user1Document user1) {
        user1Document savedUser1 = service.insertUser1(user1);

        return ResponseEntity.ok().body(savedUser1);

    }
    @PutMapping("/user1")
    public ResponseEntity<user1Document> updateUser1(user1Document user1) {
        user1Document modifieduser1 = service.updateUser1(user1);

        return ResponseEntity.ok().body(modifieduser1);

    }
    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<Boolean> deleteUser1(@PathVariable String uid) {
       Boolean result = service.deleteUser1(uid);

       return ResponseEntity.ok().body(result);

    }

}
