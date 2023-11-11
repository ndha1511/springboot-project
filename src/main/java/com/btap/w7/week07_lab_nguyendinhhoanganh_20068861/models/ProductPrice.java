package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass.ProductPriceId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product_price")
@IdClass(ProductPriceId.class)
public class ProductPrice {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;
    private double price;
    private String note;
}
