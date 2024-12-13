package com.app.restaurant.web.bootstrap;

import com.app.restaurant.web.config.model.RestaurantConfig;
import com.app.resturant.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.List;


public class AbstractDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext ctx;
    RestaurantConfig restaurantConfig;
    List<IngredientType> ingredientTypeList;
    List<Stock> stockCapacityList;
    List<KitchenWare> kitchenWareList;
    List<UnitMeasure> unitMeasureList;
    List<Recipe> recipeList;
    List<Chief> chiefList;
    List<Dish> dishList;
    List<Order> orderList = new ArrayList<>();


    public AbstractDataLoader(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadDataFromConfig();
    }

    protected void loadDataFromConfig(){
        restaurantConfig =  ctx.getBean(RestaurantConfig.class);
        ingredientTypeList =  restaurantConfig.getIngredientType();
        stockCapacityList = restaurantConfig.getStockWithIngredientTypes();
        kitchenWareList = restaurantConfig.getKitchenWare();
        unitMeasureList = restaurantConfig.getUnits();
        recipeList = restaurantConfig.getRecipesFrom();
        chiefList = restaurantConfig.getChiefs(recipeList);
        dishList = restaurantConfig.getDishes();
    }
}
