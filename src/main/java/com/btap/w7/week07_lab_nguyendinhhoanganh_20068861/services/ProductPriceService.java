package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services;


import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.ProductPrice;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public List<ProductPrice> findByProductId(Long id) {
        return productPriceRepository.findAllByProductIdOrderByPriceDateTimeDesc(id);
    }

    public void insert(ProductPrice productPrice) {
        productPriceRepository.save(productPrice);
    }


}
