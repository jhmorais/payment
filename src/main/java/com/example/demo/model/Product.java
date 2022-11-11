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
public @Data class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Integer id;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "account")
	private Account account;
	
	@ToString.Include
	@NonNull
	private String name;
	
	@ToString.Include
	@NonNull
	private Float price;
}
