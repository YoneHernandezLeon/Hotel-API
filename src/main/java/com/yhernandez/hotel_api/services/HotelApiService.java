package com.yhernandez.hotel_api.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yhernandez.hotel_api.dto.AddressDTO;
import com.yhernandez.hotel_api.dto.CreateHotelDTO;
import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.repository.HotelApiRepository;

import jakarta.persistence.EntityNotFoundException;
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

    public List<HotelEntity> listHotels(String city) {
        if (city == null || city.isBlank()) {
            return hotelApiRepository.findAll();
        }
        return hotelApiRepository.findByCityIgnoreCase(city);
    }

    public Map<String, String> updateHotelAddress(Long hotelId, AddressDTO dto) {
        HotelEntity hotel = hotelApiRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));

        hotel.setStreet(dto.getStreet());
        hotel.setCity(dto.getCity());
        hotel.setCountry(dto.getCountry());
        hotel.setZipCode(dto.getZipCode());

        HotelEntity savedHotel = hotelApiRepository.save(hotel);
        return Map.of(
            "id", savedHotel.getId().toString(),
            "new_street", savedHotel.getStreet(),
            "new_city", savedHotel.getCity(),
            "new_country", savedHotel.getCountry(),
            "new_zipCode", savedHotel.getZipCode()
        );
    }

    public void deleteHotel(Long id){
        return;
    }
}
