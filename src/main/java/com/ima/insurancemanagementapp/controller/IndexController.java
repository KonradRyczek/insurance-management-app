package com.ima.insurancemanagementapp.controller.v1.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", ""})
    public String showIndex(){
        return "index";
    }
}