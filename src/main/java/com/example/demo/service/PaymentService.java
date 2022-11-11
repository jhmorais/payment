package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payment> listAllPayment() {
        return paymentRepository.findAll();
    }

    public void savePayment(Payment payment) {
    	paymentRepository.save(payment);
    }

    public Payment getPayment(Integer id) {
        return paymentRepository.findById(id).get();
    }

    public void deletePayment(Integer id) {
    	paymentRepository.deleteById(id);
    }
    
    public Payment getPaymentWithProducts(Integer id) {
        return paymentRepository.findPaymentWithProducts(id);
    }
}
