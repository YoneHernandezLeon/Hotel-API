package com.yhernandez.hotel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhernandez.hotel_api.model.HotelModel;

public interface HotelApiRepository extends JpaRepository<HotelModel, Long> {
}
