package com.ap.restaurant.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChiefController {


    @RequestMapping({"/chiefs","/chiefs.html"})
    private String listTypes(){
        return "/chiefs";
    }
}
