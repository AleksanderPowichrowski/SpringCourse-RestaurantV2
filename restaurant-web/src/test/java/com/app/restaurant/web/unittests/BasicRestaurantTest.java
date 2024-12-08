package com.app.restaurant.web.unittests;

import com.app.resturant.model.*;
import com.app.resturant.model.constants.CHIEF_LEVEL;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicRestaurantTest {

    protected IngredientType onion;
    protected IngredientType pepper;
    protected IngredientType salad;
    protected IngredientType corn;
    protected IngredientType chicken;
    protected IngredientType beef;
    protected IngredientType pork;
    protected IngredientType fish;
    protected IngredientType lamb;
    protected KitchenWare fryingPan;
    protected KitchenWare knife;
    protected KitchenWare choppingBoard;
    protected KitchenWare bowl;
    protected KitchenWare spatula;
    protected UnitMeasure unit;
    protected Ingredient onionDetail;
    protected Ingredient pepperDetail;
    protected Ingredient saladDetail;
    protected Ingredient cornDetail;
    protected Ingredient chickenDetail;
    protected Ingredient beefDetail;
    protected Ingredient fishDetail;
    protected Ingredient lambDetail;
    protected Ingredient portDetail;

    @BeforeEach
    void setup() {

        onion = IngredientType.builder().name("ONION").isVegan(true).build();
        pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        salad = IngredientType.builder().name("SALAD").isVegan(true).build();
        corn = IngredientType.builder().name("CORN").isVegan(true).build();
        chicken = IngredientType.builder().name("CHICKEN").isVegan(false).build();
        beef = IngredientType.builder().name("BEEF").isVegan(false).build();
        pork = IngredientType.builder().name("PORK").isVegan(false).build();
        fish = IngredientType.builder().name("FISH").isVegan(false).build();
        lamb = IngredientType.builder().name("LAMB").isVegan(false).build();

        fryingPan = KitchenWare.builder().name("fryingPan").build();
        knife = KitchenWare.builder().name("knife").build();
        choppingBoard = KitchenWare.builder().name("choppingBoard").build();
        bowl = KitchenWare.builder().name("bowl").build();
        spatula = KitchenWare.builder().name("spatula").build();

        unit = UnitMeasure.builder().name("unit").build();

        onionDetail = Ingredient.builder().ingredientType(onion).unitMeasure(unit).build();
        pepperDetail = Ingredient.builder().ingredientType(pepper).unitMeasure(unit).build();
        saladDetail = Ingredient.builder().ingredientType(salad).unitMeasure(unit).build();
        cornDetail = Ingredient.builder().ingredientType(corn).unitMeasure(unit).build();
        chickenDetail = Ingredient.builder().ingredientType(chicken).unitMeasure(unit).build();
        beefDetail = Ingredient.builder().ingredientType(beef).unitMeasure(unit).build();
        fishDetail = Ingredient.builder().ingredientType(fish).unitMeasure(unit).build();
        lambDetail = Ingredient.builder().ingredientType(lamb).unitMeasure(unit).build();
        portDetail = Ingredient.builder().ingredientType(pork).unitMeasure(unit).build();


    }

    protected Recipe createFriedChickenVegetablesRecipe() {

        List<KitchenWare> kitchenWareList = List.of(fryingPan, knife, choppingBoard);

        Map<Ingredient, Long> neededIngredients = Map.of(
                onionDetail, 2L,
                pepperDetail, 3l,
                chickenDetail, 1l
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        addRecordToInstruction(recipeInstructions, "Chop vegetables");
        addRecordToInstruction(recipeInstructions, "Chop chicken");
        addRecordToInstruction(recipeInstructions, "Fry chopped chicken");
        addRecordToInstruction(recipeInstructions, "Add vegetables to frying chicken");

        return Recipe.builder()
                .name("Fried chicken with sliced vegetables")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();
    }

    protected Recipe createFriefBeefVegetablesRecipe() {


        List<KitchenWare> kitchenWareList = List.of(fryingPan, knife, choppingBoard);

        Map<Ingredient, Long> neededIngredients = Map.of(
                onionDetail, 2L,
                pepperDetail, 3L,
                chickenDetail, 1L
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        addRecordToInstruction(recipeInstructions, "Chop vegetables");
        addRecordToInstruction(recipeInstructions, "Chop beef");
        addRecordToInstruction(recipeInstructions, "Fry chhopped chicken");
        addRecordToInstruction(recipeInstructions, "Add vegetables to frying chicken");

        return Recipe.builder()
                .name("Fried beef with sliced vegetables")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();
    }

    protected Recipe createVegetableSaladRecipe() {
        List<KitchenWare> kitchenWareList = List.of(bowl, knife, choppingBoard);

        Map<Ingredient, Long> neededIngredients = Map.of(
                Ingredient.builder()
                        .ingredientType(onion)
                        .unitMeasure(unit)
                        .build(), 2L,
                Ingredient.builder()
                        .ingredientType(pepper)
                        .unitMeasure(unit).build(), 3L,
                Ingredient.builder()
                        .ingredientType(salad)
                        .unitMeasure(unit).build(), 1L,
                Ingredient.builder()
                        .ingredientType(corn)
                        .unitMeasure(unit).build(), 2L
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        addRecordToInstruction(recipeInstructions, "Chop vegetables");
        addRecordToInstruction(recipeInstructions, "Chop Put vegetables in bowl");
        addRecordToInstruction(recipeInstructions, "Chop Mig vegetables in bow");


        return Recipe.builder()
                .name("Vegetable salad")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();
    }


    private Map<Long, String> addRecordToInstruction(Map<Long, String> recipeInstructions, String record) {
        recipeInstructions.put(recipeInstructions.size() + 1L, record);
        return recipeInstructions;
    }

    Stock createStock() {
        Map<Ingredient, Long> ingredientStock = Map.of(
                onionDetail, 10L,
                pepperDetail, 10L,
                saladDetail, 10L,
                cornDetail, 10L,
                chickenDetail, 10L,
                beefDetail, 10L,
                portDetail, 10L,
                fishDetail, 10L,
                lambDetail, 10L
        );

        return Stock.builder()
                .stockDate(LocalDateTime.now())
                .ingredientStock(ingredientStock)
                .build();

    }
    protected Chief createChiefJan() {
        return Chief.builder()
                .name("Jan")
                .chiefLevel(CHIEF_LEVEL.MASTER)
                .knownRecipes(List.of(createVegetableSaladRecipe(),createFriefBeefVegetablesRecipe(),createFriedChickenVegetablesRecipe()))
                .build();
    }

    protected Chief createChiefKrzysztof() {
        return Chief.builder()
                .name("Krzysztof")
                .chiefLevel(CHIEF_LEVEL.BEGINNER)
                .knownRecipes(List.of(createVegetableSaladRecipe()))
                .build();
    }
}
