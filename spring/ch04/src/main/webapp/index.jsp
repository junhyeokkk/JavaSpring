<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>index</title>
        <!--
            날짜 : 2024/09/03
            이름 : 최준혁
            내용 : 4장 Spring MVC 실습하기

             프로젝트 생성
             - Maven archetypes : maven-archetype-webapp
             - GroupId: kr.co.ch04
             - ArtifactId: ch04

            Spring MVC 라이브러리
             - spring-context 6.1.12
             - spring-webmvc 6.1.12
             - jakarta.servlet-api 6.1.0
             - jakarta.servlet.jsp.jstl-api 3.0.2
             - jakarta.servlet.jsp.jstl 3.0.1

            WebApplicationInitializer
             - 스프링 웹 애플리케이션 초기화를 위한 인터페이스
             - DispatcherServlet을 생성하고 컨텍스트 등록
             - 웹 애플리케이션 컨텍스트(컨테이너)를 설정하고 필요한 서블릿, 필터, 리스너 등 설정

            WebMvcConfigurer
             - 스프링 웹 MVC 구성 컴포넌트 설정을 위한 인터페이스
             - 뷰리졸버(ViewResolver) 설정 및 ResourceHandler 설정 등 애플리케이션 전반에 걸친 자원 설정

            @EnableWebMvc
             - 스프링 MVC를 구성하고 MVC 관련 기능을 활성화하는 어노테이션
        -->
    </head>
    <body>
        <h2>4장. Spring MVC</h2>

        <h4>MVC 기본</h4>
        <a href="/ch04/hello">hello</a>
        <a href="/ch04/welcome">welcome</a>
        <a href="/ch04/greeting">greeting</a>


        <a href="/ch04/user1/list">User1</a>
        <a href="/ch04/user2/list">User2</a>
        <a href="/ch04/user3/list">User3</a>

    </body>
</html>
