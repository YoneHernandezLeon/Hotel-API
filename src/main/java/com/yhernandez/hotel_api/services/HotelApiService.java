package com.yhernandez.hotel_api.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.repository.HotelApiRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelApiService {

    private final HotelApiRepository hotelApiRepository;

    public Map<String, String> createHotel(CreateHotelDTO dto) {
        HotelEntity hotel = new HotelEntity(null, dto.getName(),
                dto.getStars(),
                dto.getAddress().getStreet(),
                dto.getAddress().getCity(),
                dto.getAddress().getCountry(),
                dto.getAddress().getZipCode());

        HotelEntity savedHotel = hotelApiRepository.save(hotel);

        return Map.of(
                "id", savedHotel.getId().toString(),
                "hotel_name", savedHotel.getName());
    }
}
