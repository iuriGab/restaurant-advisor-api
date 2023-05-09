package br.com.iuri.restaurantadvisorapi.dto;

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
    private String telephone;
    private String details;
    private String webSite;
    private String photos;
    private String hours;
    private String rating;
    private String feedback;
    private String cost;

}
