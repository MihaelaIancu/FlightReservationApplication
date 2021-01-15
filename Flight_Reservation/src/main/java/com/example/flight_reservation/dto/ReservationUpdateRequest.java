package com.example.flight_reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationUpdateRequest {

    private Long id;
    private Boolean checkedIn;
    private Integer numberOfBags;
}
