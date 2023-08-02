package com.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Exception.HnDBankException;
import com.api.dto.CustomerDTO;
import com.api.entity.Product;

public interface ProductService extends JpaRepository<Product, Integer> {

	public Product addProduct(Product p);
	public List<Product> getAllProducts();
	public Product getProductById(Integer productId);
	public void deleteProductById(Integer productId);
	public void updateProduct(Integer productId, Product newProduct) throws HnDBankException;
}
