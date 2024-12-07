package com.app.restaurant.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.app.resturant")
@EnableJpaRepositories(basePackages = "com.app.resturant")
public class RestaurantWebApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(RestaurantWebApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
