package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.Flight;
import com.example.myflightdb.services.FlightServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightServices flightServices;

    @GetMapping
    public List<Flight> getAllFlights(){return flightServices.getAllFlights();}

    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight){return flightServices.addFlight(flight);}

    @PutMapping("/update/{id}")
    public Flight updateById(@PathVariable Integer id,@RequestBody Flight flight){
        return flightServices.updateFlight(id,flight);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        flightServices.deleteFlight(id);
        return "Deleted Successfully";
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Integer id){return flightServices.flightById(id);}

    @GetMapping("/search")
    public List<Flight> searchFlight(@RequestParam Integer fromCityId, @RequestParam Integer toCityId, @RequestParam LocalDate departureDate){
        return flightServices.searchFlight(fromCityId,toCityId,departureDate);
    }
}
