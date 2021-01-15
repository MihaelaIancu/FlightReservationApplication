package com.example.flight_reservation.controller;

import com.example.flight_reservation.dto.ReservationUpdateRequest;
import com.example.flight_reservation.model.Reservation;
import com.example.flight_reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    public ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable Long id){
        return reservationRepository.findById(id).get();
    }

    @PostMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation currReservation = reservationRepository.findById(request.getId()).get();
        currReservation.setCheckedIn(request.getCheckedIn());
        currReservation.setNumberOfBags(request.getNumberOfBags());
        return reservationRepository.save(currReservation);
    }
}
