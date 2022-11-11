package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
    	productRepository.save(product);
    }

    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Integer id) {
    	productRepository.deleteById(id);
    }
}
