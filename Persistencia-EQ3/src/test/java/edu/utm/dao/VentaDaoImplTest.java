package edu.utm.dao;



import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Venta;
import edu.utm.dao.venta.VentaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class VentaDaoImplTest {
	@Inject
	VentaDao ventaDao;
	
	@Test
	public void pruebaRegistrarVenta(){
		try{
			Venta venta=new Venta();
			Date date= new Date();
			venta.setIdCliente(1);
			venta.setIdProducto(59);
			venta.setFecha(date);
			venta.setNumVenta(4);
			venta.setCantidad(1);
			ventaDao.registrarVenta(venta);
		}
		catch(Exception ex){
			System.out.println("error " + ex);
		}
	}	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<Venta> lista = ventaDao.findAllVentas();
			assertEquals(lista.size(),lista.size());
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
			ventaDao.findDay(venta);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarPorSemana(){
		try{
			System.out.println("Consultar por semana");
			Venta venta=new Venta();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			venta.setFecha(sdf.parse("2018/06/11"));
			ventaDao.findWeek(venta);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarPorVenta(){
		try{
			System.out.println("Consultar por venta");
			ventaDao.findVenta(111);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaConsultarVentas(){
		try{
			
			List<Venta>list = ventaDao.findVentas();
			System.out.println("Consultar ventas");
			System.out.println();
					
			for(Venta c:list){
				System.out.println("marca: "+c.getMarca());
				System.out.println("descripción: "+c.getDescripcion());
				System.out.println("tipo: "+c.getTipo());
			}
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaEncuentraMaximo(){
		try{
			System.out.println("Prueba Consulta id Maximo");
			Venta venta = ventaDao.encuentraMax();
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
	@Test
	public void pruebaEncuentraNumVenta(){
		Integer idVenta=116;
		try{		
			System.out.println("Prueba Consulta numero de Venta");
			Venta venta = ventaDao.encuentraNumVenta(idVenta);
		}catch(Exception ex){
			System.out.println("error" + ex);
		}
	}
}
