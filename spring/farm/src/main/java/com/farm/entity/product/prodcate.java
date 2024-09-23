package com.farm.entity.product;

import com.farm.dto.product.prodcateDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prodcate")
public class prodcate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prodCateNo")
    private int prodCateNo;
    @Column(name = "prodCateName")
    private String prodCateName;

    public prodcateDTO toDTO() {
        return prodcateDTO.builder()
                .prodCateNo(prodCateNo)
                .prodCateName(prodCateName)
                .build();
    }
}
