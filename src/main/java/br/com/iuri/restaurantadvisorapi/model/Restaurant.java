package br.com.iuri.restaurantadvisorapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Document(collection = "restaurant-api")
public class Restaurant {

    @Id
    private Integer id;
    private String name;
    @ManyToOne
    private Type type;
    @OneToOne
    private Dress dress;
    private Integer telephone;
    private String details;
    private String webSite;
    private String photos;
    private String hours;
    private Float rating;
    private Integer rank;
    private Feedback feedback;
    private String cost;


}
