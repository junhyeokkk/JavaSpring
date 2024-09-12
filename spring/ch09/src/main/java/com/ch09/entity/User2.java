package com.ch09.entity;

import com.ch09.dto.User2DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="user2")
public class User2 {
    @Id
    private String uid;
    private String name;
    private String birth;
    private String addr;

    public User2DTO toDTO() {
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
