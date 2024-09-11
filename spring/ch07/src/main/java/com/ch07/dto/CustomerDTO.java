package com.ch07.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private String cid;
    private String name;
    private String addr;
    private String hp;
    private int age;
    private String regDate;

    //추가필드
    private int orderCount;
}
