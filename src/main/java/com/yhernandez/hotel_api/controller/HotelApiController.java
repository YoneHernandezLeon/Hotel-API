package com.yhernandez.hotel_api.controller;


import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.services.HotelApiService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelApiController {

    private final HotelApiService hotelApiService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createHotel(@Valid @RequestBody CreateHotelDTO dto) {
        
        Map<String, String> createdHotel = hotelApiService.createHotel(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @GetMapping
    public ResponseEntity<List<HotelEntity>> listHotels() {
        List<HotelEntity> hotels = hotelApiService.listHotels();
        return ResponseEntity.ok(hotels);
    }
}