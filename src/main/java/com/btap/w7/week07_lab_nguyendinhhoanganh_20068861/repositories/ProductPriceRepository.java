package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.idClass.ProductPriceId;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPriceId> {

    List<ProductPrice> findAllByProductIdOrderByPriceDateTimeDesc(Long id);
}