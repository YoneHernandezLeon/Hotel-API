package com.yhernandez.hotel_api.services;

import org.springframework.stereotype.Service;

import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.model.HotelModel;
import com.yhernandez.hotel_api.repository.HotelApiRepository;

@Service
public class HotelApiService {

    private final HotelApiRepository hotelApiRepository;

    public HotelApiService(HotelApiRepository hotelApiRepository) {
        this.hotelApiRepository = hotelApiRepository;
    }

    public void createHotel(CreateHotelDTO dto) {
        HotelModel hotel = new HotelModel(dto.getName(),
                dto.getStars(),
                dto.getAddress().getStreet(),
                dto.getAddress().getCity(),
                dto.getAddress().getCountry(),
                dto.getAddress().getZipCode());

        hotelApiRepository.save(hotel);
    }
}
