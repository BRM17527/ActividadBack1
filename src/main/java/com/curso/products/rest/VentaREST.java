package com.curso.products.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.products.dao.VentaDAO;
import com.curso.products.entitys.Venta;

@FeignClient(name= "products", url = "localhost:8080" )
public class VentaREST {

	@Autowired
	private VentaDAO ventaDAO;
	
	@GetMapping
	public ResponseEntity<List<Venta>> getVenta(){
		List<Venta> ventas= ventaDAO.findAll();
		return ResponseEntity.ok(ventas);
	}
}
