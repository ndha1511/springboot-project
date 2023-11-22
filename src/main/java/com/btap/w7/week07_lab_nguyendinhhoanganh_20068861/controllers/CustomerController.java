package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.controllers;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Customer;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("")
    public String pagesCustomer(Model model, Optional<Integer> page) {
        int number = page.orElse(0);
        Pageable pageable = PageRequest.of(number, 10);
        Page<Customer> customers = customerService.getAll(pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("totalPage", customers.getTotalPages());
        return "customer/customers";
    }
}
