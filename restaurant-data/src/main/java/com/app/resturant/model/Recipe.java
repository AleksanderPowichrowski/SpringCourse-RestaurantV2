package com.app.resturant.model;


import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Table(name = "recipes")
@ToString
@Getter
public class Recipe extends BaseEntity {
    private final String name;
    List<KitchenWare> neededKitchenWare;
    Map<Long, String> instructions;
    Map<IngredientType, Integer> neededIngredients;


    @Builder
    public Recipe(String name, Map<IngredientType, Integer> neededIngredients, List<KitchenWare> neededKitchenWare, Map<Long, String> instructions) {
        this.name = name;
        this.neededIngredients = neededIngredients;
        this.neededKitchenWare = neededKitchenWare;
        this.instructions = instructions;
    }
}
