package com.ch07.entity.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Entity                 // 엔티티 객체 정의 어노테이션
@Table(name ="board_user")
public class User {

    @Id
    private String uid;
    private String name;
    private String nick;
    private String email;

    @CreationTimestamp
    private LocalDateTime regDate;


}
