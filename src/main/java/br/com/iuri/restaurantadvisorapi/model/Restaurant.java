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
    private Type type;

    @OneToOne
    private Dress dress;
    private String telephone;
    private String details;
    private String webSite;
    private String photos;
    private String hours;
    private Float rating;
    private Integer rank;
    private Feedback feedback;
    private String cost;
    public Restaurant(String name, Type type, Dress dress, String telephone, String details, String webSite, String photos, String hours, Float rating, Integer rank, Feedback feedback, String cost) {
        this.name = name;
        this.type = type;
        this.dress = dress;
        this.telephone = telephone;
        this.details = details;
        this.webSite = webSite;
        this.photos = photos;
        this.hours = hours;
        this.rating = rating;
        this.rank = rank;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Dress getDress() {
        return dress;
    }

    public void setDress(Dress dress) {
        this.dress = dress;
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
