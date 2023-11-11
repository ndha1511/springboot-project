package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String index() {
        return "index";
    }
}
