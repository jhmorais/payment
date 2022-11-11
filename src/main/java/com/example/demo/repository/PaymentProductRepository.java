package com.example.demo.repository;

import com.example.demo.model.PaymentProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentProductRepository extends JpaRepository<PaymentProduct, Integer>{}
