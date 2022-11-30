package com.codeclan.example.CoffeeTracker.repositories;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import com.codeclan.example.CoffeeTracker.models.CoffeeShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeShopRepository extends JpaRepository<CoffeeShop, Long> {

    // Get all the coffee shops stocking coffee for a particular region.
    List<CoffeeShop> findCoffeeShopByRegion(String region);


    // Get coffee shops that have coffee that where harvested 6 years ago.
    List<CoffeeShop> findCoffeeShopByCoffeesAgeGreaterThan(int age);

}
