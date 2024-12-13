package com.app.restaurant.web.controller.db;


import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.IngredientType;
import com.app.resturant.service.db.IngredientTypeDbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;

@Controller
@AllArgsConstructor
@Profile("db")
@RequestMapping({"/types","/types.html"})
public class IngredientTypeDbController {

    private final IngredientTypeDbService ingredientTypeService;

    @GetMapping
    private String listTypes(Model model){
        model.addAttribute("ingredientTypes",ingredientTypeService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)).toList());
        return "/types/types";
    }
    @PostMapping("/new")
    public String processCreationForm(@Valid IngredientType ingredientType, BindingResult result) {
        if (result.hasErrors()) {
            return "/types/createOrUpdateTypeForm";
        } else {
            ingredientTypeService.save(ingredientType);
            return "redirect:/types";
        }
    }

    @GetMapping("/new")
    public String processCreationForm(Model model) {
        IngredientType ingredientType = new IngredientType();

        model.addAttribute("ingredientType",ingredientType);

        return "/types/createOrUpdateTypeForm";
    }

}
