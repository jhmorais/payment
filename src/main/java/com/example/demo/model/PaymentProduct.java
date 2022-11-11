package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "payment_product")
public @Data class PaymentProduct {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Integer id;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "payment")
	private Payment payment;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "product")
	private Product product;
}
