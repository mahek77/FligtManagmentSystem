package com.example.myflightdb.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "payment")
public class Payment {
    private Integer payment_id;
    private Booking booking_id;
    private String card_holder_name;
    private String card_number;
    private String expiry_date;
    private BigDecimal amount;
    private LocalDateTime payment_date;
    private String payment_status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    public Integer getPayment_id(){return payment_id;}
    public  void setPayment_id(Integer payment_id){this.payment_id=payment_id;}

    @OneToOne
    @JoinColumn(name = "booking_id",nullable = false,unique = true)
    public Booking getBooking_id(){return booking_id;}
    public void setBooking_id(Booking booking_id){this.booking_id=booking_id;}

    @Column(name = "card_holder_name",nullable = false)
    public String getCard_holder_name(){return card_holder_name;}
    public void setCard_holder_name(String card_holder_name){this.card_holder_name=card_holder_name;}

    @Column(name = "card_number",nullable = false)
    public String getCard_number(){return card_number;}
    public  void setCard_number(String  card_number){this.card_number=card_number;}

    @Column(name = "expiry_date",nullable = false)
    public String getExpiry_date(){return expiry_date;}
    public  void  setExpiry_date(String expiry_date){this.expiry_date=expiry_date;}

    @Column(name = "amount",nullable = false)
    public BigDecimal getAmount(){return amount;}
    public void setAmount(BigDecimal amount){this.amount=amount;}

    @Column(name = "payment_date")
    public LocalDateTime getPayment_date(){return payment_date;}
    public void setPayment_date(LocalDateTime payment_date){this.payment_date=payment_date;}

    @Column(name = "payment_status")
    public String getPayment_status(){return payment_status;}
    public void setPayment_status(String payment_status){this.payment_status=payment_status;}

    @PrePersist
    public void prePersist(){
        this.payment_date=LocalDateTime.now();
        if (payment_status==null){
        payment_status="Paid";
        }
    }
}
