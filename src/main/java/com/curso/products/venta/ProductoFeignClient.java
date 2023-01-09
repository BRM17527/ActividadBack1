package com.curso.products.venta;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.products.entitys.Product;

@FeignClient(name= "products", url = "localhost:8080" )
public interface ProductoFeignClient {

	@GetMapping("/products/")
	public List<Product> listaProducto();
	
	@GetMapping("/products/productId")
	public Product id_product(@PathVariable Integer productId);
}
