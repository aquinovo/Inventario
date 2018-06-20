package edu.utm.service.factura;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Factura;
import edu.utm.dao.factura.FacturaDao;

@Named
public class FacturaServiceImpl implements FacturaService{
	@Inject
	FacturaDao facturaDao;
	@Override
	public void insertFactura(Factura factura){
		facturaDao.insertFactura(factura);
	}
	
	public List<Factura> findAllVenta(Integer idVenta){
		return facturaDao.findAllVenta(idVenta);
	}

	@Override
	public List<Factura> folioFactura() {
		return facturaDao.folioFactura();
	}

	@Override
	public Factura datosFactura(Integer numVenta) {
		// TODO Auto-generated method stub
		return facturaDao.datosFactura(numVenta);
	}
	@Override
	public Factura totalVenta(Integer numVenta) {
		return facturaDao.totalVenta(numVenta);
	}
}