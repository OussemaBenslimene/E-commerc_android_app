package com.example.online_shop.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemDomain implements Serializable {

    private String title;
    private String description;
    private int review;
    private double rating;
    private double oldPrice;
    private double price;
    private int NumberinCart;
    private ArrayList<String> picUrl;

    public ItemDomain() {
    }

    public ItemDomain(String title, String description, int review, double rating, double oldPrice, double price, ArrayList<String> picUrl) {
        this.title = title;
        this.description = description;
        this.review = review;
        this.rating = rating;
        this.oldPrice = oldPrice;
        this.price = price;
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberinCart() {
        return NumberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        this.NumberinCart = numberinCart;
    }

    public ArrayList<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(ArrayList<String> picUrl) {
        this.picUrl = picUrl;
    }
}
