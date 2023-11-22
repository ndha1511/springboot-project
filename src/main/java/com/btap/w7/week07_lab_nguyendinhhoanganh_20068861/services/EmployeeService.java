package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Employee;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findById(Long id) {
        Optional<Employee> e = employeeRepository.findById(id);
        return e.orElse(new Employee());
    }

    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
