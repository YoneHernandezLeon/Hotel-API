package com.yhernandez.hotel_api.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotBlank
    private String zipCode;

    
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }
}
