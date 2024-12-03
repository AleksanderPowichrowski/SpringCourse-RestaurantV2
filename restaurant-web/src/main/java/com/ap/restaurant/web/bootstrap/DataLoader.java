package com.ap.restaurant.web.bootstrap;

import com.ap.restaurant.web.RestaurantWebApplication;
import com.ap.restaurant.web.config.RestaurantConfiguration;
import com.ap.restaurant.web.config.model.RestaurantConfig;
import com.app.resturant.model.*;
import com.app.resturant.model.constants.CHIEF_LEVEL;
import com.app.resturant.service.map.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
@ComponentScan("com.app.resturant.model.constants")
@Profile("map")
public class DataLoader implements CommandLineRunner {


    private final IngredientTypeService ingredientTypeService;
    private final KitchenWareService kitchenWareService;
    private final ChiefService chiefService;
    private final RecipeService recipeService;
    private final StockService stockService;
    private final ApplicationContext ctx;



    @Override
    public void run(String... args) throws Exception {
        RestaurantConfig restaurantConfig =  ctx.getBean(RestaurantConfig.class);

        List<IngredientType> ingredientTypeList =  restaurantConfig.getIngredientType();
        Map<IngredientType, Long> stockCapacityList = restaurantConfig.getStockWithIngredientTypes();
        List<KitchenWare> kitchenWareList = restaurantConfig.getKitchenWare();
        List<Recipe> recipeList = restaurantConfig.getRecipesFrom();


        List<Chief> chiefList = restaurantConfig.getChiefs();

        ingredientTypeList.forEach(ingredientTypeService::save);
        kitchenWareList.forEach(kitchenWareService::save);
        recipeList.forEach(recipeService::save);
        chiefList.forEach(chiefService::save);

        stockService.save(Stock.builder()
                .ingredientStock(stockCapacityList)
                .stockDate(new Date())
                .build());


    }

}
