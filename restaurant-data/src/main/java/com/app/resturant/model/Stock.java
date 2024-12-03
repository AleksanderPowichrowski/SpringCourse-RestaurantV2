package com.app.resturant.model;

import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Table(name = "stocks")
@ToString
@Getter
public class Stock extends BaseEntity{

    private Date stockDate;
    private Map<IngredientType, Long> ingredientStock;

    @Builder
    public Stock(Map<IngredientType, Long> ingredientStock, Date stockDate ){
        this.ingredientStock = ingredientStock;
        this.stockDate = stockDate;
    }

}
