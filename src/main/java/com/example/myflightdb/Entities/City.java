package com.example.myflightdb.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
private Integer city_id;
private String city_name;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "city_id")
public Integer getCity_id(){return city_id;}
public void setCity_id(Integer city_id){this.city_id=city_id;}

@Column(name = "city_name",nullable = false)
public String getCity_name(){return city_name;}
public void setCity_name(String city_name){this.city_name=city_name;}
}
