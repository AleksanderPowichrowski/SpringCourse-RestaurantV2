package com.ap.restaurant.web.config.model;


import com.app.resturant.model.Chief;
import com.app.resturant.model.IngredientType;
import com.app.resturant.model.KitchenWare;
import com.app.resturant.model.Recipe;
import com.app.resturant.model.constants.CHIEF_LEVEL;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.IncompatibleConfigurationException;
import org.springframework.context.annotation.Configuration;


import java.util.*;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties("restaurant")
@Getter
@Setter
public class RestaurantConfig {
    private String name;
    private Map<String, Map<String, Long>> stockCapacity = new HashMap<>();
    private List<IngredientType> ingredientType = new ArrayList<>();
    private List<KitchenWare> kitchenWare = new ArrayList<>();
    private List<Map<String, Object>> recipes = new ArrayList<>();
    private List<Map<String, Object>> chiefs = new ArrayList<>();



    public Map<IngredientType, Long> getStockWithIngredientTypes() {
        // Create a map of ingredient names to IngredientType objects
        Map<String, IngredientType> ingredientTypeMap = ingredientType.stream()
                .collect(Collectors.toMap(IngredientType::getName, ingredient -> ingredient));

        // Transform the stock map into a result map of IngredientType to Long
        Map<IngredientType, Long> resultMap = new HashMap<>();
        stockCapacity.forEach((ingredientName, details) -> {
            IngredientType type = ingredientTypeMap.get(ingredientName);
            if (type != null) {
                Long amount = details.get("amount");
                if (amount != null) {
                    resultMap.put(type, amount);
                }
            }
            else {
                throw new IncompatibleConfigurationException("Ingredient type" + type +" in stock not found in declared Ingredient Types");
            }
        });

        return resultMap;
    }

    public List<Recipe> getRecipesFrom() {
        // Ensure ingredientTypes and kitchenWare are available
        Map<String, IngredientType> ingredientTypeMap = ingredientType.stream()
                .collect(Collectors.toMap(IngredientType::getName, ingredient -> ingredient));

        // Now convert the recipes map to Recipe objects
        return recipes.stream().map(recipeData -> {
            String recipeName = (String) recipeData.get("name");

            // Convert neededIngredients from Map<String, Long> to Map<IngredientType, Long>
            Map<String, Integer> neededIngredientsMap = (Map<String, Integer>) recipeData.get("neededIngredients");
            Map<IngredientType, Integer> neededIngredients = new HashMap<>();
            neededIngredientsMap.forEach((ingredientName, amount) -> {
                IngredientType ingredientType = ingredientTypeMap.get(ingredientName);
                if (ingredientType != null) {
                    neededIngredients.put(ingredientType, amount);
                } else {
                    throw new RuntimeException("Ingredient type '" + ingredientName + "' not found.");
                }
            });

            // Convert neededKitchenWare from List<String> to List<KitchenWare>
            // Convert map to a stream of entrySet
            List<KitchenWare> neededKitchenWareList = ((LinkedHashMap<String,String>)recipeData.get("neededKitchenWare")).values().stream()
                    .map(value -> KitchenWare.builder().name(value).build())
                    .toList();

            // Convert instructions
            Map<String, String> instructions = (Map<String, String>) recipeData.get("instructions");

            Map<Long, String> transformInstr = instructions.entrySet().stream().collect(Collectors.toMap( entry -> Long.parseLong(entry.getKey()),  // Convert the String key to Long
                    Map.Entry::getValue));


            return Recipe.builder()
                    .name(recipeName)
                    .neededIngredients(neededIngredients)
                    .neededKitchenWare(neededKitchenWareList)
                    .instructions(transformInstr)
                    .build();
        }).collect(Collectors.toList());
    }
    public List<Chief> getChiefs() {
        return chiefs.stream().map(chiefConfig -> {
            // Extract the chief's name and level
            String chiefName = (String) chiefConfig.get("name");
            String chiefLevelStr = (String) chiefConfig.get("chiefLevel");
            CHIEF_LEVEL chiefLevel = CHIEF_LEVEL.valueOf(chiefLevelStr.toUpperCase());

            // Convert the knownRecipes from List<String> to List<String> (already correct format)
            List<Recipe> knownRecipes = ((LinkedHashMap<String, String>) chiefConfig.get("knownRecipes"))
                    .entrySet().stream()  // Stream over the entry set of knownRecipes
                    .map(Map.Entry::getValue)  // Get the recipe name (value) from the entry
                    .flatMap( value -> getRecipesFrom().stream().filter(recipe -> recipe.getName().equalsIgnoreCase(value)))
                    .toList();


            // Use the builder pattern to create a Chief object with the known recipe names
            return Chief.builder()
                    .name(chiefName)
                    .chiefLevel(chiefLevel)
                    .knownRecipes(knownRecipes)  // Pass the list of recipe names directly
                    .build();
        }).collect(Collectors.toList());
    }




}
