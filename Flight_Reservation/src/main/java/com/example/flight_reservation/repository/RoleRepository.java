package com.example.flight_reservation.repository;

import com.example.flight_reservation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
