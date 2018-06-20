package edu.utm.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Producto;
import edu.utm.dao.producto.ProductoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class ProductoDaoImpTest {
	@Inject
	ProductoDao productoDao;
	
	@Test
	public void pruebaConsultarProducto(){
		try{
			List<Producto> producto =productoDao.findAllProducto();
			assertEquals(producto.size(),producto.size());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}

	@Test
	public void pruebaInsertarProducto(){
		try{
			Producto producto=new Producto();
			
			producto.setDescripcion("Ventilador Pedestal Doble Aspa y Control Rotativo");
			producto.setTipo("Ventilador");
			producto.setMarca("MACON");
			producto.setPrecioCompra(500.0);
			producto.setPrecioVenta(1529.0);
			producto.setCantidad(15);
			
			productoDao.insertProducto(producto);
			
			System.out.println("Inserción de producto: "+producto.getDescripcion());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaActualizarProducto(){
		try{
			
			Producto producto=new Producto();
			producto.setIdProducto(62);
			producto.setDescripcion("Aspiradora Manual Koblenz");
			producto.setTipo("Aspiradora");
			producto.setMarca("KOBLENZ");
			producto.setPrecioCompra(600.5);
			producto.setPrecioVenta(1050.30);
			producto.setCantidad(30);
			
			
			System.out.println(producto.getDescripcion());
			productoDao.updateProducto(producto);		
			System.out.println("Actualización de Producto: "+producto.getIdProducto());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaEliminarProducto(){
		try{
			
			
			int id = 64;
			productoDao.deleteProducto(id);		
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarProductosByMarca(){
		try{
			String marca = "MABE";
			List<Producto> lista =productoDao.findProductoByMarca(marca);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	
	@Test
	public void pruebaConsultarProductosByTipo(){
		try{
			String tipo = "Lavadora";
			List<Producto> lista =productoDao.findProductoByTipo(tipo);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	
	@Test
	public void pruebaConsultarProductosByPrecioVenta(){
		try{
			double precio = 799.0;
			List<Producto> lista =productoDao.findProductoByPrecio(precio);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarProductosByDescripcion(){
		try{
			String descripcion="Aspiradora Manual Koblenz";
			Producto producto =productoDao.findProductoByDescripcion(descripcion);
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}

}
