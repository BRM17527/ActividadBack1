package com.curso.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.curso.products.dao.CategoDAO;
import com.curso.products.entitys.Categoria;

public class CategoImplements implements CategoService{
	@Autowired
	private CategoDAO categoDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll(){
		return (List<Categoria>) categoDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Categoria save(Categoria categoria) {
		return categoDAO.save(categoria);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Categoria findById(Integer id_categoria) {
		return categoDAO.findById(id_categoria).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(Integer id_categoria) {
		categoDAO.deleteById(id_categoria);
	}
	


}
