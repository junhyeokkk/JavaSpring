package com.ch02.config;

import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//해당 클래스의 설정파일 (컨테이너)
@Configuration
//패키지 입력에 입력한 패키지의 하위의 모든 컴퍼런스들을 참조한다.
@ComponentScan(basePackages = {"com.ch02"})
public class AppConfig {

    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean(name = "welcome")
    public Welcome welcome(){
        return new Welcome();
    }

    @Bean("greet")
    public Greeting greeting(){
        return new Greeting();
    }
}
