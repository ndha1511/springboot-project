package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass.OrderDetailId;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Order;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}