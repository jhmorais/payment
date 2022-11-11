package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/payments")
//@ApiIgnore
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("")
    public List<Payment> list() {
        return paymentService.listAllPayment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable Integer id) {
        try {
            Payment payment = paymentService.getPayment(id);
            return new ResponseEntity<Payment>(payment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody Payment payment) {
        paymentService.savePayment(payment);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Payment payment, @PathVariable Integer id) {
        try {
            Payment existPayment = paymentService.getPayment(id);
            payment.setId(id);            
            paymentService.savePayment(payment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        paymentService.deletePayment(id);
    }
}