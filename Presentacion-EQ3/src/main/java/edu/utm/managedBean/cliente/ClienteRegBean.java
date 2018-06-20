package edu.utm.managedBean.cliente;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Cliente;
import edu.utm.service.cliente.ClienteService;

@ManagedBean @SessionScoped
@Named
public class ClienteRegBean implements Serializable {
	@Inject
	ClienteService clienteService;
	private String firstName;
	private String rfc;
	private String email;
	private String telefono;
	private String domicilio;
	private static final long serialVersionUID = 6684598180534181715L;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getrfc() {
		return rfc;
	}

	public void setrfc(String rfc) {
		this.rfc = rfc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono(){
    	return telefono;
    }
    public void setTelefono(String telefono){
    	this.telefono = telefono;
    }
    public String getDomicilio(){
    	return domicilio;
    }
    public void setDomicilio(String domicilio){
    	this.domicilio = domicilio;
    }
    
    

	public void createCliente() {
		
		System.out.println("Name: " + firstName );
		System.out.println("RFC: " + rfc);
		System.out.println("email: " + email);
		System.out.println("telefono: " + telefono);
		System.out.println("domicilio: " + domicilio);
		
		Cliente cliente = new Cliente();
		
		cliente.setNombre(firstName);
		cliente.setEmail(email);
		cliente.setRfc(rfc);
		cliente.setTelefono(telefono);
		cliente.setDomicilio(domicilio);
		
		clienteService.insertCliente(cliente);
		
		this.firstName = null;
		this.email = null;
		this.rfc = null;
		this.telefono = null;
		this.domicilio = null;
		
		FacesMessage msg = new FacesMessage("Cliente editado", firstName);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

}
