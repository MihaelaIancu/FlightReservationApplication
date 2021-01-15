package com.example.flight_reservation.exception;

public class NotFoundFlightException extends RuntimeException{
    public NotFoundFlightException(String message) {
        super(message);
    }
}
