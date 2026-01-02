package com.yhernandez.hotel_api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public HotelEntity createHotel(CreateHotelDTO dto) {
		HotelEntity hotel = new HotelEntity(null,
				dto.getName(),
				dto.getStars(),
				dto.getAddress().getStreet(),
				dto.getAddress().getCity(),
				dto.getAddress().getCountry(),
				dto.getAddress().getZipCode());

		return hotelApiRepository.save(hotel);
	}

	public Page<HotelEntity> listHotels(String city, int page, int size, String[] sort) {
		
		Sort.Direction direction = Sort.Direction.fromString(sort[1]);
		Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));
		
		if (city == null || city.isBlank()) {
			return hotelApiRepository.findAll(pageable);
		}
		return hotelApiRepository.findByCityIgnoreCase(city, pageable);
	}

	public HotelEntity updateHotelAddress(Long hotelId, AddressDTO dto) {
		HotelEntity hotel = hotelApiRepository.findById(hotelId)
				.orElseThrow(() -> new EntityNotFoundException("Hotel not found"));

		hotel.setStreet(dto.getStreet());
		hotel.setCity(dto.getCity());
		hotel.setCountry(dto.getCountry());
		hotel.setZipCode(dto.getZipCode());

		return hotelApiRepository.save(hotel);
	}

	public void deleteHotel(Long id) {
		if (!hotelApiRepository.existsById(id)) {
			throw new EntityNotFoundException("Hotel not found");
		}

		hotelApiRepository.deleteById(id);
	}
}
