package com.ch07.entity.shop;

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
@Entity
@Table(name = "shop_customer")
public class Customer {

    @Id
    private String cid;
    private String name;
    private String hp;
    private String addr;

    @CreationTimestamp
    private LocalDateTime regdate;

}
