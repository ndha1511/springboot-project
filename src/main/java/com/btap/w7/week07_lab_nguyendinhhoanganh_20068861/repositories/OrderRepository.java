package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}