package com.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Entity                 // 엔티티 객체 정의 어노테이션
@Table(name ="parent")
public class Parent {

    @Id
    private String pid;
    private String name;
    private String birth;
    private String addr;

}
