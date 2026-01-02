package com.yhernandez.hotel_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhernandez.hotel_api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByUsername(String username);
}
