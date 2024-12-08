package com.app.restaurant.web.controller.db;

import com.app.restaurant.web.mapper.thymeleaf.StockMapper;

import com.app.resturant.service.db.StockDbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@Profile("db")
public class StockDbController {


    public final StockDbService stockDbService;
    public StockMapper mapper;

    @RequestMapping({"/stocks", "/stocks.html"})
    private String listStocks(Model model) {
        model.addAttribute("stockList", mapper.map(stockDbService.findAll()));

        return "/stocks";
    }
}
