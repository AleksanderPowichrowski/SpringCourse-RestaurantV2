package com.app.restaurant.web.config.model;


import com.app.resturant.model.*;
import com.app.resturant.model.constants.CHIEF_LEVEL;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.IncompatibleConfigurationException;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties("restaurant")
@Getter
@Setter
public class RestaurantConfig {
    private String name;
    private List<UnitMeasure> units = new ArrayList<>();
    private Map<String, Map<String, Object>> stockCapacity = new HashMap<>();
    private List<IngredientType> ingredientType = new ArrayList<>();
    private List<KitchenWare> kitchenWare = new ArrayList<>();
    private List<Map<String, Object>> recipes = new ArrayList<>();
    private List<Map<String, Object>> chiefs = new ArrayList<>();

    public List<Stock> getStockWithIngredientTypes() {
        Map<String, IngredientType> ingredientTypeMap = ingredientType.stream()
                .collect(Collectors.toMap(IngredientType::getName, ingredient -> ingredient));

        Map<Ingredient, Long> resultMap = new HashMap<>();

        stockCapacity.forEach((ingredientName, details) -> {
            IngredientType type = ingredientTypeMap.get(ingredientName);
            if (type == null) {
                throw new IncompatibleConfigurationException(
                        "Ingredient type '" + ingredientName + "' in stock not found in declared Ingredient Types");
            }

            String amount = String.valueOf(details.get("amount"));
            if (amount == null) {
                throw new IncompatibleConfigurationException(
                        "Missing 'amount' for ingredient type '" + ingredientName + "' in stock capacity");
            }

            Object unitObj = details.get("unit");
            if (unitObj == null || !(unitObj instanceof String)) {
                throw new IncompatibleConfigurationException(
                        "Invalid or missing 'unit' for ingredient type '" + ingredientName + "' in stock capacity");
            }
            String unit = (String) unitObj;

            Ingredient ingredient = Ingredient.builder()
                    .ingredientType(type)
                    .unitMeasure(units.stream().filter( u -> u.getName().equalsIgnoreCase(unit)).findFirst().orElse(null))
                    .build();

            resultMap.put(ingredient, Long.parseLong(amount));
        });

        return List.of(Stock.builder()
                .ingredientStock(resultMap)
                .stockDate(LocalDateTime.now())
                .build());
    }

    public List<Recipe> getRecipesFrom() {

        Map<String, IngredientType> ingredientTypeMap = ingredientType.stream()
                .collect(Collectors.toMap(IngredientType::getName, ingredient -> ingredient));

        Set<String> validUnitMeasures = units.stream()
                .map(UnitMeasure::getName)
                .collect(Collectors.toSet());

        return recipes.stream().map(recipeData -> {
            String recipeName = (String) recipeData.get("name");

            Map<String, Map<String, Object>> neededIngredientsMap =
                    (Map<String, Map<String, Object>>) recipeData.get("neededIngredients");

            Map<Ingredient, Long> neededIngredients = new HashMap<>();
            neededIngredientsMap.forEach((ingredientName, details) -> {

                IngredientType ingredientType = ingredientTypeMap.get(ingredientName);

                if (ingredientType == null) {
                    throw new RuntimeException("Ingredient type '" + ingredientName + "' not found.");
                }

                String unit;
                long amount = Long.parseLong(details.get("amount").toString());
                unit = (String) details.get("unit");
                if (unit == null || unit.isEmpty()) {
                    unit = "";
                } else {
                    if (!validUnitMeasures.contains(unit)) {
                        throw new RuntimeException("Invalid unit '" + unit + "' for ingredient: " + ingredientName);
                    }
                }

                String finalUnit = unit;
                Ingredient ingredient = Ingredient.builder()
                        .ingredientType(ingredientType)
                        .unitMeasure(getUnits().stream().filter( u -> u.getName().equalsIgnoreCase(finalUnit)).findFirst().orElse(null))
                        .build();

                neededIngredients.put(ingredient, amount);
            });

            List<KitchenWare> neededKitchenWareList = ((LinkedHashMap<String, String>) recipeData.get("neededKitchenWare")).values().stream()
                    .map(value -> getKitchenWare().stream().filter(kitchenWare -> kitchenWare.getName().equalsIgnoreCase(value)).findFirst().orElse(null))
                    .toList();

            Map<String, String> instructions = (Map<String, String>) recipeData.get("instructions");
            Map<Long, String> transformedInstructions = instructions.entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> Long.parseLong(entry.getKey()),
                            Map.Entry::getValue
                    ));


            return Recipe.builder()
                    .name(recipeName)
                    .neededIngredients(neededIngredients)
                    .neededKitchenWare(neededKitchenWareList)
                    .instructions(transformedInstructions)
                    .build();
        }).collect(Collectors.toList());
    }

    public List<Chief> getChiefs(List<Recipe> allRecipes) {
        return chiefs.stream().map(chiefConfig -> {
            String chiefName = (String) chiefConfig.get("name");
            String chiefLevelStr = (String) chiefConfig.get("chiefLevel");
            CHIEF_LEVEL chiefLevel = CHIEF_LEVEL.valueOf(chiefLevelStr.toUpperCase());


            List<Recipe> knownRecipes = ((LinkedHashMap<String, String>) chiefConfig.get("knownRecipes"))
                    .entrySet().stream()
                    .map(Map.Entry::getValue)
                    .flatMap(
                            value -> allRecipes.stream().filter(recipe -> recipe.getName().equalsIgnoreCase(value))
                    )
                    .toList();

            return Chief.builder()
                    .name(chiefName)
                    .chiefLevel(chiefLevel)
                    .knownRecipes(knownRecipes)
                    .build();
        }).collect(Collectors.toList());
    }


}
