package com.example.flight_reservation.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class Abstract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

}
