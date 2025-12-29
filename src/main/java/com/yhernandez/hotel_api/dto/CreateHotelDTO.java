package com.yhernandez.hotel_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateHotelDTO {

    @NotBlank
    private String name;

    @Max(5)
    @Min(1)
    private int stars;

    @Valid
    @NotNull
    private AddressDTO address;

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public AddressDTO getAddress() {
        return address;
    }

}
