package com.yhernandez.hotel_api.services;

import org.springframework.stereotype.Service;

import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.repository.HotelApiRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelApiService {

    private final HotelApiRepository hotelApiRepository;

    public void createHotel(CreateHotelDTO dto) {
        HotelEntity hotel = new HotelEntity(null, dto.getName(),
                dto.getStars(),
                dto.getAddress().getStreet(),
                dto.getAddress().getCity(),
                dto.getAddress().getCountry(),
                dto.getAddress().getZipCode());

        hotelApiRepository.save(hotel);
    }
}
