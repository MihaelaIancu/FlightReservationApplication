package com.example.flight_reservation.service;

import com.example.flight_reservation.dto.ReservationRequest;
import com.example.flight_reservation.model.Flight;
import com.example.flight_reservation.model.Passenger;
import com.example.flight_reservation.model.Reservation;
import com.example.flight_reservation.repository.FlightRepository;
import com.example.flight_reservation.repository.PassengerRepository;
import com.example.flight_reservation.repository.ReservationRepository;
import com.example.flight_reservation.reservation_email.Email;
import com.example.flight_reservation.reservation_email.ReservationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

//    @Autowired
//    ReservationGenerator pdfGenerator;
    @Autowired
    Email emailUtil;


    public ReservationService(FlightRepository flightRepository, PassengerRepository passengerRepository, ReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.reservationRepository = reservationRepository;
    }

    public Reservation bookFlight(ReservationRequest reservationRequest){
        try {
            Flight flight = flightRepository.findById(reservationRequest.getFlightId()).get();

            Date date = new Date();
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

            Passenger passenger = new Passenger();
            passenger.setFirstName(reservationRequest.getPFirstName());
            passenger.setLastName(reservationRequest.getPLastName());
            passenger.setEmail(reservationRequest.getPEmail());
            passenger.setPhone(reservationRequest.getPPhone());
            passenger.setReservationTime(sdf.format(date.getTime()));
            Passenger savedPassenger = passengerRepository.save(passenger);

            Reservation reservation = new Reservation();
            reservation.setCheckedIn(false);
            reservation.setFlight(flight);
            reservation.setPassenger(savedPassenger);
            Reservation savedReservation = reservationRepository.save(reservation);
//            String filePath = "/home/reservation" + savedReservation.getCheckedIn() + ".pdf";

//            pdfGenerator.generateItinerary(savedReservation,filePath);
            return savedReservation;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public void sendItinerary(){

    }

}
