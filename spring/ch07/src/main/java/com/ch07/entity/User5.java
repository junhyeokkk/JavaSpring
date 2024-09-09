package com.ch07.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@ToString
@Builder
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼) 값이 자동 1증가(auto_increment)
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

}
