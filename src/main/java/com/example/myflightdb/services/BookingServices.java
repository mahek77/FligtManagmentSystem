package com.example.myflightdb.services;

import com.example.myflightdb.Entities.Booking;
import com.example.myflightdb.Entities.Flight;
import com.example.myflightdb.Repositories.BookingRepository;
import com.example.myflightdb.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Booking> getAllBooking(){return bookingRepository.findAll();}

   public Booking getbookingById(Integer id){return bookingRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("booking not found"));
    }

    public Booking createBooking(Booking booking){
        Flight flight = flightRepository.findById(booking.getFlight_id().getFlight_id())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        if (flight.getAvailable_seats()<booking.getNo_of_seats()){
            throw new RuntimeException("Not enough seats available");
        }

        flight.setAvailable_seats(flight.getAvailable_seats()- booking.getNo_of_seats());

        flightRepository.save(flight);

        return bookingRepository.save(booking);
    }

}
