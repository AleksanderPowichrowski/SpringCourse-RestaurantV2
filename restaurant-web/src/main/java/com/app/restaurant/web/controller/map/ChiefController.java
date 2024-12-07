package com.app.restaurant.web.controller.map;


import com.app.restaurant.web.mapper.thymeleaf.ChiefMapper;
import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.Recipe;
import com.app.resturant.service.map.ChiefMapService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@Profile("map")
public class ChiefController {

    private ChiefMapService chiefService;
    private ChiefMapper mapper;


    @RequestMapping({"/chiefs","/chiefs.html"})
    private String listTypes(Model model){
        model.addAttribute("chiefsWithDetails",
                mapper.map(chiefService.findAll())
        );

        return "/chiefs";
    }
}
