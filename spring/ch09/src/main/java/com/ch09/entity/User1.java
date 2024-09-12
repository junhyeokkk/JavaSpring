package com.ch09.entity;

import com.ch09.dto.User1DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="user1")
public class User1 {

    @Id
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    public User1DTO toDTO() {
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
