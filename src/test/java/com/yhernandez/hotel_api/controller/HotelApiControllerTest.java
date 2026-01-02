package com.yhernandez.hotel_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yhernandez.hotel_api.entity.HotelEntity;
import com.yhernandez.hotel_api.services.HotelApiService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

		HotelEntity createdHotel = new HotelEntity(null,
				"Hotel Gran Canaria",
				5,
				"Av. de Las Canteras 123",
				"Las Palmas de Gran Canaria",
				"España",
				"35010");

		String responseBody = """
				{
				    "hotel_name": "Hotel Gran Canaria",
				    "id": "1"
				}
				""";

		when(hotelApiService.createHotel(any()))
				.thenReturn(createdHotel);

		mockMvc.perform(post("/hotels")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(responseBody));
	}

	@Test
	void shouldListHotels() throws Exception {

		when(hotelApiService.listHotels(any()))
				.thenReturn(List.of());

		mockMvc.perform(get("/hotels"))
				.andExpect(status().isOk())
				.andExpect(content().json("[]"));
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

		HotelEntity updatedHotel = new HotelEntity(null,
				"Hotel Gran Canaria",
				5,
				"Av. de Las Canteras 123",
				"Las Palmas de Gran Canaria",
				"España",
				"35010");

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
				.thenReturn(updatedHotel);

		mockMvc.perform(patch("/hotels/1")
				.content(body)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(responseBody));
	}

	@Test
	void shouldDeleteHotel() throws Exception {

		doNothing().when(hotelApiService).deleteHotel(1L);

		mockMvc.perform(delete("/hotels/1"))
				.andExpect(status().isNoContent());
	}
}
