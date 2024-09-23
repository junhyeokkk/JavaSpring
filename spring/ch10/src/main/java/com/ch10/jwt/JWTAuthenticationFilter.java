package com.ch10.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTProvider jwtProvider;
    private static final String AUTH_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 요청 주소에서 마지막 문자열 추출
        String uri = request.getRequestURI();
        int i = uri.lastIndexOf("/");
        String path = uri.substring(i);
        log.info("here1 - " + path);

        // 토큰 추출
        String header = request.getHeader(AUTH_HEADER);
        log.info("here2 - " + header);

        String token = null;

        if(header != null && header.startsWith(TOKEN_PREFIX)) {
            token = header.substring(TOKEN_PREFIX.length()).trim();
        }
        log.info("here3 - " + token);

        // 토큰 검사
        if(token != null) {
            try {
                jwtProvider.validateToken(token);

                // 토큰 이상 없을 경우 시큐리티 인증 처리
                Authentication authentication = jwtProvider.getAuthentication(token.trim());

                //SecurityContextHolder.getContext().setAuthentication(authentication);
                log.info("here4 - " + authentication);

            } catch (Exception e) {
                // 토큰 이상 있을 경우 실패 응답
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(e.getMessage());
                log.info("here5 - " + e.getMessage());

                return;
            }
        }
        log.info("here6...");

        filterChain.doFilter(request, response);
    }
}
