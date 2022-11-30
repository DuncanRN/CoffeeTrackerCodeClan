package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeeRepository;

    // get all coffees
    // or if we have been given a strength -
    // Get all the coffees harvested with a particular strength

//    @GetMapping(value = "/coffees")
////    @JsonIgnoreProperties(value = "coffee_shop")
//    public ResponseEntity<List<Coffee>> findCoffeesFilterByStrength(
//            @RequestParam(name="strength", required = false) String strength){
//        if(strength != null){
//            return new ResponseEntity<>(coffeeRepository.findCoffeeByStrength(strength), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
//    }

    // ----
    //Get all the coffees harvested with a particular strength
    @GetMapping(value = "/coffees/{id}")
    public ResponseEntity getCoffeeofStrength(@PathVariable int id){
        return new ResponseEntity<>(coffeeRepository.findCoffeeByStrength(id), HttpStatus.OK);
    }

    @GetMapping(value = "/coffees/shop/{shop}/{age}")
    public ResponseEntity getCoffeeofShopIdAndGreaterThanAge(@PathVariable long shop, @PathVariable int age){
        return new ResponseEntity<>(coffeeRepository.findByCoffeeShopIdEqualsAndAgeGreaterThan(shop, age), HttpStatus.OK);
    }



    // Get all the coffee from a particular region.
    @GetMapping(value = "/coffees/region/{region}")
    public ResponseEntity getCoffeeByRegion(@PathVariable String region){
        System.out.println(region);
        return new ResponseEntity<>(coffeeRepository.findCoffeeByCoffeeShopRegionEquals(region), HttpStatus.OK);
    }


}
