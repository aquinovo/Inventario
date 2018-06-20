package edu.utm.service.venta;

import java.util.List;

import edu.utm.bd.domain.Venta;

public interface VentaService {
	List<Venta>findAllVentas();
	List<Venta>findDay(Venta venta);
	List<Venta>findWeek(Venta venta);
	void registrarVenta(Venta venta);
	void registroVenta(Venta venta);
	List<Venta>findVentas();
	List<Venta>findVenta(Integer numVenta);
	Venta encuentraMax();
	Venta encuentraNumVenta(Integer idVenta);
}
