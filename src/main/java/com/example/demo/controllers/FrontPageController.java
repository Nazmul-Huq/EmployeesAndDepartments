package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontPageController {

    // index/homepage view
    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }
}