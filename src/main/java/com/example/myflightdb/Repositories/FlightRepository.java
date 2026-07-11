package com.example.myflightdb.Repositories;

import com.example.myflightdb.Entities.City;
import com.example.myflightdb.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight> findByFromCityAndToCityAndDepartureDate(
            City fromCity,
            City toCity,
            LocalDate departureDate
    );
}
