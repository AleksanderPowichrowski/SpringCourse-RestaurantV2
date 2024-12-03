package com.ap.restaurant.web.controller;


import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.IngredientType;
import com.app.resturant.model.Stock;
import com.app.resturant.service.map.StockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class StockController {

    private StockService stockService;

    @RequestMapping({"/stocks","/stocks.html"})
    private String listStocks(Model model){
        Set<Stock> stockList = stockService.findAll().stream()
                .sorted(Comparator.comparing(BaseEntity::getId))
                .collect(Collectors.toSet());

        // Create a map to hold stock information
        List<Map<String, Object>> stockData = stockList.stream().map(stock -> {
            // Get the ingredientStock map and format it
            Map<IngredientType, Long> ingredientStock = stock.getIngredientStock();

            // Convert the ingredientStock map to a list of strings formatted as "IngredientName (amount)"
            String ingredientsFormatted = ingredientStock.entrySet().stream()
                    .map(entry -> entry.getKey().getName() + " (" + entry.getValue() + ")")
                    .collect(Collectors.joining("<br/>"));

            // Create a map to hold both the stock date and the formatted ingredient stock
            Map<String, Object> stockInfo = new HashMap<>();
            stockInfo.put("stockDate", stock.getStockDate());
            stockInfo.put("ingredients", ingredientsFormatted);
            stockInfo.put("Id", stock.getId());

            return stockInfo;
        }).collect(Collectors.toList());

        // Add the processed stock data to the model
        model.addAttribute("stockList", stockData);
        return "/stocks";
    }
}
