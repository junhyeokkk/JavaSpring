package com.ch07.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Entity
@Table(name = "shop_product")
public class Product {

    @Id
    private int prod_id;
    private String prod_name;
    private int prod_price;
    private int stock;
    private String company;
}
