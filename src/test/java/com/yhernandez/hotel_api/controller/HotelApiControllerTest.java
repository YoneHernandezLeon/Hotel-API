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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

    @Test
    void shouldListHotels() throws Exception {

        when(hotelApiService.listHotels(any()))
                .thenReturn(null);

        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateHotel() throws Exception {

        String body = """
                {
                    "street": "Av. de Las Canteras 123",
                    "city": "Las Palmas de Gran Canaria",
                    "country": "España",
                    "zipCode": "35010"
                }
                """;

        String responseBody = """
                {
                    "id": "1",
                    "new_street": "Av. de Las Canteras 123",
                    "new_city": "Las Palmas de Gran Canaria",
                    "new_country": "España",
                    "new_zipCode": "35010"
                }
                """;

        when(hotelApiService.updateHotelAddress(any(), any()))
                .thenReturn(Map.of(
                        "id", "1",
                        "new_street", "Av. de Las Canteras 123",
                        "new_city", "Las Palmas de Gran Canaria",
                        "new_country", "España",
                        "new_zipCode", "35010"));

        mockMvc.perform(patch("/hotels/1")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }
}
