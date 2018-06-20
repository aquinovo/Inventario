package edu.utm.managedBean.venta;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import edu.utm.bd.domain.Venta;

@ManagedBean
@ViewScoped
@Named
public class VentaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5715487822426617936L;
	@Inject
	edu.utm.service.venta.VentaService ventaService;
	private String opciones = "Dia";
	private Double suma = 0.0;
	private Date hoy = new Date();
	private List<Venta> ventaList;
	private List<Venta> ventaList2;
	private Venta ventaList3;
	
	public List<Venta> getGananciaList() {
		Venta venta = new Venta();
		venta.setFecha(hoy);
		if (opciones.equals("Dia")) {
			ventaList = ventaService.findDay(venta);
		}
		if (opciones.equals("Semana")) {
			ventaList = ventaService.findWeek(venta);
		}
		System.out.println(" **consultar** ");
		if (ventaList == null)
			setVentaList(ventaList);

		return ventaList;
	}

	public void setVentaList(List<Venta> ventaList) {
		// TODO Auto-generated method stub
		this.ventaList = ventaList;

	}

	public List<Venta> getVentaList() {
		// TODO Auto-generated method stub
		return ventaList;
	}

	public List<Venta> getNumVenta(Integer numVenta) {
		System.out.println(" sky  " + numVenta);
		suma = 0.0;
		ventaList2 = ventaService.findVenta(numVenta);
		System.out.println(" **numVenta** ");
		for (Venta c : ventaList2) {
			suma = suma + c.getPrecioVenta();
		}
		if (ventaList2 == null)
			setVentaList(ventaList2);
		return ventaList2;
	}

	public void setVentaList2(List<Venta> ventaList2) {
		// TODO Auto-generated method stub
		this.ventaList2 = ventaList2;

	}
	public List<Venta> getVentaList2() {
		// TODO Auto-generated method stub
		return ventaList2;
	}

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}

	public String getOpciones() {
		return opciones;
	}

	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

	public Venta getVentaList3() {
		return ventaList3;
	}

	public void setVentaList3(Venta ventaList3) {
		this.ventaList3 = ventaList3;
	}

}
