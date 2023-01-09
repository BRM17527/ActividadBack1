package com.curso.products.service;

import java.util.List;

import com.curso.products.entitys.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product save(Product product);
	public Product findById(Integer id_product);
	public void delete(Integer id_product);

}
