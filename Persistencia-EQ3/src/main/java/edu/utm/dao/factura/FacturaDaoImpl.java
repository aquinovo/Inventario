package edu.utm.dao.factura;

import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Factura;
import edu.utm.bd.domain.Venta;
import edu.utm.bd.mappers.FacturaMapper;
import edu.utm.bd.mappers.VentaMapper;

@Named
public class FacturaDaoImpl implements FacturaDao{
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}	
	@Override
	public void insertFactura(Factura factura) {
		try{
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			facturaMapper.insertFactura(factura);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}		
	}	
///////////////	
	@Override
	public List<Factura> findAllVenta(Integer idVenta){
		List<Factura> list=null;
		
		try{
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			list = facturaMapper.findAllVenta(idVenta);
			for(Factura c:list){											
				System.out.println("Id_producto: "+ c.getIdProducto());
				System.out.println("Cantidad: "+ c.getCantidad());
				System.out.println("Descripcion: "+ c.getDescripcion());
				System.out.println("Precio Venta: "+ c.getPrecioVenta());
				System.out.println("Importe: "+ c.getImporte());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	/////////
	@Override
	public List<Factura> folioFactura(){
		List<Factura> list=null;
		try{
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			list=facturaMapper.folioFactura();
			for(Factura c:list){											
				System.out.println("id_factura: "+ c.getIdFactura());
				System.out.println("id_venta: "+ c.getIdVenta());
				System.out.println("numVenta: "+ c.getNumVenta());
			}
			System.out.println("Folio: "+ list.size());			
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
///////////////
	@Override
	public Factura datosFactura(Integer idVenta) {
		Factura factura= new Factura();
		try{
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			factura = facturaMapper.datosFactura(idVenta);		
			System.out.println("RFC: "+factura.getRfc());			
			System.out.println("Nombre: "+factura.getNombre());
			System.out.println("Direccion: "+factura.getDomicilio());
			System.out.println("Fecha: "+factura.getFecha());
		
			return factura;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
/////////////////
	@Override
	public Factura totalVenta(Integer numVenta) {
		Factura factura=new Factura();
		try{
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			factura = facturaMapper.totalVenta(numVenta);
			System.out.println("Venta Total: "+factura.getTotal());				
			return factura;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	/*@Override
	public List<Factura> findAllVenta(Integer idVenta){
		List<Factura> list=null;
		try{
			FacturaMapper facturaMapper = sqlSession.getMapper(FacturaMapper.class);
			list = facturaMapper.findAllVenta(idVenta);
			for(Factura c:list){											
				System.out.println("Id_producto: "+ c.getIdProducto());
				System.out.println("Cantidad: "+ c.getCantidad());
				System.out.println("Descripcion: "+ c.getDescripcion());
				System.out.println("Precio Venta: "+ c.getPrecioVenta());
				System.out.println("Importe: "+ c.getImporte());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}*/	
	
}
