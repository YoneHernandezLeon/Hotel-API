package com.yhernandez.hotel_api.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.repository.HotelApiRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelApiService {

    private final HotelApiRepository hotelApiRepository;

    public ResponseEntity<Object> createHotel(CreateHotelDTO dto) {
        HotelEntity hotel = new HotelEntity(null, dto.getName(),
                dto.getStars(),
                dto.getAddress().getStreet(),
                dto.getAddress().getCity(),
                dto.getAddress().getCountry(),
                dto.getAddress().getZipCode());

        hotelApiRepository.save(hotel);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "id", hotel.getId(),
                        "hotel_name", hotel.getName()));
    }

    public List<HotelEntity> listHotels() {
        return hotelApiRepository.findAll();
    }
}
