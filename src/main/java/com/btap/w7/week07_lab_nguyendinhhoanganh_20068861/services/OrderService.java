package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Order;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void insert(Order order) {
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }

    public List<Order> statisticalByOrderDate(String from, String to) {
         return orderRepository.statisticalByOrderDate(from, to);
    }

    public List<Order> statisticalByDate(String date) {
        return orderRepository.statisticalByDate(date);
    }

    public List<Order> findAllByEmployeeId(Long empId) {
        return orderRepository.findAllByEmployeeId(empId);
    }

}
