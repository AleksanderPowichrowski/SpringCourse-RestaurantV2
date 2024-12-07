package com.app.restaurant.web.mapper.thymeleaf;

import com.app.restaurant.web.mapper.Mapper;
import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.Ingredient;
import com.app.resturant.model.Stock;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class StockMapper implements Mapper<Stock,  List<Map<String, Object>>> {


    @Override
    public  List<Map<String, Object>> map(Set<Stock> object) {
            List<Map<String, Object>> stockData = object.stream().map(stock -> {
            Map<Ingredient, Long> ingredientStock = stock.getIngredientStock();

            String ingredientsFormatted = ingredientStock.entrySet().stream()
                    .map(entry -> entry.getKey().getIngredientType().getName() + " - " + entry.getValue() + " " + entry.getKey().getUnitMeasure().getName())
                    .collect(Collectors.joining("<br/>"));

            Map<String, Object> stockInfo = new HashMap<>();
            stockInfo.put("stockDate", stock.getStockDate());
            stockInfo.put("ingredients", ingredientsFormatted);
            stockInfo.put("Id", stock.getId());

            return stockInfo;
        }).toList();
        return stockData.stream().sorted(Comparator.comparingInt(entry -> {
                    Map<String, Object> innerMap = (Map<String, Object>) entry.values().iterator().next();
                    return (int) innerMap.get("ID");
                }))
                .collect(Collectors.toList());
    }
}
