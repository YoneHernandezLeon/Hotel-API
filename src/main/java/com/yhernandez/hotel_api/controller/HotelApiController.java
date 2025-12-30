package com.yhernandez.hotel_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.services.HotelApiService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelApiController {

    private final HotelApiService hotelApiService;

    @PostMapping
    public ResponseEntity<Object> createHotel(@Valid @RequestBody CreateHotelDTO dto) {
        return hotelApiService.createHotel(dto);
    }
}