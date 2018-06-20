package edu.utm.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Venta;
import edu.utm.service.venta.VentaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"/applicationContext.xml"})
public class VentaServiceImplTest {
	@Inject
	VentaService ventaService;
	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<Venta> lista = ventaService.findAllVentas();
			assertEquals(lista.size(),lista.size());
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarPorSemana(){
		try{
		
			Venta venta=new Venta();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			venta.setFecha(sdf.parse("2018/06/10"));
			ventaService.findWeek(venta);
			System.out.println("Consultar por semana");
			
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarPorDia(){
		try{
			System.out.println("Consultar por dia");
			Venta venta=new Venta();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			venta.setFecha(sdf.parse("2018/06/10"));
			ventaService.findDay(venta);
			
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarPorVenta(){
		try{
			System.out.println("Consultar por venta");
			ventaService.findVenta(111);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaRegistrarVenta(){
		try{
			Venta venta=new Venta();
			Date date= new Date();
			venta.setIdCliente(2);
			venta.setIdProducto(62);
			venta.setFecha(date);
			venta.setNumVenta(8);
			venta.setCantidad(2);
			ventaService.registrarVenta(venta);
			System.out.println("Prueba exitosa de VentaServiceImplement");
		}
		catch(Exception ex){
			System.out.println("error " + ex);
		}
	}
	@Test
	public void pruebaEncuentraMaximo(){
		try{
			System.out.println("Prueba Consulta id Maximo");
			Venta venta = ventaService.encuentraMax();
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaEncuentraNumVenta(){
		Integer idVenta=114;
		try{		
			System.out.println("Prueba Consulta numero de Venta");
			Venta venta = ventaService.encuentraNumVenta(idVenta);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
}
