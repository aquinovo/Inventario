package edu.utm.dao;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Factura;
import edu.utm.dao.factura.FacturaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class FacturaDaoImplTest {
	@Inject
	FacturaDao facturaDao;
	/*
	@Test
	public void pruebaInsertarTodo(){
		try{
			Factura factura = new Factura();
			factura.setIdVenta(1);
			facturaDao.insertFactura(factura);
			System.out.println("Se ha insertado desde Persistencia");
		}catch(Exception ex){
			System.out.println("error " + ex);
		}
	}*/
	@Test
	public void pruebaConsultarTodo(){
		try{
			Integer idVenta = 115;
			List<Factura> lista =facturaDao.findAllVenta(idVenta);
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarFactura(){
		try{
			List<Factura> factura =facturaDao.folioFactura();			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	@Test
	public void pruebaDatosFactura(){
		try{
			Integer idVenta=118;
			Factura factura =facturaDao.datosFactura(idVenta);			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	@Test
	public void pruebaTotalVenta(){
		try{
			Integer numVenta = 2;
			Factura factura =facturaDao.totalVenta(numVenta);
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
}