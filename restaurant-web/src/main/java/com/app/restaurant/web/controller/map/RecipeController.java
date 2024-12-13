package com.app.restaurant.web.controller.map;


import com.app.restaurant.web.mapper.thymeleaf.RecipeMapper;
import com.app.resturant.service.map.RecipeMapService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Profile("map")
public class RecipeController {

    private final RecipeMapService recipeService;
    private RecipeMapper mapper;


    @RequestMapping({"/recipes", "/recipes.html"})
    public String listRecipes(Model model) {

        model.addAttribute("recipesWithDetails",mapper.map(recipeService.findAll()));
        return "/recipes";
    }
}
