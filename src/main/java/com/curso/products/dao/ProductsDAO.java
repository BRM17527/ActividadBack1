package com.curso.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.curso.products.entitys.Product;


public interface ProductsDAO extends JpaRepository<Product, Integer>  {

}
