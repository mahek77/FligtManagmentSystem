package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.Booking;
import com.example.myflightdb.services.BookingServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingServices bookingServices;

@GetMapping
    List<Booking> getAllBookings(){return bookingServices.getAllBooking();}

@GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Integer id){return bookingServices.getbookingById(id);}

@PostMapping("/add")
public Booking addBooking(@RequestBody Booking booking){return bookingServices.createBooking(booking);}


}
