package com.yhernandez.hotel_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yhernandez.hotel_api.entity.UserEntity;
import com.yhernandez.hotel_api.services.UserService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void shouldCreateUser() throws Exception {
        String body = """
                {
                    "username": "admin",
                    "password": "123",
                    "role": "ADMIN"
                }
                """;

        UserEntity createdUser = new UserEntity(1L,
                "admin",
                "123",
                "ADMIN");

        String responseBody = """
                {
                    "username": "admin",
                    "id": "1"
                }
                """;

        when(userService.register(any()))
                .thenReturn(createdUser);

        mockMvc.perform(post("/register")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(responseBody));
    }
}
