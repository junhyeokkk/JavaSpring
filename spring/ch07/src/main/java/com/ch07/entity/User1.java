package com.ch07.entity;

import com.ch07.dto.User1DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//Entity는 @Setter 안씀
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Entity                 // 엔티티 객체 정의 어노테이션
@Table(name ="user1")   // 매핑 테이블 설정 어노테이션
public class User1 {
    @Id // PK 컬럼 설정 (엔티티에 반드시 선언)
    private String uid;

    @Column(name = "name") // 매핑 컬럼 설정 (테이블과 이름이 같다면 생략가능)
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "hp")
    private String hp;

    @Column(name = "age")
    private int age;

    // DTO 변환 메서드
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
