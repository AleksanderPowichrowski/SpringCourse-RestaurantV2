package com.app.restaurant.web.unittests;

import com.app.restaurant.web.controller.StartupController;
import com.app.restaurant.web.controller.map.*;
import com.app.restaurant.web.mapper.thymeleaf.ChiefMapper;
import com.app.restaurant.web.mapper.thymeleaf.RecipeMapper;
import com.app.restaurant.web.mapper.thymeleaf.StockMapper;
import com.app.resturant.model.Chief;
import com.app.resturant.model.IngredientType;
import com.app.resturant.model.KitchenWare;
import com.app.resturant.service.map.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class UnitControllerTests extends BasicRestaurantTest {

    StartupController startupController;
    IngredientTypeController ingredientTypeController;
    StockController stockController;
    KitchenWareController kitchenWareController;
    ChiefController chiefController;
    RecipeController recipeController;


    @Mock
    Model model;
    @Mock
    IngredientTypeMapService ingredientTypeService;
    @Mock
    StockMapService stockMapService;
    @Mock
    KitchenWareMapService kitchenWareMapService;
    @Mock
    ChiefMapService chiefMapService;

    @Mock
    RecipeMapService recipeMapService;


    StockMapper stockMapper;
    ChiefMapper chiefMapper;
    RecipeMapper recipeMapper;


    @BeforeEach
    public void setupControllers() {
        setup();
        MockitoAnnotations.openMocks(this);
        startupController = new StartupController();
        stockMapper = new StockMapper();
        stockController = new StockController(stockMapService, stockMapper);
        ingredientTypeController = new IngredientTypeController(ingredientTypeService);
        kitchenWareController = new KitchenWareController(kitchenWareMapService);
        chiefMapper = new ChiefMapper();
        chiefController = new ChiefController(chiefMapService,chiefMapper);
        recipeMapper = new RecipeMapper();
        recipeController = new RecipeController(recipeMapService,recipeMapper);

    }

    @Test
    public void testStartup() {
        String startUpName = startupController.startUp();
        Assertions.assertEquals("/index", startUpName);
    }

    @Test
    public void testTypes() {


        when(ingredientTypeService.findAll()).thenReturn(Set.of(corn, onion, salad, chicken));

        String name = ingredientTypeController.listTypes(model);

        Assertions.assertEquals("/types", name);

        ArgumentCaptor<List<IngredientType>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        verify(ingredientTypeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("ingredientTypes"), argumentCaptor.capture());

    }

    @Test
    public void testStocks() {

        when(stockMapService.findAll()).thenReturn(Set.of(createStock()));
        String name = stockController.listStocks(model);
        Assertions.assertEquals("/stocks", name);
        ArgumentCaptor<List<Map<String, Object>>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        verify(stockMapService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("stockList"), argumentCaptor.capture());

    }

    @Test
    public void testKitchenWares() {

        when(kitchenWareMapService.findAll()).thenReturn(Set.of(fryingPan, bowl, choppingBoard));
        String name = kitchenWareController.listKitchenWare(model);
        Assertions.assertEquals("/kitchenwares", name);
        ArgumentCaptor<List<KitchenWare>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        verify(kitchenWareMapService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("kitchenwares"), argumentCaptor.capture());
    }

    @Test
    public void testChiefs() {

        when(chiefMapService.findAll()).thenReturn(Set.of(createChiefJan(), createChiefKrzysztof()));
        String name = chiefController.listChiefs(model);
        Assertions.assertEquals("/chiefs", name);

        ArgumentCaptor<Map<Chief, String>> argumentCaptor = ArgumentCaptor.forClass(Map.class);

        verify(chiefMapService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("chiefsWithDetails"), argumentCaptor.capture());
    }

    @Test
    public void testRecipes() {

        when(recipeMapService.findAll()).thenReturn(Set.of(createVegetableSaladRecipe(),createFriedChickenVegetablesRecipe(),createFriefBeefVegetablesRecipe()));
        String name = recipeController.listRecipes(model);
        Assertions.assertEquals("/recipes", name);

        ArgumentCaptor<Map<Chief, String>> argumentCaptor = ArgumentCaptor.forClass(Map.class);

        verify(recipeMapService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("recipesWithDetails"), argumentCaptor.capture());
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(startupController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/index"));

    }
}
