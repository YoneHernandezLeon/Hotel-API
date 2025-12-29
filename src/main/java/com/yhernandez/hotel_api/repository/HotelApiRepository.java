package com.yhernandez.hotel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhernandez.hotel_api.entity.HotelEntity;

public interface HotelApiRepository extends JpaRepository<HotelEntity, Long> {
}
