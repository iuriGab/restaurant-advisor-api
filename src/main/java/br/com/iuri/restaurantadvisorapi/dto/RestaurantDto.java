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
    private String photos;
    private String rating;
    private String cost;

    public RestaurantDto(Restaurant restaurant){
        this.photos = restaurant.getPhotos();
        this.type = restaurant.getType();
        this.name = restaurant.getName();
        this.rating = restaurant.getRating();
        this.cost = restaurant.getCost();
    }

    public static RestaurantDto fromRestaurant(Restaurant restaurant){
        return new RestaurantDto(restaurant.getPhotos(), restaurant.getType(), restaurant.getName(), restaurant.getRating(), restaurant.getCost());
    }

}
