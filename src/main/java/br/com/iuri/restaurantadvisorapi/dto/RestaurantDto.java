package br.com.iuri.restaurantadvisorapi.dto;

import br.com.iuri.restaurantadvisorapi.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private String name;
    private String type;
    private String address;
    private String details;
    private String photos;
    private String hours;

    private String rating;
    private String cost;

    public RestaurantDto(Restaurant restaurant){
        this.name = restaurant.getName();
        this.type = restaurant.getType();
        this.address = restaurant.getAddress();
        this.details = restaurant.getDetails();
        this.photos = restaurant.getPhotos();
        this.hours = restaurant.getHours();
        this.rating = restaurant.getRating();
        this.cost = restaurant.getCost();
    }

    public static RestaurantDto fromRestaurant(Restaurant restaurant){
        return new RestaurantDto(
                restaurant.getName(),
                restaurant.getType(),
                restaurant.getAddress(),
                restaurant.getDetails(),
                restaurant.getPhotos(),
                restaurant.getHours(),
                restaurant.getRating(),
                restaurant.getCost());
    }

}
