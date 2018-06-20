package edu.utm.managedBean.cliente;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import edu.utm.bd.domain.Cliente;


@ManagedBean
@ViewScoped
@Named
public class ClienteBean {
	@Inject
	edu.utm.service.cliente.ClienteService clienteService;
	private String firstName;
	private String rfc;
	private String email;
	private String telefono;
	private String domicilio;
	private List<Cliente> clienteList;
	private List<Cliente> filteredCliente;
	public List<Cliente> getClienteList(){
		if(clienteList == null)
			setClienteList(clienteService.findAllClientes());
		//System.out.println("Impresion desde el managedBean");
		return clienteList;
		//return clienteService.findAllClientes();
		
	}
	public List<Cliente> getFilteredCliente(){
		return filteredCliente;
	}
	public void setFilteredCliente(List<Cliente> filteredCliente){
		this.filteredCliente=filteredCliente;
	}
	public void setClienteList(List<Cliente> clienteList) {
		// TODO Auto-generated method stub
		this.clienteList = clienteList;
		
	}
	public void deleteCliente(Cliente cliente1){
		//invoca al servicio
		clienteService.deleteCliente(cliente1.getIdCliente());
		FacesMessage msg = new FacesMessage("Successful","Cliente Eliminado ");
		FacesContext.getCurrentInstance().addMessage(null,msg);
		//actualiza los valores de la tabla
		setClienteList(clienteService.findAllClientes());
		getClienteList();
		
	}
	public void onRowEdit(RowEditEvent event){
		Cliente cliente = ((Cliente) event.getObject());
		System.out.println("datos cliente"+cliente.getIdCliente());
		
		clienteService.updateCliente(cliente);
		
		FacesMessage msg = new FacesMessage("Successful","Cliente "+cliente.getIdCliente().toString()+" Actualizado");
		FacesContext.getCurrentInstance().addMessage(null,msg);
		
	}
	
	public void onRowCancel(RowEditEvent event){
		Cliente cliente = ((Cliente) event.getObject());
		FacesMessage msg = new FacesMessage("Edicion Cancelada", cliente.getIdCliente().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		
	}
	
	public void onCellEdit(CellEditEvent event){
		
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		System.out.print("verifica: "+newValue);
		
		if(newValue != null && !newValue.equals(oldValue)){
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cliente modificado",
					"Antes: "+ oldValue + ", Ahora:"+newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void createCliente(){
		
		
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
		
		
		//clienteService.findAllClientes();
		clienteService.insertCliente(cliente);
		
		
		setClienteList(clienteService.findAllClientes());
		getClienteList();
		
		this.firstName = null;
		this.email = null;
		this.rfc = null;
		this.telefono = null;
		this.domicilio = null;
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Cliente Registrado") );

		
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	
}
