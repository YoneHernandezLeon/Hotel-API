package com.yhernandez.hotel_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.yhernandez.hotel_api.dto.UserDTO;
import com.yhernandez.hotel_api.entity.UserEntity;
import com.yhernandez.hotel_api.services.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody UserDTO dto){
        UserEntity user = userService.register(dto);

        Map<String, String> resposeBody = Map.of(
                "id", user.getId().toString(),
                "username", user.getUsername());

        return ResponseEntity.status(HttpStatus.CREATED).body(resposeBody);
    }
}
