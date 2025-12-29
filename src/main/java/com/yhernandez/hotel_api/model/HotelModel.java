package com.yhernandez.hotel_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class HotelModel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int stars;
    private String street;
    private String city;
    private String country;
    private String zipCode;

    public HotelModel(String name, int stars, String street, String city, String country, String zipCode) {
        this.name = name;
        this.stars = stars;
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }
}
