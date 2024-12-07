package com.app.restaurant.web.config;

import com.app.resturant.service.map.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootConfiguration
@Profile("map")
public class RestaurantMapConfiguration {

    @Bean
    public ChiefMapService getChiefService(){
        return new ChiefMapService();
    }
    @Bean
    public RecipeMapService getRecipeService(){
        return new RecipeMapService();
    }
    @Bean
    public StockMapService getStockService(){
        return new StockMapService();
    }
    @Bean
    public KitchenWareMapService getKitchenWareService(){
        return new KitchenWareMapService();
    }
    @Bean
    public IngredientTypeMapService getIngredientTypeService(){
        return new IngredientTypeMapService();
    }
    @Bean
    public UnitMeasureMapService getUnitMeasureService(){
        return new UnitMeasureMapService();
    }



}
