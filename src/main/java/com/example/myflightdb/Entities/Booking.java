package com.example.myflightdb.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "booking")
public class Booking {
    private Integer booking_id;
    private Users user_id;
    private Flight flight_id;
    private LocalDate travel_date;
    private Integer no_of_seats;
    private LocalDateTime booking_date;
    private String booking_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    public Integer getBooking_id(){return booking_id;}
    public void  setBooking_id(Integer booking_id){this.booking_id=booking_id;}

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    public Users getUser_id(){return user_id;}
    public void setUser_id(Users user_id){this.user_id=user_id;}

    @ManyToOne
    @JoinColumn(name = "flight_id",nullable = false)
    public Flight getFlight_id(){return flight_id;}
    public void setFlight_id(Flight flight_id){this.flight_id=flight_id;}

    @Column(name = "travel_date",nullable = false)
    public LocalDate getTravel_date(){return travel_date;}
    public void setTravel_date(LocalDate travel_date){this.travel_date=travel_date;}

    @Column(name = "no_of_seats",nullable = false)
    public Integer getNo_of_seats(){return no_of_seats;}
    public void setNo_of_seats(Integer no_of_seats){this.no_of_seats=no_of_seats;}

    @Column(name = "booking_date")
    public LocalDateTime getBooking_date(){return booking_date;}
    public void setBooking_date(LocalDateTime booking_date){this.booking_date=booking_date;}

    @Column(name = "booking_status")
    public String getBooking_status(){return booking_status;}
    public void setBooking_status(String booking_status){this.booking_status=booking_status;}

@PrePersist
    public void prePersist(){
        this.booking_date=LocalDateTime.now();
        if (booking_status==null){
            booking_status="Booked";
        }
}
}
