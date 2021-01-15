package com.example.flight_reservation.model;

import com.example.flight_reservation.model.entity.Abstract;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
public class Flight extends Abstract {

    @NotBlank
    private String flightNumber;
    @NotBlank
    private String operatingAirlines;
    @NotBlank
    private String departureCity;
    @NotBlank
    private String arrivalCity;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date dateOfDeparture;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Timestamp estimatedDepartureTime;

    public Flight() {
    }


}
