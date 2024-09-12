package com.ch09.dto;

import com.ch09.entity.User1;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User1DTO {

    @NotBlank // null, "", " " 모두 허용 안함
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자와 숫자로 최소 4~10자 입력")
    private String uid;

    @NotEmpty //null, "" 둘 다 허용 안함
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "한글로 최소 2~10자 입력")
    private String name;

    @NotNull // null 허용 안함
    private String birth;

    private String hp;

    @Min(1)
    @Max(100)
    private int age;

    @Email
    private String email;

    public User1 toEntity(){
        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
