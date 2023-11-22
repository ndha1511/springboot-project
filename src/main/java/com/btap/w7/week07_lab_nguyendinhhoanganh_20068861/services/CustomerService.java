package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Customer;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer findById(Long id) {
        Optional<Customer> c = customerRepository.findById(id);
        return c.orElse(new Customer());
    }

    public Page<Customer> getAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
