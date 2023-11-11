package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass.OrderDetailId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@Entity(name = "order_detail")
@IdClass(OrderDetailId.class)
public class OrderDetail {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private double price;
    private String note;

    public OrderDetail(Order order, Product product, int quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }
}
