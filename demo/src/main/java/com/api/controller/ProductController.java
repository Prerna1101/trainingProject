package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Exception.HnDBankException;
import com.api.entity.Product;
import com.api.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		Product addedProduct = productService.addProduct(p);
		return new ResponseEntity<Product> (addedProduct, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<Product>> (allProducts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId) {
		Product productById = productService.getProductById(productId);
		return new ResponseEntity<Product> (productById, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteProductById/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") Integer productId) {
		this.productService.deleteProductById(productId);
		return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/updateProduct/{productId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("productId") Integer productId, @RequestBody Product newProduct) throws HnDBankException {
        Optional<Product> optional = Optional.ofNullable(productService.getProductById(productId));
        Product product = optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
		productService.updateProduct(productId, newProduct);
        return new ResponseEntity<>("Product Updated", HttpStatus.OK);
		
	}
	
}
