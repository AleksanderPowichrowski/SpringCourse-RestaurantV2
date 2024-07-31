package com.app.resturant.controller;

import com.app.resturant.data.kitchen.Dish;
import com.app.resturant.data.kitchen.DishResult;
import com.app.resturant.service.RestaurantService;

public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public DishResult startOrder(Dish dish) {
        return null;
    }
}
