
import com.app.resturant.model.*;
import com.app.resturant.model.constants.*;
import com.app.resturant.service.map.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;

public class RestaurantTest {
    IngredientTypeMapService ingredientTypeService = new IngredientTypeMapService();

    @Test
    public void testOrder() {
//        OrderService orderService = new OrderService();
//
//        ORDER_RESULT orderResult = orderService.createOrder();
//
//        assertSame(orderResult, ORDER_RESULT.COMPLETED);
    }

    @BeforeEach
    void setup() {

        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType salad = IngredientType.builder().name("SALAD").isVegan(true).build();
        IngredientType corn = IngredientType.builder().name("CORN").isVegan(true).build();
        IngredientType chicken = IngredientType.builder().name("CHICKEN").isVegan(false).build();
        IngredientType beef = IngredientType.builder().name("BEEF").isVegan(false).build();
        IngredientType pork = IngredientType.builder().name("PORK").isVegan(false).build();
        IngredientType fish = IngredientType.builder().name("FISH").isVegan(false).build();
        IngredientType lamb = IngredientType.builder().name("LAMB").isVegan(false).build();
        ingredientTypeService.save(onion);
        ingredientTypeService.save(pepper);
        ingredientTypeService.save(salad);
        ingredientTypeService.save(corn);
        ingredientTypeService.save(chicken);
        ingredientTypeService.save(beef);
        ingredientTypeService.save(pork);
        ingredientTypeService.save(lamb);
        ingredientTypeService.save(fish);
    }

    @Test
    public void checkIngedientType() {
        IngredientTypeMapService ingredientTypeService = new IngredientTypeMapService();
        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType salad = IngredientType.builder().name("SALAD").isVegan(true).build();
        IngredientType corn = IngredientType.builder().name("CORN").isVegan(true).build();
        IngredientType chicken = IngredientType.builder().name("CHICKEN").isVegan(false).build();
        IngredientType beef = IngredientType.builder().name("BEEF").isVegan(false).build();
        IngredientType pork = IngredientType.builder().name("PORK").isVegan(false).build();
        IngredientType fish = IngredientType.builder().name("FISH").isVegan(false).build();
        IngredientType lamb = IngredientType.builder().name("LAMB").isVegan(false).build();
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
        StockMapService stockService = new StockMapService();
        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType salad = IngredientType.builder().name("SALAD").isVegan(true).build();
        IngredientType corn = IngredientType.builder().name("CORN").isVegan(true).build();
        IngredientType chicken = IngredientType.builder().name("CHICKEN").isVegan(false).build();
        IngredientType beef = IngredientType.builder().name("BEEF").isVegan(false).build();
        IngredientType pork = IngredientType.builder().name("PORK").isVegan(false).build();
        IngredientType fish = IngredientType.builder().name("FISH").isVegan(false).build();
        IngredientType lamb = IngredientType.builder().name("LAMB").isVegan(false).build();
        Map<IngredientType, Long> ingredientStock = Map.of(
                onion, 10L,
                pepper, 10L,
                salad, 10L,
                corn, 10L,
                chicken, 10L,
                beef, 10L,
                pork, 10L,
                fish, 10L,
                lamb, 10L
        );

        Stock stock = Stock.builder()
                .stockDate(new Date())
                .ingredientStock(ingredientStock)
                .build();
        stockService.save(stock);
    }

