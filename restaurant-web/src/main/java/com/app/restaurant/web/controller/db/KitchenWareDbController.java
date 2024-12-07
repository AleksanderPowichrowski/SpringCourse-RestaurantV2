package com.app.restaurant.web.controller.db;

import com.app.resturant.model.BaseEntity;
import com.app.resturant.service.db.KitchenWareDbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;

@Controller
@AllArgsConstructor
@Profile("db")
public class KitchenWareDbController {

    private KitchenWareDbService kitchenWareDbService;

    @RequestMapping({"/kitchenwares","/kitchenwares.html"})
    private String listKitchenWares(Model model){

        model.addAttribute("kitchenwares", kitchenWareDbService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)));
        return "/kitchenwares";
    }

}
