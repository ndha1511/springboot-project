package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductPriceId implements Serializable {
    private LocalDateTime priceDateTime;
    private Product product;
}
