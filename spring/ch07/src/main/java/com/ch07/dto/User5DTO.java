package com.ch07.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User5DTO {

    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

}
