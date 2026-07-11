package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.City;
import com.example.myflightdb.Repositories.CityRepository;
import com.example.myflightdb.services.CityServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityServices cityServices;

    @GetMapping
    public List<City> getAllCity(){return cityServices.getAllCity();}

    @PostMapping("/add")
    public City addCity(@RequestBody City city){return cityServices.addCity(city);}

    @PutMapping("/update/{id}")
    public City updateById(@PathVariable Integer id,@RequestBody City city){return cityServices.updateCity(id,city);}

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        cityServices.deleteCity(id);

        return "Deleted successfully";
    }
}
