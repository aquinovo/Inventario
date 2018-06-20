package edu.utm.dao.factura;


import java.util.List;

import edu.utm.bd.domain.Factura;
import edu.utm.bd.domain.Venta;
public interface FacturaDao {
	void insertFactura (Factura factura);
	List<Factura> findAllVenta(Integer idVenta);
	List<Factura> folioFactura();
	Factura datosFactura(Integer idVenta);
	Factura totalVenta(Integer numVenta);
}