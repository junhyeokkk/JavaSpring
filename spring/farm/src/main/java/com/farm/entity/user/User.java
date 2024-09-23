package com.farm.entity.user;

import com.farm.dto.user.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
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

    public UserDTO toDTO() {
        return UserDTO.builder()
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
