package com.app.restaurant.web.controller.db;

import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.IngredientType;
import com.app.resturant.model.KitchenWare;
import com.app.resturant.service.db.KitchenWareDbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Comparator;

@Controller
@AllArgsConstructor
@Profile("db")
@RequestMapping({"/kitchenwares","/kitchenwares.html"})
public class KitchenWareDbController {

    private KitchenWareDbService kitchenWareDbService;

    @GetMapping
    private String listKitchenWares(Model model){

        model.addAttribute("kitchenwares", kitchenWareDbService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)).toList());
        return "kitchenware/kitchenwares";
    }
    @PostMapping("/new")
    public String processCreationForm(@Valid KitchenWare kitchenWare, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/kitchenwares";
        } else {
            kitchenWareDbService.save(kitchenWare);
            return "redirect:/kitchenwares";
        }
    }

    @GetMapping("/new")
    public String processCreationForm(Model model) {
        KitchenWare kitchenWare = new KitchenWare();

        model.addAttribute("kitchenware",kitchenWare);

        return "/kitchenware/createOrUpdateKitchenWareForm";
    }

}
