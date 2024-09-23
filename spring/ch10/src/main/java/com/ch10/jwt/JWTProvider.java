package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Component
public class JWTProvider {



    private String issuer;
    private SecretKey secretKey;

    public JWTProvider(@Value("${jwt.issuer}") String issuer,
                       @Value("${jwt.secret}") String secretKey) {
        this.issuer = issuer;
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // JWT 토큰 생성
    public String createToken(User user, int days) {

        // 발급일, 만료일 생성
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime() + Duration.ofDays(days).toMillis());

        // 클레임 생성
        //Claims claims = Jwts.claims();
        //claims.put("username", user.getUid());
        //claims.put("role", user.getRole());

        // 토큰 생성
        String token = Jwts.builder()
                .issuer(issuer)
                .issuedAt(issuedDate)
                .expiration(expireDate)
                .claim("username", user.getUid())
                .claim("role", user.getRole())
                .signWith(this.secretKey, Jwts.SIG.HS256)
                .compact();

        return token;
    }

    // 토큰으로부터 클레임 추출
    public Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(this.secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Authentication getAuthentication(String token) {

        // 토큰으로 부터 사용자 정보 가져오기
        Claims claims = getClaims(token);
        String username = claims.get("username", String.class);
        String role = claims.get("role", String.class);

        // User 엔티티 생성
        User user = User
                .builder()
                .uid(username)
                .role(role)
                .build();

        // 사용자 권한 목록
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));

        return new UsernamePasswordAuthenticationToken(user, "", authorities);
    }

    public void validateToken(String token) throws Exception {

        try{
            // 토큰 검사(유효성, 만료일)
            Jwts
                    .parser()
                    .verifyWith(this.secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

        }catch (Exception e){
            // 토큰에 문제가 있을 경우 예외 넘기기
            throw new Exception(e);
        }
    }
}
