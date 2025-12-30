package com.yhernandez.hotel_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhernandez.hotel_api.entity.HotelEntity;
import java.util.List;

public interface HotelApiRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByCityIgnoreCase(String city);
}
