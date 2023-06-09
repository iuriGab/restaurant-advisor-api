package br.com.iuri.restaurantadvisorapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Document(collection = "restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    private String id;
    private String name;
    @ManyToOne
    private String type;
    @OneToOne
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
