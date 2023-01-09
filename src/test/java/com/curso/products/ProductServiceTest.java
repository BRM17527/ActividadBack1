package com.curso.products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import com.curso.products.dao.ProductsDAO;
import com.curso.products.entitys.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private Product productoTest;
	private ProductsDAO productsDAO;

	
	@BeforeEach
	public void productoTest() {
		MockitoAnnotations.openMocks(productoTest);
		productoTest =new Product();
		productoTest.setId_product(7);
		productoTest.setName("iPhone");
		productoTest.setPrecio(89.65);
		productoTest.setDescripcion("reacondicionado");
		productoTest.setId_categoria(3);
	}
	
	@Test
	void getAllProductsTest() {
		when(productsDAO.findAll()).thenReturn(List.of(productoTest));
		List<Product> product= productsDAO.findAll();
		assertNotNull(product);
	}
	
	@Test
	void getProductByIdTest() {
		when(productsDAO.findById(any(Integer.class))).thenReturn(Optional.of(productoTest));
		Optional<Product> product = productsDAO.findById(1);
		assertNotNull(product);
		assertEquals(productoTest, product);
	}
	
	@Test
	void deleteProductTest() {
		doNothing().when(productsDAO).deleteById(anyInt());
		productsDAO.deleteById(1);
	}
	

}
