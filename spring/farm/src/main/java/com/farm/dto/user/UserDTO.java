package com.farm.dto.user;

import com.farm.entity.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String uid;
    private String pass;
    private String name;
    private String nick;
    private String email;
    private String hp;
    private int point;
    private int grade;
    private String zip;
    private String address1;
    private String address2;
    private LocalDateTime regdate;


    public User toEntity() {
        return User.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .nick(nick)
                .email(email)
                .hp(hp)
                .point(point)
                .grade(grade)
                .zip(zip)
                .address1(address1)
                .address2(address2)
                .regdate(regdate)
                .build();
    }
}
