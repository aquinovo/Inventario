package edu.utm.managedBean.factura;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Factura;
import edu.utm.bd.domain.Venta;
@ManagedBean @SessionScoped
@Named
public class FacturaBean {
	@Inject
	edu.utm.service.factura.FacturaService facturaService;
	@Inject
	edu.utm.service.venta.VentaService ventaService;
	private Factura factura;
	private List<Factura> facturaVenta;
	private List<Factura> facturaDetalle;
	private List<Factura> allFactura;   		
	private Factura facturaList;
	private Integer numVenta;
	
	public List<Factura> getFacturaAll(){
		Venta venta1=ventaService.encuentraMax();
		Venta venta2=ventaService.encuentraNumVenta(venta1.getIdVenta());
		Integer numeroVenta=venta2.getNumVenta();
		System.out.println("IdVenta: "+numeroVenta);
		setNumVenta(numeroVenta);		
		facturaVenta = facturaService.findAllVenta(numeroVenta);
		if(facturaVenta == null){
			setFacturaList(facturaVenta);
		}		
		return facturaVenta;
	}			
	public List<Factura> getFacturaDetalle(Integer numVenta){
		
		System.out.println("IdVenta: "+numVenta);
		//setNumVenta(numVenta);		
		facturaDetalle = facturaService.findAllVenta(numVenta);
		if(facturaDetalle == null){
			setFacturaList(facturaVenta);
		}		
		return facturaDetalle;
	}			
	public void setFacturaList(List<Factura> factura){
		this.facturaVenta = factura;
	}
	public List<Factura> getAllFactura(){	
		allFactura = facturaService.folioFactura();
		if(allFactura == null){
			setAllFactura(allFactura);
		}		
		return allFactura;
	}	
	public void setAllFactura(List<Factura> facturaList){
		this.allFactura = facturaList;
	}
	
	public Factura getDatosFactura(){
		Venta venta1=ventaService.encuentraMax();		
		Integer idVenta=venta1.getIdVenta();
		
		Factura factura=facturaService.datosFactura(idVenta);
		if(factura == null){
			setDatosFactura(factura);
		}						
		return factura;
	}
	public void setDatosFactura(Factura factura){
		this.factura = factura;
	}
	public Factura getTotalVenta(){
		Venta venta1=ventaService.encuentraMax();
		Venta venta2=ventaService.encuentraNumVenta(venta1.getIdVenta());
		Integer numeroVenta=venta2.getNumVenta();
		
		Factura factura=facturaService.totalVenta(numeroVenta);
		if(factura == null){
			setTotalVenta(factura);
		}						
		return factura;
	}
	public Factura getTotalVentaDetalle(Integer numeroVenta){
		
		Factura factura=facturaService.totalVenta(numeroVenta);
		if(factura == null){
			setTotalVenta(factura);
		}						
		return factura;
	}

	public void setTotalVenta(Factura factura){
		this.factura = factura;
	}
	///Insertar una nueva factura
	public void createFactura(){
		Venta venta1=ventaService.encuentraMax();		
		Integer idVenta=venta1.getIdVenta();		
		Factura factura = new Factura();
		factura.setIdVenta(idVenta);		
		facturaService.insertFactura(factura);	
		
		setAllFactura(facturaService.folioFactura());
		getAllFactura();
		
//		this.idVenta=null;
		
		System.out.println("Se ha insertado correctamente!!");				
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
	}
	public Factura getFacturaList() {
		return facturaList;
	}
	public void setFacturaList(Factura facturaList) {
		this.facturaList = facturaList;
	}
	public Integer getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(Integer numVenta) {
		this.numVenta = numVenta;
	}
}