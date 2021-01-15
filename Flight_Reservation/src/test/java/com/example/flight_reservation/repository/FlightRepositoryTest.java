package com.example.flight_reservation.repository;

import com.example.flight_reservation.model.Flight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class FlightRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void if_repository_is_empty() {
        List<Flight> flights = flightRepository.findAll();
        Assertions.assertThat(flights).isEmpty();
    }

//    @Test
//    void injectedComponentsAreNotNull(){
//        Assertions.assertThat(entityManager).isNotNull();
//        Assertions.assertThat(flightRepository).isNotNull();
//    }
}