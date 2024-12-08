package com.app.restaurant.web.controller.map;

import com.app.restaurant.web.controller.db.IngredientTypeDbController;
import com.app.restaurant.web.unittests.BasicRestaurantTest;
import com.app.resturant.service.db.IngredientTypeDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ControllerTest extends BasicRestaurantTest {

    @Mock
    IngredientTypeDbService ingredientTypeDbService;
    @InjectMocks
    IngredientTypeDbController ingredientTypeController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientTypeController).build();
    }

    @Test
    void listTypes() throws Exception {
        when(ingredientTypeDbService.findAll()).thenReturn(Set.of(beef,chicken,salad,corn));

        mockMvc.perform(get("/types.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("/types"))
                .andExpect(model().attribute("ingredientTypes", hasSize(4)));
    }
}