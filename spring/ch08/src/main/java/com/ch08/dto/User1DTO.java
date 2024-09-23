package com.ch07.dto;

import com.ch07.entity.User1;
import lombok.*;

//Entity는 @Setter 안씀
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class User1DTO {

    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    // 엔티티 변환 메서드
    public User1 toEntity(){
        // Builder 방식 생성
        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
