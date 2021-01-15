package com.example.flight_reservation.model;

import com.example.flight_reservation.model.entity.Abstract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
public class Reservation extends Abstract {

    private Boolean checkedIn;
    private Integer numberOfBags;

    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;

    public Reservation() {
    }

}
