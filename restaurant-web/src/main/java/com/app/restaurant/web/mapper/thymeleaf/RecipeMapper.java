package com.app.restaurant.web.mapper.thymeleaf;

import com.app.restaurant.web.mapper.Mapper;
import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.KitchenWare;
import com.app.resturant.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RecipeMapper implements Mapper<Recipe, Map<Recipe,Map<String, String>>> {
    @Override
    public Map<Recipe,Map<String, String>> map(Set<Recipe> object) {
        return object.stream()
                .sorted(Comparator.comparing(BaseEntity::getId)).toList().stream()
                .collect(Collectors.toMap(
                        recipe -> recipe,
                        recipe -> Map.of(
                                "ingredients", recipe.getNeededIngredients().entrySet().stream()
                                        .map(entry -> entry.getValue()
                                                + " " + entry.getKey().getUnitMeasure().getName() +" " +entry.getKey().getIngredientType().getName() )
                                        .collect(Collectors.joining("<br/>")),
                                "kitchenWare", recipe.getNeededKitchenWare().stream()
                                        .map(KitchenWare::getName)
                                        .collect(Collectors.joining("<br/>"))
                        )
                )).entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getId()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) ->  e2,
                        LinkedHashMap::new
                ));
    }
}
