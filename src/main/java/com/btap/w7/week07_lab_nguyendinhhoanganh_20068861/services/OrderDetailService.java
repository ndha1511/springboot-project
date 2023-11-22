package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.OrderDetail;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public void insert(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
}
