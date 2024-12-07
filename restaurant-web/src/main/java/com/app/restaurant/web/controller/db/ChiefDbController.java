package com.app.restaurant.web.controller.db;


import com.app.restaurant.web.mapper.thymeleaf.ChiefMapper;
import com.app.resturant.service.db.ChiefDbService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Profile("db")
public class ChiefDbController {

    private ChiefDbService chiefService;
    private ChiefMapper mapper;

    @RequestMapping({"/chiefs", "/chiefs.html"})
    private String listChiefs(Model model) {
        model.addAttribute(
                "chiefsWithDetails", mapper.map(chiefService.findAll())
        );

        return "/chiefs";
    }

}
