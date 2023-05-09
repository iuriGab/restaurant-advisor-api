package br.com.iuri.restaurantadvisorapi.service;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import br.com.iuri.restaurantadvisorapi.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getRestaurantList(){
        List<Restaurant> restaurantList = repository.findAll();
        if (restaurantList.isEmpty()){
            throw new NullPointerException("Restaurant's list is empty");
        }
        return restaurantList;
    }

    public Restaurant getRestaurant(String id){
        Optional<Restaurant> restaurant = repository.findById(id);
        if (restaurant.isPresent()){
            return restaurant.get();
        }
        throw new NullPointerException("id empty");
    }

    public String postRestaurant(Restaurant newRestaurant) throws Exception {
        Optional<Restaurant> restaurant = repository.findByName(newRestaurant.getName());
        if (restaurant.isPresent()){
            throw new Exception("Already exists");
        }
        repository.save(newRestaurant);
        return "Save new";
    }

    public String putRestaurant(String id, Restaurant restaurant){
        Restaurant existingRestaurant = repository.findById(id).orElse(null);
        if (existingRestaurant == null) {
            throw new RuntimeException("Any restaurant founded");
        }
        BeanUtils.copyProperties(restaurant, existingRestaurant, "id");
        repository.save(existingRestaurant);

        return "Update ok.";
    }

    public String deleteRestaurant(String id){
        Optional<Restaurant> restaurant = repository.findById(id);
        if (restaurant.isPresent()){
            repository.deleteById(id);
            return "Delete restaurant success";
        }
        throw new NullPointerException("Restaurant doesn't exists");
    }
}
