package com.javaassignment.javaassignment.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.javaassignment.javaassignment.entity.Product;

@Service
public interface ProductService {
	public Product addProduct(Product product);
    public List<Product> getProducts();
    public Map<String, Object> generateBills();

    boolean deleteProductById(String productId);

}
