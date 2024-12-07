package com.app.restaurant.web.bootstrap;

import com.app.restaurant.web.config.model.RestaurantConfig;
import com.app.resturant.model.*;
import com.app.resturant.repositories.RecipeDbRepository;
import com.app.resturant.service.db.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private final RecipeDbRepository recipeDbRepository;

    public DbDataLoader(ApplicationContext ctx,
                        IngredientTypeDbService ingredientTypeDbService,
                        KitchenWareDbService kitchenWareDbService,
                        StockDbService stockDbService,
                        UnitMeasureDbService unitMeasureDbService,
                        ChiefDbService chiefDbService,
                        RecipeDbRepository recipeDbRepository) {
        super(ctx);
        this.ingredientTypeDbService = ingredientTypeDbService;
        this.kitchenWareDbService = kitchenWareDbService;
        this.stockDbService = stockDbService;
        this.unitMeasureDbService = unitMeasureDbService;
        this.chiefDbService = chiefDbService;
        this.recipeDbRepository = recipeDbRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.debug("Loading data from configuration to DB");
        super.onApplicationEvent(event);
        ingredientTypeDbService.saveAll(ingredientTypeList);
        kitchenWareDbService.saveAll(kitchenWareList);
        unitMeasureDbService.saveAll(unitMeasureList);
        stockDbService.saveAll(stockCapacityList);
        recipeDbRepository.saveAll(recipeList);
        chiefDbService.saveAll(chiefList);
    }
}
