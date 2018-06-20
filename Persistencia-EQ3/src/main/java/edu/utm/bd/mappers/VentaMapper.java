package edu.utm.bd.mappers;

import java.util.List;

import edu.utm.bd.domain.Venta;

public interface VentaMapper {
	void registrarVenta(Venta venta);
	void registroVenta(Venta venta);	
	List<Venta>findAllVentas();
	List<Venta>findDay(Venta venta);
	List<Venta>findWeek(Venta venta);
	List<Venta>findVenta(Integer numVenta);
	List<Venta>findVentas();
	Venta encuentraMax();
	Venta encuentraNumVenta(Integer idVenta);
}
