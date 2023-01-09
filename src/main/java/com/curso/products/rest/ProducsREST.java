package com.curso.products.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.products.dao.ProductsDAO;
import com.curso.products.entitys.Product;

@RestController
@RequestMapping("/")
public class ProducsREST {
	
	@Autowired
	private ProductsDAO productDAO;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> products= productDAO.findAll();
		return ResponseEntity.ok(products);
	}
	
	@RequestMapping(value="{productId}") //  /products/{productId}  --> /products/1
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId){
		Optional<Product> optionalProduct = productDAO.findById(productId);
		if(optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping  //products (POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value="{productId}")  //products (DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Integer productId){
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping(value="{productId}")  //PUT
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Optional<Product> optionalProduct = productDAO.findById(product.getId_product());
		if(optionalProduct.isPresent()) {
			Product updateProduct = optionalProduct.get();
			updateProduct.setName(product.getName());
			updateProduct.setPrecio(product.getPrecio());
			updateProduct.setId_categoria(product.getId_categoria());
			updateProduct.setDescripcion(product.getDescripcion());
			productDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
