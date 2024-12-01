package com.ap.restaurant.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IngredientTypeController {


    @RequestMapping({"/types","/types.html"})
    private String listTypes(){
        return "/types";
    }
}
