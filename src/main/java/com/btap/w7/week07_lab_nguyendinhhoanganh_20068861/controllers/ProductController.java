package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.controllers;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.dtos.Cart;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.enums.Status;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.*;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.services.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductPriceService productPriceService;
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    @GetMapping()
    public String getAll(Model model, Optional<Integer> pageNumber) {
        int page = pageNumber.orElse(0);
        Sort sort = Sort.by(Sort.Direction.fromString("desc"), "id");
        Pageable pageable = PageRequest.of(page, 10, sort);
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

    @GetMapping("/add")
    public String formInsert(Model model) {
        model.addAttribute("product", new Product());
        return "product/insert";
    }

    @PostMapping("/save")
    public String update(@ModelAttribute("product") Product product) {
        if(product.getStatus() == null)
            product.setStatus(Status.ACTIVE);
        productService.insert(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Optional<Product> p = productService.findById(id);
        Product product = p.orElse(new Product());
        product.setStatus(Status.INACTIVE);
        productService.insert(product);
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(Model model, @PathVariable("id") Long id) {
        Optional<Product> p = productService.findById(id);
        model.addAttribute("product", p.get());
        List<ProductPrice> productPrices = productPriceService.findByProductId(id);
        if(!productPrices.isEmpty()) {
            model.addAttribute("productPrices", productPrices);
            ProductPrice productPrice = productPrices.get(0);
            model.addAttribute("productPrice", productPrice);
        }
        int quantity = 0;
        model.addAttribute("quantity", quantity);
        return "product/detail";
    }

    @PostMapping ("/cart")
    public ResponseEntity<String> addToCart(HttpSession session, @RequestBody Cart cart) {
        List<Cart> carts = null;
        Object obj = session.getAttribute("cart");
        if(obj == null) {
            carts = new ArrayList<>();
        } else {
            carts = (ArrayList<Cart>) obj;
        }
        boolean flag = true;
        for (Cart c: carts) {
            if(Objects.equals(c.getProductId(), cart.getProductId())) {
                c.setQuantity(c.getQuantity() + cart.getQuantity());
                flag = false;
            }
        }
        if(flag)
            carts.add(cart);

        session.setAttribute("cart", carts);

        return ResponseEntity.ok("Saved cart");
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        List<Cart> carts = (ArrayList<Cart>) session.getAttribute("cart");
        double totalPrice = 0;
        if(carts != null) {
            for (Cart cart: carts) {
                totalPrice += cart.getPrice() * cart.getQuantity();
            }
            model.addAttribute("totalPrice", totalPrice);
        }

        model.addAttribute("carts", carts);
        return "product/cart";
    }

    @GetMapping("/pay")
    public String pay(HttpSession session) {
        List<Cart> carts = (List<Cart>) session.getAttribute("cart");
        if(carts != null) {
            Customer customer = customerService.findById(1L);
            Employee employee = employeeService.findById(1L);
            Order order = new Order();
            order.setCustomer(customer);
            order.setEmployee(employee);
            orderService.insert(order);
            for (Cart cart: carts) {
                OrderDetail orderDetail = new OrderDetail();
                Product product = productService.findById(cart.getProductId()).get();
                orderDetail.setProduct(product);
                orderDetail.setOrder(order);
                orderDetail.setQuantity(cart.getQuantity());
                orderDetail.setPrice(cart.getPrice());
                orderDetailService.insert(orderDetail);
            }
            session.removeAttribute("cart");
            return "redirect:/product";
        }

        return "redirect:/product/checkout";
    }

    @GetMapping("/price/{id}")
    public String insertProductPrice(Model model, @PathVariable("id") Long id) {
        model.addAttribute("productId", id);
        model.addAttribute("productPrice", new ProductPrice());
        return "product/insertPrice";
    }

    @PostMapping("/savePrice/{id}")
    public String savePrice(@ModelAttribute("productPrice") ProductPrice productPrice, @PathVariable("id") Long id) {
        productPrice.setPriceDateTime(LocalDateTime.now());
        productPrice.setProduct(productService.findById(id).get());
        productPriceService.insert(productPrice);
        return "redirect:/product/detail/{id}";
    }

}
