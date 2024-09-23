package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JWTProviderTest {

    @Autowired
    private JWTProvider jwtProvider;

    @Test
    void createToken() {
        User user = User.builder()
                .uid("a107")
                .name("김유신")
                .birth("1999-11-11")
                .role("ADMIN")
                .build();
       String jwt = jwtProvider.createToken(user,0);
       System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsb3ZldTk5MTExMTFAZ21haWwuY29tICIsImlhdCI6MTcyNjEyMjkwNCwiZXhwIjoxNzI2MjA5MzA0LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.kATcr-X56OdY2idLhmKtaMtjmtrFS0FjNsk6pTCjtR0";

        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + ", "+ role);
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsb3ZldTk5MTExMTFAZ21haWwuY29tICIsImlhdCI6MTcyNjEyMzg0NSwiZXhwIjoxNzI2MTIzODQ1LCJ1c2VybmFtZSI6ImExMDciLCJyb2xlIjoiQURNSU4ifQ.PBRlweO3zp80CIaWn8hUrbQCOvAkfzriH83i_KijmMo";

        try{
            jwtProvider.validateToken(token);

            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}