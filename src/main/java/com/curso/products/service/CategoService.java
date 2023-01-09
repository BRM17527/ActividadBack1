package com.curso.products.service;

import java.util.List;

import com.curso.products.entitys.Categoria;


public interface CategoService {
	public List<Categoria> findAll();
	public Categoria save(Categoria categoria);
	public Categoria findById(Integer id_categoria);
	public void delete(Integer id_categoria);

}
