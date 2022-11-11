package com.example.demo.service;

import com.example.demo.model.PaymentProduct;
import com.example.demo.repository.PaymentProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PaymentProductService {
    @Autowired
    private PaymentProductRepository paymentProductRepository;
    public List<PaymentProduct> listAllPaymentProduct() {
        return paymentProductRepository.findAll();
    }

    public void savePaymentProduct(PaymentProduct paymentProduct) {
    	paymentProductRepository.save(paymentProduct);
    }

    public PaymentProduct getPaymentProduct(Integer id) {
        return paymentProductRepository.findById(id).get();
    }

    public void deletePaymentProduct(Integer id) {
    	paymentProductRepository.deleteById(id);
    }
}
