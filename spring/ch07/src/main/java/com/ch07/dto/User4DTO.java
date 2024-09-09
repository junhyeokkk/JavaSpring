package com.ch07.dto;

import com.ch07.entity.User4;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User4DTO {
    private String uid;
    private String name;
    private String gender;
    private int age;
    private String hp;
    private String addr;

    public User4 toEntity(){
        return User4.builder()
                .uid(uid)
                .name(name)
                .gender(gender)
                .age(age)
                .hp(hp)
                .addr(addr)
                .build();
    }

}
