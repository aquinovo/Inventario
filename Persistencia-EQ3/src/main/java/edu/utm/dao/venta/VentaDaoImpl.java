package edu.utm.dao.venta;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Venta;
import edu.utm.bd.mappers.VentaMapper;

@Named
public class VentaDaoImpl implements VentaDao{
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	@Override
	public void registrarVenta(Venta venta) {
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			System.out.println("Registrar Venta: ");
			ventaMapper.registrarVenta(venta);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}
	
	@Override
	public void registroVenta(Venta venta) {
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			System.out.println("Registro Venta: "); 
			ventaMapper.registroVenta(venta);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}
	
	@Override
	public List<Venta> findAllVentas() {
		List <Venta> list=null;
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			list=ventaMapper.findAllVentas();	
			System.out.println("Find all ventas: ");
			for(Venta c:list){
				System.out.println("Id: "+c.getIdVenta());
				System.out.println("Id Cliente: "+c.getIdCliente());
				System.out.println("Id Cliente: "+c.getIdProducto());
				System.out.println("Fecha: "+c.getFecha());
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	@Override
	public List<Venta> findVentas() {
		List <Venta> list=null;
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			System.out.println("Find Venta: ");
			list=ventaMapper.findVentas();		
			for(Venta c:list){
				System.out.println("Id: "+c.getIdVenta());
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public List<Venta> findDay(Venta fecha) {
		List <Venta> list = null;
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);	
			list=ventaMapper.findDay(fecha);	
			System.out.println("Listar ventas por dia: ");
			for(Venta c:list){
				System.out.println("Fecha: "+c.getFecha());
				System.out.println("Numero: "+c.getNumVenta());
				System.out.println("Ganancia: "+ c.getGanancia());
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public List<Venta> findWeek(Venta fecha) {
		List <Venta> list = null;
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			System.out.println("Listar ventas por semana: ");
			list=ventaMapper.findWeek(fecha);	
			for(Venta c:list){
				System.out.println("Id: "+c.getNumVenta());
				System.out.println("Ganancia: "+c.getGanancia());
				System.out.println("Fecha: "+c.getFecha());
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public List<Venta> findVenta(Integer numVenta) {
		List <Venta> list=null;
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			//System.out.println("Find numVenta: ");
			list=ventaMapper.findVenta(numVenta);	
			for(Venta c:list){
				//System.out.println("Marca: "+c.getMarca());
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Venta encuentraMax() {
		Venta venta=new Venta();
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			venta=ventaMapper.encuentraMax();
			System.out.println("Id Maximo de venta: "+venta.getIdVenta());
			return venta;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

	@Override
	public Venta encuentraNumVenta(Integer idVenta) {
		
		Venta venta=new Venta();
		try{
			VentaMapper ventaMapper = sqlSession.getMapper(VentaMapper.class);
			venta=ventaMapper.encuentraNumVenta(idVenta);
			System.out.println("Numero de Venta: "+venta.getNumVenta());
			return venta;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}

}
