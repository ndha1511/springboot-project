package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT product.*, product_price.price FROM product \n" +
            "INNER JOIN product_price\n" +
            "ON product.product_id = product_price.product_id\n" +
            "WHERE product_price.price_date_time = (\n" +
            "\tSELECT price_date_time FROM product_price\n" +
            "\tWHERE product_id = product.product_id\n" +
            "\tORDER BY price_date_time DESC LIMIT 1\n" +
            ")",
            countQuery = "SELECT COUNT(product_id) FROM product",
            nativeQuery = true
    )
    Page<Object> getProductByPriceCurrent(Pageable page);
}