    @Test
    public void testKichenWare() {
        KitchenWareMapService kitchenWareService = new KitchenWareMapService();

        KitchenWare fryingPan = KitchenWare.builder().name("fryingPan").build();
        KitchenWare knife = KitchenWare.builder().name("knife").build();
        KitchenWare choppingBoard = KitchenWare.builder().name("choppingBoard").build();
        KitchenWare spatula = KitchenWare.builder().name("spatula").build();
        KitchenWare bowl = KitchenWare.builder().name("bowl").build();

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
        RecipeMapService recipeService = new RecipeMapService();
        KitchenWare fryingPan = KitchenWare.builder().name("fryingPan").build();
        KitchenWare knife = KitchenWare.builder().name("knife").build();
        KitchenWare choppingBoard = KitchenWare.builder().name("choppingBoard").build();
        List<KitchenWare> kitchenWareList = List.of(fryingPan, knife, choppingBoard);


        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType chicken = IngredientType.builder().name("CHICKEN").isVegan(false).build();

        Map<Ingredient, Long> neededIngredients = Map.of(
                Ingredient.builder()
                        .ingredientType(onion)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 2l,
                Ingredient.builder()
                        .ingredientType(pepper)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 3l,
                Ingredient.builder()
                        .ingredientType(chicken)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 1l
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

        ChiefMapService chiefService = new ChiefMapService();
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

        ChiefMapService chiefService = new ChiefMapService();

        chiefService.save(chief);

        Assertions.assertFalse(chiefService.checkIfChiefCanMakeRecipe("Jan", "Vegetable salad"));
        Assertions.assertTrue(chiefService.checkIfChiefCanMakeRecipe("Jan", "Fried beef with sliced vegetables"));
    }

    private Recipe createFriedChickenVegetablesRecipe() {
        RecipeMapService recipeService = new RecipeMapService();
        KitchenWare fryingPan = KitchenWare.builder().name("fryingPan").build();
        KitchenWare knife = KitchenWare.builder().name("knife").build();
        KitchenWare choppingBoard = KitchenWare.builder().name("choppingBoard").build();
        List<KitchenWare> kitchenWareList = List.of(fryingPan, knife, choppingBoard);


        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType chicken = IngredientType.builder().name("CHICKEN").isVegan(false).build();

        Map<Ingredient, Long> neededIngredients = Map.of(
                Ingredient.builder()
                        .ingredientType(onion)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 2L,
                Ingredient.builder()
                        .ingredientType(pepper)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 3l,
                Ingredient.builder()
                        .ingredientType(chicken)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 1l
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop vegetables");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop chicken");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Fry chhopped chicken");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Add vegetables to frying chicken");

        return Recipe.builder()
                .name("Fried chicken with sliced vegetables")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();
    }

    private Recipe createFriefBeefVegetablesRecipe() {
        RecipeMapService recipeService = new RecipeMapService();
        KitchenWare fryingPan = KitchenWare.builder().name("fryingPan").build();
        KitchenWare knife = KitchenWare.builder().name("knife").build();
        KitchenWare choppingBoard = KitchenWare.builder().name("choppingBoard").build();
        List<KitchenWare> kitchenWareList = List.of(fryingPan, knife, choppingBoard);


        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType chicken = IngredientType.builder().name("BEEF").isVegan(false).build();

        Map<Ingredient, Long> neededIngredients = Map.of(
                Ingredient.builder()
                        .ingredientType(onion)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build()
                , 2L,
                Ingredient.builder()
                        .ingredientType(pepper)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 3L,
                Ingredient.builder()
                        .ingredientType(chicken)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 1L
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop vegetables");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop beef");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Fry chhopped chicken");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Add vegetables to frying chicken");

        return Recipe.builder()
                .name("Fried beef with sliced vegetables")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();
    }

    private Recipe createVegetableSaladRecipe() {
        RecipeMapService recipeService = new RecipeMapService();
        KitchenWare bowl = KitchenWare.builder().name("bowl").build();
        KitchenWare knife = KitchenWare.builder().name("knife").build();
        KitchenWare choppingBoard = KitchenWare.builder().name("choppingBoard").build();
        List<KitchenWare> kitchenWareList = List.of(bowl, knife, choppingBoard);


        IngredientType onion = IngredientType.builder().name("ONION").isVegan(true).build();
        IngredientType pepper = IngredientType.builder().name("PEPPER").isVegan(true).build();
        IngredientType salad = IngredientType.builder().name("SALAD").isVegan(false).build();
        IngredientType corn = IngredientType.builder().name("CORN").isVegan(false).build();

        Map<Ingredient, Long> neededIngredients = Map.of(
                Ingredient.builder()
                        .ingredientType(onion)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build())
                        .build(), 2L,
                Ingredient.builder()
                        .ingredientType(pepper)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build()).build(), 3L,
                Ingredient.builder()
                        .ingredientType(salad)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build()).build(), 1L,
                Ingredient.builder()
                        .ingredientType(corn)
                        .unitMeasure(UnitMeasure.builder()
                                .unit("unit").build()).build(), 2L
        );

        Map<Long, String> recipeInstructions = new HashMap<>();

        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Chop vegetables");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Put vegetables in bowl");
        recipeInstructions = recipeService.addRecordToInstruction(recipeInstructions, "Mig vegetables in bowl");

        return Recipe.builder()
                .name("Vegetable salad")
                .neededIngredients(neededIngredients)
                .neededKitchenWare(kitchenWareList)
                .instructions(recipeInstructions)
                .build();
    }
}
