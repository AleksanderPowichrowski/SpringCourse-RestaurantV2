package com.app.restaurant.web.controller.map;

import com.app.resturant.model.BaseEntity;
import com.app.resturant.service.map.KitchenWareMapService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;

@Controller
@AllArgsConstructor
@Profile("map")
public class KitchenWareController {
    KitchenWareMapService kitchenWareService;


    @RequestMapping({"/kitchenwares","/kitchenwares.html"})
    public String listKitchenWare(Model model){

        model.addAttribute("kitchenwares", kitchenWareService.findAll().stream().sorted(Comparator.comparing(BaseEntity::getId)).toList());
        return "/kitchenwares";
    }

}
