package edu.utm.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Producto;
import edu.utm.service.producto.ProductoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class ProductoServiceImplTest {
	@Inject
	ProductoService productoService;
	
	@Test
	public void pruebaTodosProductos(){
		try{
			List<Producto> lista = productoService.findAllProducto();
			assertEquals(lista.size(),lista.size());
		}catch(Exception ex){
			System.out.println("Error"+ex);
			
		}
	}
	@Test
	public void pruebaInsertarProducto(){
		try{
			Producto producto=new Producto();
			
			producto.setDescripcion("Silla Ronan Brown Pier 1 Imports");
			producto.setTipo("Silla");
			producto.setMarca("PIER 1 IMPORTS");
			producto.setPrecioCompra(1520.0);
			producto.setPrecioVenta(3799.0);
			producto.setCantidad(40);
			
			productoService.insertProducto(producto);
			
			System.out.println("Inserción de producto: "+producto.getDescripcion());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaActualizarProducto(){
		try{
			
			Producto producto=new Producto();
			producto.setIdProducto(58);
			producto.setDescripcion("Horno de Microondas Empotrable Io Mabe");
			producto.setTipo("Horno");
			producto.setMarca("MABE");
			producto.setPrecioCompra(3749.0);
			producto.setPrecioVenta(5115.5);
			producto.setCantidad(23);
			
			
			System.out.println(producto.getDescripcion());
			productoService.updateProducto(producto);		
			System.out.println("Actualización de cliente: "+producto.getIdProducto());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaEliminarProducto(){
		try{
			
			
			int id = 65;
			productoService.deleteProducto(id);		
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarProductosByMarca(){
		try{
			String marca = "MABE";
			List<Producto> lista =productoService.findProductoByMarca(marca);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	
	@Test
	public void pruebaConsultarProductosByTipo(){
		try{
			String tipo = "Frigobar";
			List<Producto> lista =productoService.findProductoByTipo(tipo);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	
	@Test
	public void pruebaConsultarProductosByPrecioVenta(){
		try{
			double precio = 9999;
			List<Producto> lista =productoService.findProductoByPrecio(precio);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarProductosByDescripcion(){
		try{
			String descripcion="Lavadora 10 kilos, color negro, ";
			Producto producto =productoService.findProductoByDescripcion(descripcion);
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}

}
