package com.app.restaurant.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartupController {

    @RequestMapping({"/","/index","index.html"})
    public String startUp(){
        return "/index";
    }

}
