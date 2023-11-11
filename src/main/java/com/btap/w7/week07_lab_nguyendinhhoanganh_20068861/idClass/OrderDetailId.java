package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Order;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderDetailId implements Serializable {
    private Order order;
    private Product product;
}
