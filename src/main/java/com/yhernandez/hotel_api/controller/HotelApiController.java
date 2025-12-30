package com.yhernandez.hotel_api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhernandez.hotel_api.dto.AddressDTO;
import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.services.HotelApiService;

import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<List<HotelEntity>> listHotels(@RequestParam(required = false) String city) {
        List<HotelEntity> hotels = hotelApiService.listHotels(city);
        return ResponseEntity.ok(hotels);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateHotelAddress(@PathVariable Long id,
            @Valid @RequestBody AddressDTO dto) {

        try {
            Map<String, String> updatedHotel = hotelApiService.updateHotelAddress(id, dto);
            return ResponseEntity.ok(updatedHotel);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        
        try {
            hotelApiService.deleteHotel(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }
}