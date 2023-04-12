package br.com.iuri.restaurantadvisorapi.repository;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {}