package com.app.restaurant.web.mapper.thymeleaf;

import com.app.restaurant.web.mapper.Mapper;
import com.app.resturant.model.BaseEntity;
import com.app.resturant.model.Chief;
import com.app.resturant.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class ChiefMapper implements Mapper<Chief, Map<Chief,String>> {

        @Override
    public Map<Chief, String> map(Set<Chief> object) {
        return object.stream()
                .sorted(Comparator.comparing(BaseEntity::getId)).toList().stream()
                .collect(Collectors.toMap(
                        chief -> chief,
                        chief -> chief.getKnownRecipes().stream()
                                .map(Recipe::getName)
                                .collect(Collectors.joining("<br/>"))
                )).entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> entry.getKey().getId()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) ->  e2,
                        LinkedHashMap::new
                ));
    }
}
