package com.javaassignment.javaassignment.service;

import org.springframework.stereotype.Service;

import com.javaassignment.javaassignment.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    
    
    private List<Product> productList = new ArrayList<>();

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
      product.setId(String.valueOf(productList.size() + 1)); // Auto-generated product id
      productList.add(product);
      return product;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return  productList;
	}

	@Override
	public Map<String, Object> generateBills() {
      double totalPrice = 0;
      for (Product product : productList) {
          totalPrice += product.getPrice() * product.getQuantity();
      }

      double cgst = totalPrice * 0.09;
      double sgst = totalPrice * 0.09;
      double finalTotal = totalPrice + cgst + sgst;

      Map<String, Object> billMap = new HashMap<>();
      billMap.put("Products", productList);
      billMap.put("Total Price", totalPrice);
      billMap.put("CGST 9%", cgst);
      billMap.put("SGST 9%", sgst);
      billMap.put("Final Total", finalTotal);

      return billMap;
	}

	@Override
	public boolean deleteProductById(String productId) {
		// TODO Auto-generated method stub
      for (Product product : productList) {
      if (product.getId().equals(productId)) {
          productList.remove(product);
          return true; // Product deleted successfully
      }
  }
  return false;
		
	}




}
