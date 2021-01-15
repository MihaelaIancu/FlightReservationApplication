package com.example.flight_reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationRequest {

    private Long flightId;
    private String pFirstName;
    private String pLastName;
    private String pEmail;
    private String pPhone;
    private String nameOnCard;
    private String cardNumber;
    private String expiryDate;
    private int cvvNumber;
}
