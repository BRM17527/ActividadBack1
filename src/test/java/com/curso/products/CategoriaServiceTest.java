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

import com.curso.products.dao.CategoDAO;
import com.curso.products.entitys.Categoria;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {
	
	@Mock
	private Categoria categoTest;
	private CategoDAO categoDAO;

	
	@BeforeEach
	public void categoriaTest() {
		MockitoAnnotations.openMocks(categoTest);
		categoTest =new Categoria();
		categoTest.setId_categoria(3);
		categoTest.setDescripcion("productos redes");
	}
	
	@Test
	void getAllCategoriasTest() {
		when(categoDAO.findAll()).thenReturn(List.of(categoTest));
		List<Categoria> catego= categoDAO.findAll();
		assertNotNull(catego);
	}
	
	@Test
	void getCategoriaByIdTest() {
		when(categoDAO.findById(any(Integer.class))).thenReturn(Optional.of(categoTest));
		Optional<Categoria> catego = categoDAO.findById(1);
		assertNotNull(catego);
		assertEquals(categoTest, catego);
	}
	
	@Test
	void deleteCategoriaTest() {
		doNothing().when(categoDAO).deleteById(anyInt());
		categoDAO.deleteById(1);
	}

}
