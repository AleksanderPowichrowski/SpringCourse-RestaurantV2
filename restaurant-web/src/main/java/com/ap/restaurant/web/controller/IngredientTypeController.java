package com.ap.restaurant.web.controller;


import com.app.resturant.model.BaseEntity;
import com.app.resturant.service.map.IngredientTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;

@Controller
@AllArgsConstructor
public class IngredientTypeController {

    private final IngredientTypeService ingredientTypeService;

    @RequestMapping({"/types","/types.html"})
    private String listTypes(Model model){
        model.addAttribute("ingredientTypes",ingredientTypeService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)));
        return "/types";
    }
}
