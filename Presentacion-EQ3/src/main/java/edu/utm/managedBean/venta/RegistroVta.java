package edu.utm.managedBean.venta;


import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Venta;
import edu.utm.service.cliente.ClienteService;
import edu.utm.service.venta.VentaService;

@ManagedBean @SessionScoped
@Named
public class RegistroVta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -839309056686754611L;
	@Inject
	VentaService ventaService;
	private String nombre;
	private String descripcion;
	private String tipo;
	private String marca;
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public void createVenta() {
		
		System.out.println("Name: " + nombre );
		System.out.println("Descripcion: " + descripcion);
		System.out.println("tipo: " + tipo);
		System.out.println("Marca: " + marca);
		
		Venta venta = new Venta();
		Date date = new Date();
		venta.setNombre(nombre);
		venta.setDescripcion(descripcion);
		venta.setTipo(tipo);
		venta.setMarca(marca);
		venta.setFecha(date);
		ventaService.registroVenta(venta);
		
		this.nombre = null;
		this.descripcion = null;
		this.tipo = null;
		this.marca = null;
		FacesMessage msg = new FacesMessage("venta editado", nombre);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

}
