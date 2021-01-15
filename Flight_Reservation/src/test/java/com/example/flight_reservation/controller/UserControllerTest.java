package com.example.flight_reservation.controller;

import com.example.flight_reservation.exception.NotFoundFlightException;
import com.example.flight_reservation.exception.NotFoundUserException;
import com.example.flight_reservation.model.Flight;
import com.example.flight_reservation.model.User;
import com.example.flight_reservation.repository.FlightRepository;
import com.example.flight_reservation.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Get an existing user")
    public void testGetUserByEmailHappyFlow() throws Exception {
        String email="iancumihaela46@yahoo.com";
        String password="iancumihaela";

        User user = new User();
        when(userRepository.findByEmail(email)).thenReturn((user));

        mockMvc.perform(post("login-user/?email=" + email + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get an non-existing user")
    public void testGetFlightByIdBadFlow() throws Exception {
        String email="ionescumarian@yahoo.com";
        String password="test";
        when(userRepository.findByEmail(email)).thenThrow(new NotFoundUserException("There is no user with the requested email!"));

        mockMvc.perform(post("login-user/?email=" + email + "&password=" + password)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}