package com.app.restaurant.web.bootstrap;

import com.app.resturant.service.map.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component

@ComponentScan("com.app.resturant.model.constants")
@Profile("map")
@Slf4j
public class MapDataLoader extends AbstractDataLoader {


    private final IngredientTypeMapService ingredientTypeService;
    private final KitchenWareMapService kitchenWareService;
    private final ChiefMapService chiefService;
    private final RecipeMapService recipeService;
    private final StockMapService stockService;
    private final UnitMeasureMapService unitService;

    public MapDataLoader(ApplicationContext ctx,
                         IngredientTypeMapService ingredientTypeService,
                         KitchenWareMapService kitchenWareService,
                         ChiefMapService chiefService,
                         RecipeMapService recipeService,
                         StockMapService stockService,
                         UnitMeasureMapService unitService) {
        super(ctx);
        this.ingredientTypeService = ingredientTypeService;
        this.kitchenWareService = kitchenWareService;
        this.chiefService = chiefService;
        this.recipeService = recipeService;
        this.stockService = stockService;
        this.unitService = unitService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Loading data from configuration to map");
        super.onApplicationEvent(event);
        ingredientTypeList.forEach(ingredientTypeService::save);
        kitchenWareList.forEach(kitchenWareService::save);
        stockCapacityList.forEach(stockService::save);
        unitMeasureList.forEach(unitService::save);
        recipeList.forEach(recipeService::save);
        chiefList.forEach(chiefService::save);
    }
}

