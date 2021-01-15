package com.example.flight_reservation.controller;

import com.example.flight_reservation.dto.ReservationRequest;
import com.example.flight_reservation.model.Flight;
import com.example.flight_reservation.repository.FlightRepository;
import com.example.flight_reservation.repository.ReservationRepository;
import com.example.flight_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

//    public ReservationController() {
//    }
//
    public ReservationController(FlightRepository flightRepository, ReservationService reservationService) {
        this.flightRepository = flightRepository;
        this.reservationService = reservationService;
    }

    @RequestMapping("/{id}")
    public String showCompleteReservation(@PathVariable("id") Long id, Model model) {
        Flight flight = flightRepository.findById(id).get();
        model.addAttribute("flight", flight);
        return "completeReservation";
    }

    @PostMapping("/complete-reservation")
    public String completeReservation(@ModelAttribute ReservationRequest reservationRequest, Model model) {
        reservationService.bookFlight(reservationRequest);
        model.addAttribute("msg","Reservation created successfully");
        return "reservationConfirmation";
    }
}
