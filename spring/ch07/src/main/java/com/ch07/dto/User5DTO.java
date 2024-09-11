package com.ch07.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User5DTO {

    @Id
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public com.ch07.dto.User5 toEntity() {
        return com.ch07.dto.User5.builder()
                                            .seq(seq)
                                            .name(name)
                                            .gender(gender)
                                            .age(age)
                                            .addr(addr)
                                            .build();
    }

}
