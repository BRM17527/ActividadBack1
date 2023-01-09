package com.curso.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.curso.products.dao.ProductsDAO;
import com.curso.products.entitys.Product;

public class ProductImplement implements ProductService {
	
	@Autowired
	private ProductsDAO productDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Product> findAll(){
		return (List<Product>) productDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Product save(Product product) {
		return productDAO.save(product);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Product findById(Integer id_product) {
		return productDAO.findById(id_product).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(Integer id_product) {
		productDAO.deleteById(id_product);
	}
	

}
