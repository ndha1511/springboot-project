package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.enums.Status;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models.*;
import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.repositories.*;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Device;
import net.datafaker.providers.base.Name;
import net.datafaker.providers.base.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class Week07LabNguyenDinhHoangAnh20068861Application {

    public static void main(String[] args) {
        SpringApplication.run(Week07LabNguyenDinhHoangAnh20068861Application.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProductPriceRepository productPriceRepository;
    @Autowired
    OrderRepository orderRepository;
    //@Bean
    CommandLineRunner createSampleProduct(OrderDetailRepository orderDetailRepository){
        return args -> {
            Faker faker = new Faker();
            Device device =faker.device();
            Number number =faker.number();
            Name name = faker.name();
            Address address = faker.address();
            Random random = new Random();

            for(int i=0;i<200;i++){
                Product product = new Product(
                        device.modelName(),
                        faker.lorem().paragraph(1),
                        "piece",
                        device.manufacturer(),
                        Status.ACTIVE
                );
                productRepository.save(product);
                ProductPrice productPrice = new ProductPrice(
                        product,
                        LocalDateTime.now(),
                        number.randomDouble(2,100,1000),
                        ""
                );
                productPriceRepository.save(productPrice);
                Customer customer = new Customer(
                        name.name(),
                        "cust_"+i+"@gmail.com",
                        random.nextInt(999999999+1-111111111)+111111111+"",
                        address.fullAddress()
                );
                customerRepository.save(customer);
                Employee employee = new Employee(
                        name.name(),
                        LocalDate.now(),
                        "emp_"+i+"@gmail.com",
                        random.nextInt(999999999+1-111111111)+111111111+"",
                        address.fullAddress(),
                        Status.ACTIVE
                );
                employeeRepository.save(employee);
                Order order = new Order(
                        LocalDateTime.now(),
                        employee,
                        customer
                );
                orderRepository.save(order);
                OrderDetail orderDetail = new OrderDetail(
                        order,
                        product,
                        random.nextInt(3),
                        number.randomDouble(2,100,1000),
                         "");
                orderDetailRepository.save(orderDetail);

            }
        };
    }

}
