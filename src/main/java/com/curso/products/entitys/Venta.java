package com.curso.products.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="venta")
public class Venta {
	
		@Id
		@Column(name="id_venta")
		private Integer id_venta;
		
		@Column(name="id_cliente")
		private Integer id_cliente;
		
		@Column(name="precio")
		private Double precio;
		
		@Column(name="cantidad")
		private Integer cantidad;
		
		@Column(name="fechaVenta")
		private Date fechaVenta;

}
