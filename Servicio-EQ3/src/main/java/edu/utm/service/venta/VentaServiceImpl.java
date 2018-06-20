package edu.utm.service.venta;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Venta;
import edu.utm.dao.venta.VentaDao;

@Named
public class VentaServiceImpl<sqlSession> implements VentaService {
	@Inject
	VentaDao ventaDao;
	
	@Override
	public void registrarVenta(Venta venta){
		ventaDao.registrarVenta(venta);
	}
	@Override
	public void registroVenta(Venta venta){
		ventaDao.registroVenta(venta);
	}
	@Override
	public List<Venta> findAllVentas() {
		return ventaDao.findAllVentas();
	}

	@Override
	public List<Venta> findDay(Venta venta) {
		return ventaDao.findDay(venta);
	}

	@Override
	public List<Venta> findWeek(Venta venta) {
		return ventaDao.findWeek(venta);
	}
	@Override
	public List<Venta> findVenta(Integer numVenta) {
	
		return ventaDao.findVenta(numVenta);
	}

	@Override
	public List<Venta> findVentas() {
	
		return ventaDao.findVentas();
	}
	@Override
	public Venta encuentraMax() {
		
		return ventaDao.encuentraMax();
	}
	@Override
	public Venta encuentraNumVenta(Integer idVenta) {
		return ventaDao.encuentraNumVenta(idVenta);
	}

}
