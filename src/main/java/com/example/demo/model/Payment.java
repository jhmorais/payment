package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public @Data class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Integer id;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "account")
	private Account account;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
        name = "payment_product",
        joinColumns = @JoinColumn(name = "payment"),
        inverseJoinColumns = @JoinColumn(name = "product")
    )
	private Set<Product> products = new HashSet<>();

}
