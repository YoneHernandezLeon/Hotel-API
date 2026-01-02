package com.yhernandez.hotel_api.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yhernandez.hotel_api.dto.UserDTO;
import com.yhernandez.hotel_api.entity.UserEntity;
import com.yhernandez.hotel_api.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    public UserEntity register(UserDTO dto) {
        UserEntity user = new UserEntity(null,
            dto.getUsername(),
            passwordEncoder.encode(dto.getPassword()),
            dto.getRole());

        return userRepository.save(user);
    }
}
