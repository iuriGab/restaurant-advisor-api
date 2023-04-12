package br.com.iuri.restaurantadvisorapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Document(collection = "restaurant")
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

    public Restaurant(String name, String type, String address, String telephone, String details, String webSite, String photos, String hours, String rating, String feedback, String cost) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.telephone = telephone;
        this.details = details;
        this.webSite = webSite;
        this.photos = photos;
        this.hours = hours;
        this.rating = rating;
        this.feedback = feedback;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
