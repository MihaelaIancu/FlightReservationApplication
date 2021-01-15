package com.example.flight_reservation.repository;

import com.example.flight_reservation.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
