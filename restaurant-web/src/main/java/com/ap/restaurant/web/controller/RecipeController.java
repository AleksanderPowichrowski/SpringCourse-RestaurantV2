package com.ap.restaurant.web.controller;


import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.Recipe;
import com.app.resturant.service.map.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.resturant.model.KitchenWare;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;


    @RequestMapping({"/recipes", "/recipes.html"})
    private String listTypes(Model model) {

        model.addAttribute(
                "recipesWithDetails",
                recipeService.findAll().stream()
                        .sorted(Comparator.comparing(BaseEntity::getId)).toList().stream()
                        .collect(Collectors.toMap(
                                recipe -> recipe,
                                recipe -> Map.of(
                                        "ingredients", recipe.getNeededIngredients().entrySet().stream()
                                                .map(entry -> entry.getKey().getName() + " - " + entry.getValue())
                                                .collect(Collectors.joining("<br/>")),
                                        "kitchenWare", recipe.getNeededKitchenWare().stream()
                                                .map(KitchenWare::getName) // Extract the name of each kitchenware
                                                .collect(Collectors.joining("<br/>"))
                                )
                        ))
        );
        return "/recipes";
    }
}
