package com.ap.restaurant.web.controller;


import com.app.resturant.model.BaseEntity;
import com.app.resturant.service.map.ChiefService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.resturant.model.Recipe;


import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ChiefController {
    private ChiefService chiefService;


    @RequestMapping({"/chiefs","/chiefs.html"})
    private String listTypes(Model model){
        model.addAttribute(
                "chiefsWithDetails",
                chiefService.findAll().stream()
                        .sorted(Comparator.comparing(BaseEntity::getId)).toList().stream()
                        .collect(Collectors.toMap(
                                chief -> chief,
                                chief -> chief.getKnownRecipes().stream()
                                        .map(Recipe::getName)
                                        .collect(Collectors.joining("<br/>"))
                        ))
        );

        return "/chiefs";
    }
}
