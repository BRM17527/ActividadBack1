package com.curso.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.products.entitys.Venta;

public interface VentaDAO extends JpaRepository<Venta, Integer>{

}
