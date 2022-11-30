package com.codeclan.example.CoffeeTracker.controllers;

import com.codeclan.example.CoffeeTracker.repositories.CoffeeRepository;
import com.codeclan.example.CoffeeTracker.repositories.CoffeeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeShopController {
    @Autowired
    CoffeeShopRepository coffeeShopRepository;

    // Get all the coffee shops stocking coffee for a particular region.
    @GetMapping(value = "/coffeeshops/region/{region}")
    public ResponseEntity getCoffeeShopStockingCoffeeFromRegion(@PathVariable String region){
        return new ResponseEntity<>(coffeeShopRepository.findCoffeeShopByRegion(region), HttpStatus.OK);
    }

    // Get coffee shops that have coffee that where harvested 6 years ago.
    @GetMapping(value = "/coffeeshops/age/{age}")
    public ResponseEntity getCoffeeShopsWithCoffeeOlderThan(@PathVariable int age){

        return new ResponseEntity<>(coffeeShopRepository.findCoffeeShopByCoffeesAgeGreaterThan(age), HttpStatus.OK);
    }
}
