package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.dtos;

import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Cart {
    private Long productId;
    private String productName;
    private double price;
    private int quantity;
}
