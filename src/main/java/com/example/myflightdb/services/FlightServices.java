package com.example.myflightdb.services;

import com.example.myflightdb.Entities.City;
import com.example.myflightdb.Entities.Flight;
import com.example.myflightdb.Repositories.CityRepository;
import com.example.myflightdb.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServices {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CityRepository cityRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Integer id, Flight flight) {
        Flight existing = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("flight not found"));

        existing.setFlight_no(flight.getFlight_no());
        existing.setFlight_name(flight.getFlight_name());
        existing.setFromCity(flight.getFromCity());
        existing.setToCity(flight.getToCity());
        existing.setDepartureDate(flight.getDepartureDate());
        existing.setDeparture_time(flight.getDeparture_time());
        existing.setArrival_date(flight.getArrival_date());
        existing.setArrival_time(flight.getArrival_time());
        existing.setTicket_price(flight.getTicket_price());
        existing.setTotal_seats(flight.getTotal_seats());
        existing.setAvailable_seats(flight.getAvailable_seats());

        return flightRepository.save(existing);
    }

    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }

    public Flight flightById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("flight not found"));
    }

    public List<Flight> searchFlight(Integer from_city_id, Integer to_city_id, LocalDate departure_date) {
        City fromCity = cityRepository.findById(from_city_id)
                .orElseThrow(() -> new RuntimeException("city not found"));

        City toCity = cityRepository.findById(to_city_id)
                .orElseThrow(() -> new RuntimeException("city not found"));

        return flightRepository.findByFromCityAndToCityAndDepartureDate(fromCity, toCity, departure_date);
    }
}
