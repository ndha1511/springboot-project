package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.controllers;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Employee;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping()
    public String pageEmployee(Model model, Optional<Integer> page) {
        int number = page.orElse(0);
        Pageable pageable = PageRequest.of(number, 10);
        Page<Employee> employees = employeeService.getAll(pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("totalPage", employees.getTotalPages());
        return "employee/employees";
    }

}
