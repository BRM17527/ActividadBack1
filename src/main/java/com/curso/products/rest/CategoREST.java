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

import com.curso.products.dao.CategoDAO;
import com.curso.products.entitys.Categoria;


@RestController
@RequestMapping("categoria")
public class CategoREST {
	@Autowired
	private CategoDAO categoDAO;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategoria(){
		List<Categoria> categorias= categoDAO.findAll();
		return ResponseEntity.ok(categorias);
	}
	
	@RequestMapping(value="{categoriaId}") //  /products/{productId}  --> /products/1
	public ResponseEntity<Categoria> getProductById(@PathVariable("categoriaId") Integer categoriaId){
		Optional<Categoria> optionalCatego = categoDAO.findById(categoriaId);
		if(optionalCatego.isPresent()) {
			return ResponseEntity.ok(optionalCatego.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping  //products (POST)
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
		Categoria newCategoria = categoDAO.save(categoria);
		return ResponseEntity.ok(newCategoria);
	}
	
	@DeleteMapping(value="{categoriaId}")  //products (DELETE)
	public ResponseEntity<Void> deleteCategoria(@PathVariable("categoriaId") Integer categoriaId){
		categoDAO.deleteById(categoriaId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping(value="{categoriaId}")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
		Optional<Categoria> optionalCategoria = categoDAO.findById(categoria.getId_categoria());
		if(optionalCategoria.isPresent()) {
			Categoria updateCategoria = optionalCategoria.get();
			updateCategoria.setDescripcion(categoria.getDescripcion());
			categoDAO.save(updateCategoria);
			return ResponseEntity.ok(updateCategoria);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
