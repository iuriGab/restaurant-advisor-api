package br.com.iuri.restaurantadvisorapi.controller;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import br.com.iuri.restaurantadvisorapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @GetMapping("restaurants")
    public List<Restaurant> restaurantList(){ return repository.findAll(); }


}
