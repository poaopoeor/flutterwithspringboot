package com.example.flutterwithspringboot.items;

import java.util.UUID;

public class Item {

    private UUID itemId;
    private String name;
    private String price;
    private String type;
    private String country;
    private String details;
    private String photo;
    private String expiredDate;

    public Item(UUID itemId, String name, String price, String type, String country, String details, String photo,
            String expiredDate) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.country = country;
        this.details = details;
        this.photo = photo;
        this.expiredDate = expiredDate;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

}
