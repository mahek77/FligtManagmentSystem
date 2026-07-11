package com.example.myflightdb.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "flight")
public class Flight {
    private Integer flight_id;
    private String flight_no;
    private String flight_name;
    private City fromCity;
    private City toCity;
    private LocalDate departureDate;
    private LocalTime departure_time;
    private LocalDate arrival_date;
    private LocalTime arrival_time;
    private BigDecimal ticket_price;
    private Integer total_seats;
    private Integer available_seats;
    private Admin admin;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    public Integer getFlight_id(){return flight_id;}
    public void setFlight_id(Integer flight_id){this.flight_id=flight_id;}

    @Column(name = "flight_no",nullable = false,unique = true)
    public String getFlight_no(){return flight_no;}
    public  void  setFlight_no(String flight_no){this.flight_no=flight_no;}

    @Column(name = "flight_name",nullable = false)
    public String getFlight_name(){return flight_name;}
    public void setFlight_name(String flight_name){this.flight_name=flight_name;}

    @ManyToOne
    @JoinColumn(name = "from_city_id")
    public City getFromCity() {return fromCity;}
    public void setFromCity(City fromCity) {this.fromCity = fromCity;}

    @ManyToOne
    @JoinColumn(name = "to_city_id")
    public City getToCity() {return toCity;}
    public void setToCity(City toCity) {this.toCity = toCity;}

    @Column(name = "departure_date")
    public LocalDate getDepartureDate() {return departureDate;}
    public void setDepartureDate(LocalDate departureDate) {this.departureDate = departureDate;}

    @Column(name = "departure_time")
    public LocalTime getDeparture_time(){return departure_time;}
    public void setDeparture_time(LocalTime departure_time){this.departure_time=departure_time;}


    @Column(name = "arrival_date")
    public LocalDate getArrival_date(){return arrival_date;}
    public void setArrival_date(LocalDate arrival_date){this.arrival_date=arrival_date;}

    @Column(name = "arrival_time")
    public LocalTime getArrival_time(){return arrival_time;}
    public void setArrival_time(LocalTime arrival_time){this.arrival_time=arrival_time;}

    @Column(name = "ticket_price",nullable = false)
    public BigDecimal getTicket_price(){return ticket_price;}
    public void setTicket_price(BigDecimal ticket_price){this.ticket_price=ticket_price;}

   @Column(name ="total_seats",nullable = false)
   public Integer getTotal_seats(){return total_seats;}
    public void setTotal_seats(Integer total_seats){this.total_seats=total_seats;}

    @Column(name = "available_seats")
    public Integer getAvailable_seats(){return available_seats;}
    public void setAvailable_seats(Integer availableSeats){this.available_seats=availableSeats;}

    @ManyToOne
    @JoinColumn(name = "admin_id")
    public Admin getAdmin() {return admin;}
    public void setAdmin(Admin admin) {this.admin = admin;}


}
