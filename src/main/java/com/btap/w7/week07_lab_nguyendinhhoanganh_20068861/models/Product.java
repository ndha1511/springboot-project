package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private String unit;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Enumerated
    private Status status;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    public Product(String name, String description, String unit, String manufacturerName, Status status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }
}
