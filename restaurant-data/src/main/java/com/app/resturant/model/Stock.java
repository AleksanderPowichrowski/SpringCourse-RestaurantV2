package com.app.resturant.model;

import jakarta.persistence.Table;
import lombok.Builder;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Table(name = "stocks")
@ToString
public class Stock extends BaseEntity{

    private Date stockDate;
    private Map<IngredientType, Integer> ingredientStock;

    @Builder
    public Stock(Map<IngredientType, Integer> ingredientStock, Date stockDate ){
        this.ingredientStock = ingredientStock;
        this.stockDate = stockDate;
    }

}
