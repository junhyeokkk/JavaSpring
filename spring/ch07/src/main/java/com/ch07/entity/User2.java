package com.ch07.entity;

import com.ch07.dto.User2DTO;
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
@Table(name ="user2")   // 매핑 테이블 설정 어노테이션
public class User2 {
    @Id // PK 컬럼 설정 (엔티티에 반드시 선언)
    private String uid;

    @Column(name = "name") // 매핑 컬럼 설정 (테이블과 이름이 같다면 생략가능)
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "addr")
    private String addr;

    // DTO 변환 메서드
    public User2DTO toDTO() {
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
