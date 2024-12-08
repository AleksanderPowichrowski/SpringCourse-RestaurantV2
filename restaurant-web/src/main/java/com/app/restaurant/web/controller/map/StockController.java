package com.app.restaurant.web.controller.map;


import com.app.restaurant.web.mapper.thymeleaf.StockMapper;
import com.app.resturant.service.map.StockMapService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@Profile("map")
public class StockController {

    private StockMapService stockService;
    private StockMapper mapper;

    @RequestMapping({"/stocks","/stocks.html"})
    public String listStocks(Model model){

        model.addAttribute("stockList", mapper.map(stockService.findAll()));
        return "/stocks";
    }
}
