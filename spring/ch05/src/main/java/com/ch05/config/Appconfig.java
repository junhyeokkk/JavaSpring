package com.ch05.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ch05")
public class Appconfig implements WebMvcConfigurer {

    // Dispatcher servlet 에게 view의 정보(경로)를 알려주는 역할
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // jsp 경로 및 확장자 설정
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 리소스 자원 경로 설정
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}
