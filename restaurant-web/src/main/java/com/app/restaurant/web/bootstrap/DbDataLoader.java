package com.app.restaurant.web.bootstrap;

import com.app.resturant.service.db.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.app.resturant")
@Profile("db")
@Slf4j
public class DbDataLoader extends AbstractDataLoader {

    private final IngredientTypeDbService ingredientTypeDbService;
    private final KitchenWareDbService kitchenWareDbService;
    private final StockDbService stockDbService;
    private final UnitMeasureDbService unitMeasureDbService;
    private final ChiefDbService chiefDbService;
    private final RecipeDbService recipeDbService;
    private final DishDbService dishDbService;


    public DbDataLoader(ApplicationContext ctx,
                        IngredientTypeDbService ingredientTypeDbService,
                        KitchenWareDbService kitchenWareDbService,
                        StockDbService stockDbService,
                        UnitMeasureDbService unitMeasureDbService,
                        ChiefDbService chiefDbService,
                        RecipeDbService recipeDbService,
                        DishDbService dishDbService){
        super(ctx);
        this.ingredientTypeDbService = ingredientTypeDbService;
        this.kitchenWareDbService = kitchenWareDbService;
        this.stockDbService = stockDbService;
        this.unitMeasureDbService = unitMeasureDbService;
        this.chiefDbService = chiefDbService;
        this.recipeDbService = recipeDbService;
        this.dishDbService = dishDbService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.debug("Loading data from configuration to DB");
        super.onApplicationEvent(event);
        ingredientTypeDbService.saveAll(ingredientTypeList);
        kitchenWareDbService.saveAll(kitchenWareList);
        unitMeasureDbService.saveAll(unitMeasureList);
        stockDbService.saveAll(stockCapacityList);
        recipeDbService.saveAll(recipeList);
        chiefDbService.saveAll(chiefList);
        dishDbService.saveAll(dishList);
    }
}
