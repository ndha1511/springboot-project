package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from tbl_order where order_date > :to and order_date < :from", nativeQuery = true)
    List<Order> statisticalByOrderDate(String from, String to);

    @Query(value = "SELECT * FROM tbl_order WHERE DATE_FORMAT(order_date, \"%Y-%c-%d\") = :date", nativeQuery = true)
    List<Order> statisticalByDate(String date);

    List<Order> findAllByEmployeeId(Long empId);


}