package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.enums.Status;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Product;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAllByStatus(Status.ACTIVE, pageable);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void insert(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
