package com.yhernandez.hotel_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yhernandez.hotel_api.entity.HotelEntity;

public interface HotelApiRepository extends JpaRepository<HotelEntity, Long> {
    Page<HotelEntity> findByCityIgnoreCase(String city, Pageable pageable);
}
