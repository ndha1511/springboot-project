package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.models;

import com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private LocalDate dob;
    private String email;
    private String phone;
    private String address;
    @Enumerated
    private Status status;
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    public Employee(String fullName, LocalDate dob, String email, String phone, String address, Status status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }
}
