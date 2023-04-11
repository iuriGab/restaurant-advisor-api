package br.com.iuri.restaurantadvisorapi.controller;

import br.com.iuri.restaurantadvisorapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

}
