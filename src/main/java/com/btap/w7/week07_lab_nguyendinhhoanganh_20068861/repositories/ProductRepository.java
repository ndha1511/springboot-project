package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}