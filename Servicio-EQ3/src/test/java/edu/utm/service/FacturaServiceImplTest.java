package edu.utm.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.service.factura.FacturaService;
import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Factura;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class FacturaServiceImplTest {
	@Inject
	FacturaService facturaService;
	
	@Test
	public void pruebaDatosVenta(){
		try{
			Integer idVenta=114;
			List<Factura> lista =facturaService.findAllVenta(idVenta);	
			System.out.println("Prueba desde servicio");
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}	
	@Test
	public void pruebaInsertarTodo(){
		try{
			Factura factura = new Factura();			
			factura.setIdVenta(120);
			facturaService.insertFactura(factura);
			System.out.println("Se ha insertado correctamente desde servicios");
		}catch(Exception e){
			System.out.println("error " + e);
		}
	}
	@Test
	public void pruebaConsultarFactura(){
		try{
			List<Factura> lista =facturaService.folioFactura();
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	@Test
	public void pruebaDatosFactura(){
		try{
			Integer idVenta=112;
			Factura factura =facturaService.datosFactura(idVenta);	
			System.out.println("DatosFactura desde Servicios");
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	@Test
	public void pruebaVentaTotal(){
		try{
			Integer numVenta=3;
			Factura factura =facturaService.totalVenta(numVenta);	
			System.out.println("Prueba desde servicio");
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
}
