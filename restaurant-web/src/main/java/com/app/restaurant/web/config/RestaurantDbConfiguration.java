package com.app.restaurant.web.config;


import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Profile;

@SpringBootConfiguration
@Profile("db")
@AllArgsConstructor
@ComponentScan("com.app.resturant")
public class RestaurantDbConfiguration {

}
