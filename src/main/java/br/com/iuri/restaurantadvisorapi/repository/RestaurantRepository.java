package br.com.iuri.restaurantadvisorapi.repository;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    Optional<Restaurant> findByName(String name);
}