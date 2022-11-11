package com.example.demo.controller;

import com.example.demo.model.PaymentProduct;
import com.example.demo.service.PaymentProductService;

import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/paymentproducts")
@ApiIgnore
public class PaymentProductController {
    @Autowired
    PaymentProductService paymentProductService;

    @GetMapping("")
    public List<PaymentProduct> list() {
        return paymentProductService.listAllPaymentProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentProduct> get(@PathVariable Integer id) {
        try {
        	PaymentProduct product = paymentProductService.getPaymentProduct(id);
            return new ResponseEntity<PaymentProduct>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PaymentProduct>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody PaymentProduct paymentProduct) {
    	paymentProductService.savePaymentProduct(paymentProduct);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PaymentProduct paymentProduct, @PathVariable Integer id) {
        try {
        	PaymentProduct existProduct = paymentProductService.getPaymentProduct(id);
            paymentProduct.setId(id);            
            paymentProductService.savePaymentProduct(paymentProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

    	paymentProductService.deletePaymentProduct(id);
    }
}