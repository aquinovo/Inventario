package edu.utm.service.factura;

import java.util.List;

import edu.utm.bd.domain.Factura;

public interface FacturaService {
	void insertFactura (Factura factura);
	List<Factura> findAllVenta(Integer idVenta);
	List<Factura> folioFactura();
	Factura datosFactura(Integer numVenta);
	Factura totalVenta(Integer numVenta);
}