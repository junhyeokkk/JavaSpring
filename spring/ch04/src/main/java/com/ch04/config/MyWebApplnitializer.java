package com.ch04.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplnitializer implements WebApplicationInitializer {

    //앱이 처음 구동될때 실행 되는 메서드
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
            // 스프링 MVC 애플리케이션 컨텍스트 생성
            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

            // 스프링 MVC 구성 클래스 등록
            context.register(Appconfig.class);

            // DispatcherServlet 생성/등록
            DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic servletRegistration =  servletContext.addServlet("dispatcherServlet", dispatcherServlet);

        servletRegistration.setLoadOnStartup(1);
        // 서블릿 주소가 루트
        servletRegistration.addMapping("/");


    }
}
