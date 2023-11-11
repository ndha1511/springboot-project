package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.controllers;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.Product;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping()
    public String getAll(Model model, Optional<Integer> pageNumber) {
        int page = pageNumber.orElse(0);
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> products = productService.getAll(pageable);
        model.addAttribute("products", products);
        model.addAttribute("pageSize", products.getTotalPages());
        return "product/products";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Optional<Product> p = productService.findById(id);
        Product product = p.orElse(new Product());;

        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product) {
        System.out.println(product);
        //productService.insert(product);
        return "redirect:/product";
    }

}
