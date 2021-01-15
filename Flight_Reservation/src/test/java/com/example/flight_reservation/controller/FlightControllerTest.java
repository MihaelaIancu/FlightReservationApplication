package com.example.flight_reservation.controller;

import com.example.flight_reservation.exception.NotFoundFlightException;
import com.example.flight_reservation.model.Flight;
import com.example.flight_reservation.repository.FlightRepository;
import com.example.flight_reservation.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FlightController.class)
class FlightControllerTest {

    @MockBean
    private FlightRepository flightRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Get a flight by an existing id")
    public void testGetFlightByIdHappyFlow() throws Exception {
        long id=2;
        Flight flight = new Flight();
        when(flightRepository.findById(id)).thenReturn(Optional.of(flight));

        mockMvc.perform(get("/reservation/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get a flight by an non-existing id")
    public void testGetFlightByIdBadFlow() throws Exception {
        long id=10;
        when(flightRepository.findById(id)).thenThrow(new NotFoundFlightException("There is no flight with the requested id!"));

        mockMvc.perform(get("/reservation/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}