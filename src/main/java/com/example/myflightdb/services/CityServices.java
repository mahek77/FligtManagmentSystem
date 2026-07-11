package com.example.myflightdb.services;

import com.example.myflightdb.Entities.City;
import com.example.myflightdb.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServices {
   @Autowired
    CityRepository cityRepository;

   public List<City> getAllCity(){return cityRepository.findAll();}

   public City addCity(City city){return cityRepository.save(city);}

   public City updateCity(Integer id,City city){
       City existing = cityRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("city not found"));

       existing.setCity_name(city.getCity_name());

       return cityRepository.save(existing);
   }

   public void deleteCity(Integer id){cityRepository.deleteById(id);}
}
