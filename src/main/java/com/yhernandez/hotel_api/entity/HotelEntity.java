package com.yhernandez.hotel_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String name;

    @Column(name = "Núm. estrellas")
    private int stars;

    @Column(name = "Calle")
    private String street;

    @Column(name = "Ciudad")
    private String city;

    @Column(name = "País")
    private String country;

    @Column(name = "Código postal")
    private String zipCode;
}
