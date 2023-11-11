package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass.ProductImageId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_image")
@IdClass(ProductImageId.class)
public class ProductImage {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
    private String path;
    private String alternative;
}
