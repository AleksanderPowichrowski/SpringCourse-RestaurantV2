package com.ap.restaurant.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockController {


    @RequestMapping({"/stocks","/stocks.html"})
    private String listTypes(){
        return "/stocks";
    }
}
