package com.app.restaurant.web.controller.map;


import com.app.resturant.model.BaseEntity;
import com.app.resturant.service.db.IngredientTypeDbService;
import com.app.resturant.service.map.IngredientTypeMapService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;

@Controller
@AllArgsConstructor
@Profile("map")
public class IngredientTypeController {

    private final IngredientTypeMapService ingredientTypeService;

    @RequestMapping({"/types","/types.html"})
    private String listTypes(Model model){
        model.addAttribute("ingredientTypes",ingredientTypeService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)));
        return "/types";
    }
}
