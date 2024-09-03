package com.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 부가기능을 aspect로 만듬 (aspect라는 틀안에 넣는다고 생각)
@Aspect
@Component
public class MyAdvice {

    // 포인트컷
    @Pointcut("execution(void com.ch03.MyService.insert())")
    public void insertPointcut(){  //핵심관심을 가리키는 내용이 없는 메서드

    }

    @Pointcut("execution(void com.ch03.MyService.select(..))") //모든 매개변수 ..
    public void selectPointcut(){}

    // 핵심 기능 전
    @Before("insertPointcut() || selectPointcut()")
    public void beforeAdvice() {
        System.out.println("부가 기능  - beforeAdvice");
    }

    // 핵심 기능 후
    @After("insertPointcut()")
    public void afterAdvice() {
        System.out.println("부가 기능  - afterAdvice");
    }

    // 핵심 기능 return 될 때(after 보다 먼저 실행)
    @AfterReturning("insertPointcut()")
    public void afterReturnAdvice() {
        System.out.println("부가 기능  - afterReturnAdvice");
    }

    // 핵심 기능 전 후
    @Around("insertPointcut()") //before, after 보다 이전, 이후에 실행
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("부가 기능  - aroundAdvice");
        pjp.proceed(); // 핵심관심
        System.out.println("부가 기능  - aroundAdvice");
    }

    @AfterThrowing("selectPointcut()")
    public void afterThrowAdvice() {
        System.out.println("부가 기능  - afterThrowAdvice");
    }
}
