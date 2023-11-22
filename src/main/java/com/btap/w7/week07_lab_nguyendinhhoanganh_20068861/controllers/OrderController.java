package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.controllers;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Order;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @GetMapping
    public String order() {
        return "order/orders";
    }
    @GetMapping("/dates")
    public String statisticalByOrderDate(String toDate, String fromDate, Model model) {
        List<Order> orders = orderService.statisticalByOrderDate(fromDate, toDate);
        if(orders != null)
            model.addAttribute("orders", orders);
        return "order/orders";
    }

    @GetMapping("/date")
    public String statisticalByDate(String date, Model model) {
        List<Order> orders = orderService.statisticalByDate(date);
        if(orders != null)
            model.addAttribute("orders", orders);
        return "order/orders";
    }

    @GetMapping("/employee/{id}")
    public String findAllByEmployeeId(@PathVariable(name = "id") Long id, Model model) {
        List<Order> orders = orderService.findAllByEmployeeId(id);
        model.addAttribute("orders", orders);
        return "order/orders";
    }
}
