package br.com.iuri.restaurantadvisorapi.controller;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import br.com.iuri.restaurantadvisorapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @GetMapping("/findRestaurants")
    public List<Restaurant> getRestaurantList(){return service.getRestaurantList();}

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable String id){return service.getRestaurant(id);}

    @PostMapping("/addRestaurant")
    public String postRestaurant(@RequestBody Restaurant restaurant) throws Exception {return service.postRestaurant(restaurant);}

    @PutMapping("/update={id}")
    public String putRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant){return service.putRestaurant(id, restaurant);}

    @DeleteMapping("/delete={id}")
    public String deleteRestaurant(@PathVariable String id){return service.deleteRestaurant(id);}

}