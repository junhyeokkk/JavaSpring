package com.ch06.service;

import com.ch06.DTO.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;


    @Test
    void insertUser1() {
        // 테스트 정의 : given - when - then 패턴


        // given : 테스트를 실행하기 위한 준비 단계
       User1DTO mockuser1 = mock(User1DTO.class);

        // when : 테스트를 진행 단계
        user1Service.insertUser1(mockuser1);

        verify(User1DTO)

        // then : 테스트를 결과를 검증하는 단계

    }

//    @Test
//    void insertUser1() {
//        // 테스트 정의 : given - when - then 패턴
//
//        // given : 테스트를 실행하기 위한 준비 단계
//        User1DTO sample = User1DTO.builder()
//                                                .uid("a201")
//                                                .name("김유신")
//                                                .birth("1999-11-11")
//                                                .hp("010-1234-1234")
//                                                .age(32)
//                                                .build();
//
//        // when : 테스트를 진행 단계
//        user1Service.insertUser1(sample);
//
//        // then : 테스트를 결과를 검증하는 단계
//        User1DTO expected= user1Service.selectUser1(sample.getUid());
//
//        Assertions.assertEquals(expected.toString(), sample.toString());
//    }

    @Test
    void selectUser1s() {

        List<User1DTO> expected = user1Service.selectUser1s();
        Assertions.assertTrue(expected.isEmpty());

    }

    @Test
    void selectUser1() {
    }

    @Test
    void updateUser1() {
        // given : 테스트를 실행하기 위한 준비 단계
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유진")
                .birth("1999-11-11")
                .hp("010-1234-1234")
                .age(32)
                .build();

        // when : 테스트를 진행 단계
        user1Service.updateUser1(sample);

        // then : 테스트를 결과를 검증하는 단계
        User1DTO expected= user1Service.selectUser1(sample.getUid());

        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    void deleteUser1() {
    }
}