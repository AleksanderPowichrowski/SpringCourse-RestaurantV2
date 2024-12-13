package com.app.restaurant.web.controller.db;

import com.app.restaurant.web.mapper.thymeleaf.RecipeMapper;
import com.app.resturant.service.db.RecipeDbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@Profile("db")
public class RecipeDbController {

    private final RecipeDbService recipeDbService;
    private final RecipeMapper mapper;

    @RequestMapping({"/recipes", "/recipes.html"})
    private String listRecipes(Model model) {

        model.addAttribute(
                "recipesWithDetails",
                mapper.map(recipeDbService.findAll()));
        return "/recipes";
    }

}
