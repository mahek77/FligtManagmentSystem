package com.example.myflightdb.services;

import com.example.myflightdb.Entities.Payment;
import com.example.myflightdb.Repositories.BookingRepository;
import com.example.myflightdb.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServices {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    BookingRepository bookingRepository;

    public List<Payment> getAllPayments(){return paymentRepository.findAll();}

    public Payment addPayment(Payment payment){return paymentRepository.save(payment);}

    public Payment paymentById(Integer id){
        return paymentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Payment not found"));
    }
}
