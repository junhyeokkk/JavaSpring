package com.farm.dto.product;

import com.farm.entity.product.prodcate;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class prodcateDTO {
    private int prodCateNo;
    private String prodCateName;


    public prodcate toEntity() {
        return prodcate.builder()
                .prodCateNo(prodCateNo)
                .prodCateName(prodCateName)
                .build();
    }
}
