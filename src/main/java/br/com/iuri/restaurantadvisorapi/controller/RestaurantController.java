package br.com.iuri.restaurantadvisorapi.controller;

import br.com.iuri.restaurantadvisorapi.dto.RestaurantDto;
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
    public List<RestaurantDto> getRestaurantList(){return service.getRestaurantList();}

    @GetMapping("/{id}")
    public RestaurantDto getRestaurant(@PathVariable String id){return service.getRestaurant(id);}

    @PostMapping("/addRestaurant")
    public String postRestaurant(@RequestBody Restaurant restaurant) throws Exception {return service.postRestaurant(restaurant);}

    @PutMapping("/update={id}")
    public String putRestaurant(@PathVariable String id, @RequestBody RestaurantDto restaurant){return service.putRestaurant(id, restaurant);}

    @DeleteMapping("/delete={name}")
    public String deleteRestaurant(@PathVariable String name){return service.deleteRestaurant(name);}

}