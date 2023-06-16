package br.com.iuri.restaurantadvisorapi.service;

import br.com.iuri.restaurantadvisorapi.dto.RestaurantDto;
import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import br.com.iuri.restaurantadvisorapi.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<RestaurantDto> getRestaurantList(){
        List<Restaurant> restaurantList = repository.findAll();
        if (restaurantList.isEmpty()){
            throw new NullPointerException("Restaurant's list is empty");
        }
        return restaurantList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    public RestaurantDto getRestaurant(String id){
        Optional<Restaurant> restaurant = repository.findById(id);
        if (restaurant.isPresent()){
            return modelMapper.map(restaurant.get(), RestaurantDto.class);
        }
        throw new NullPointerException("id empty");
    }

    public String postRestaurant(RestaurantDto newRestaurant) throws Exception {
        Optional<Restaurant> restaurant = repository.findByName(newRestaurant.getName());
        if (restaurant.isPresent()){
            throw new Exception("Already exists");
        }
        Restaurant map = modelMapper.map(newRestaurant, Restaurant.class);
        repository.save(map);
        return "Save new";
    }

    public String putRestaurant(String id, RestaurantDto restaurantDto) {
        Restaurant existingRestaurant = repository.findById(id).orElse(null);
        if (existingRestaurant == null) {
            throw new RuntimeException("No restaurant found");
        }

        // Converting RestaurantDto to Restaurant
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);

        BeanUtils.copyProperties(restaurant, existingRestaurant, "id");
        repository.save(existingRestaurant);

        return "Update ok.";
    }

    public String deleteRestaurant(String name){
        Optional<Restaurant> restaurant = repository.findByName(name);
        if (restaurant.isPresent()){
            repository.deleteByName(name);
            return "Delete restaurant success";
        }
        throw new NullPointerException("Restaurant doesn't exists");
    }

    private RestaurantDto convertEntityToDto(Restaurant restaurant){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto = modelMapper.map(restaurant, RestaurantDto.class);
        return restaurantDto;
    }
}