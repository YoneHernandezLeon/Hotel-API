package com.yhernandez.hotel_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yhernandez.hotel_api.services.HotelApiService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

@WebMvcTest(HotelApiController.class)
public class HotelApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HotelApiService hotelApiService;

    @Test
    void shouldCreateHotel() throws Exception {
        String body = """
                {
                "name": "Hotel Gran Canaria",
                "stars": 5,
                "address": {
                    "street": "Av. de Las Canteras 123",
                    "city": "Las Palmas de Gran Canaria",
                    "country": "España",
                    "zipCode": "35010"
                    }
                }
                """;

        String responseBody = """
                {
                    "hotel_name": "Hotel Gran Canaria",
                    "id": "1"
                }
                """;

        when(hotelApiService.createHotel(any()))
                .thenReturn(Map.of(
                                "id", "1",
                                "hotel_name", "Hotel Gran Canaria"));

        mockMvc.perform(post("/hotels")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(responseBody));
    }
}
