package com.example.demo.repository;

import com.example.demo.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query("SELECT p FROM Payment p JOIN p.products pr WHERE pr.payment = ?1")
	Payment findPaymentWithProducts(Integer paymentID);
}
