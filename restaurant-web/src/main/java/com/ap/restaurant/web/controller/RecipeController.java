package com.ap.restaurant.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {


    @RequestMapping({"/recipes","/recipes.html"})
    private String listTypes(){
        return "/recipes";
    }
}
