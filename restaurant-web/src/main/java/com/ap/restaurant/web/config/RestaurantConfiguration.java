package com.ap.restaurant.web.config;

import com.app.resturant.service.map.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class RestaurantConfiguration {

    @Bean
    public ChiefService getChiefService(){
        return new ChiefService();
    }
    @Bean
    public RecipeService getRecipeService(){
        return new RecipeService();
    }

    @Bean
    public StockService getStockService(){
        return new StockService();
    }
    @Bean
    public KitchenWareService getKitchenWareService(){
        return new KitchenWareService();
    }

    @Bean
    public IngredientTypeService getIngredientTypeService(){
        return new IngredientTypeService();
    }

}
