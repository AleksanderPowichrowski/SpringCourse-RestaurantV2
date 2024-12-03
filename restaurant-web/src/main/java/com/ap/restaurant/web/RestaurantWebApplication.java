package com.ap.restaurant.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
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
