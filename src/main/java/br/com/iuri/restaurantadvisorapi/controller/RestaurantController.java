package br.com.iuri.restaurantadvisorapi.controller;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import br.com.iuri.restaurantadvisorapi.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping
    public List<Restaurant> getRestaurantList(){ return repository.findAll(); }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable String id){
        Restaurant restaurant = repository.findById(id).orElse(null);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not founded");
        }
        return restaurant;
    }

    @PostMapping
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurant){
        Restaurant newRestaurant = repository.save(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRestaurant);
    }

    @PutMapping("/{id}")
    public Restaurant putRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant){
        Restaurant existingRestaurant = repository.findById(id).orElse(null);
        if (existingRestaurant == null) {
            throw new RuntimeException("Any restaurant founded");
        }
        BeanUtils.copyProperties(restaurant, existingRestaurant, "id");

        return repository.save(existingRestaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable String id){
        Restaurant restaurant = repository.findById(id).orElse(null);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not founded");
        }
        repository.deleteById(id);
    }

}