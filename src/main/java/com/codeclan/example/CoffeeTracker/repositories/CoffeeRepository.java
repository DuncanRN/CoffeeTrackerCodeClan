package com.codeclan.example.CoffeeTracker.repositories;

import com.codeclan.example.CoffeeTracker.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findCoffeeByStrength(int strength);

    //Get all the coffee from a particular coffee shop that's a specific age.
    List<Coffee> findByCoffeeShopIdEqualsAndAgeGreaterThan(long coffee_shop_id, int age); //

    List<Coffee> findCoffeeByCoffeeShopRegionEquals(String region);


}
