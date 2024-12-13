package com.app.resturant.service.map;

import com.app.resturant.BasicRestaurantTest;
import com.app.resturant.model.*;
import com.app.resturant.model.constants.CHIEF_LEVEL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RestaurantMapTest extends BasicRestaurantTest {
    IngredientTypeMapService ingredientTypeService = new IngredientTypeMapService();
    StockMapService stockService = new StockMapService();
    KitchenWareMapService kitchenWareService = new KitchenWareMapService();
    RecipeMapService recipeService = new RecipeMapService();
    ChiefMapService chiefService = new ChiefMapService();


    @Test
    public void checkIngredientType() {

        ingredientTypeService.save(onion);
        ingredientTypeService.save(pepper);
        ingredientTypeService.save(salad);
        ingredientTypeService.save(corn);
        ingredientTypeService.save(chicken);
        ingredientTypeService.save(beef);
        ingredientTypeService.save(pork);
        ingredientTypeService.save(lamb);
        ingredientTypeService.save(fish);

        Assertions.assertTrue(ingredientTypeService.findAll().contains(onion));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(pepper));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(salad));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(corn));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(chicken));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(chicken));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(beef));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(pork));
        Assertions.assertTrue(ingredientTypeService.findAll().contains(fish));
    }

    @Test
    public void checkStock() {

        Stock stock = createStock();

        stockService.save(stock);

        Assertions.assertTrue(stockService.findAll().contains(stock));
    }



    @Test
    public void testKichenWare() {


        kitchenWareService.save(fryingPan);
        kitchenWareService.save(knife);
        kitchenWareService.save(choppingBoard);
        kitchenWareService.save(spatula);
        kitchenWareService.save(bowl);

        Assertions.assertTrue(kitchenWareService.findAll().contains(fryingPan));
        Assertions.assertTrue(kitchenWareService.findAll().contains(knife));
        Assertions.assertTrue(kitchenWareService.findAll().contains(choppingBoard));
        Assertions.assertTrue(kitchenWareService.findAll().contains(spatula));
        Assertions.assertTrue(kitchenWareService.findAll().contains(bowl));


    }

    @Test
    public void testRecipeCreation() {

        List<KitchenWare> kitchenWareList = List.of(fryingPan, knife, choppingBoard);


        Map<Ingredient, Long> neededIngredients = Map.of(
                onionDetail, 2l,
                pepperDetail, 3l,
                chickenDetail, 1l
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop vegetables");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop chicken");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Fry chhopped chicken");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Add vegetables to frying chicken");

        Recipe recipe = Recipe.builder()
                .name("Fried chicken with sliced vegetables")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();

        recipeService.save(recipe);

        Assertions.assertTrue(recipeService.findAll().contains(recipe));
        Assertions.assertEquals(4, recipeService.findById(1L).getInstructions().size());
    }

    @Test
    public void testChief() {
        List<Recipe> listOfKnownRecipes = List.of(
                createFriefBeefVegetablesRecipe(),
                createFriefBeefVegetablesRecipe()
        );
        Chief chief = Chief.builder()
                .name("Jan")
                .chiefLevel(CHIEF_LEVEL.MASTER)
                .knownRecipes(listOfKnownRecipes)
                .build();


        chiefService.save(chief);

        Assertions.assertTrue(chiefService.findAll().contains(chief));
    }

    @Test
    public void testCreateRecipe() {
        List<Recipe> listOfKnownRecipes = List.of(
                createFriefBeefVegetablesRecipe()
        );
        Chief chief = Chief.builder()
                .name("Jan")
                .chiefLevel(CHIEF_LEVEL.MASTER)
                .knownRecipes(listOfKnownRecipes)
                .build();



        chiefService.save(chief);

        Assertions.assertFalse(chiefService.checkIfChiefCanMakeRecipe("Jan", "Vegetable salad"));
        Assertions.assertTrue(chiefService.checkIfChiefCanMakeRecipe("Jan", "Fried beef with sliced vegetables"));


    }

}
