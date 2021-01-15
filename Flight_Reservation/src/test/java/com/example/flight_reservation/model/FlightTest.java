package com.example.flight_reservation.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Setter
@Getter
@DataJpaTest
class FlightTest {

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;

    public FlightTest() {
    }
}