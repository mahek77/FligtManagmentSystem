package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.Payment;
import com.example.myflightdb.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentServices paymentServices;

    @GetMapping
    public List<Payment> getAllPayments(){return paymentServices.getAllPayments();}

    @GetMapping("/{id}")
    public Payment paymentById(@PathVariable Integer id){return paymentServices.paymentById(id);}

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentServices.addPayment(payment);
    }
}
