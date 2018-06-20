package edu.utm.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Cliente;
import edu.utm.service.cliente.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class ClientServiceImplTest {
	@Inject
	ClienteService clienteService;
	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<Cliente> lista =clienteService.findAllClientes();
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarClienteByRFC(){
		try{
			String rfc = "JD53726289";
			Cliente lista =clienteService.findClienteByRFC(rfc);
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	
	@Test
	public void pruebaConsultarClienteByNombre(){
		try{
			String nombre = "Joe Doe";
			List<Cliente> lista =clienteService.findClienteByNombre(nombre);
			equals(lista.size());
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaActualizarCliente(){
		try{
			Cliente cliente=new Cliente();
			cliente.setIdCliente(1);
			cliente.setNombre("Lizbeth Colores");
			cliente.setEmail("LColores@gmail.com");
			cliente.setDomicilio("AV Universidad");
			cliente.setRfc("LC568GR2");
			cliente.setTelefono("9547852");
			
			
			clienteService.updateCliente(cliente);
			
			System.out.println("Actualización de cliente: "+cliente.getNombre());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaInsertarCliente(){
		try{
			Cliente cliente=new Cliente();
			cliente.setIdCliente(4);
			cliente.setNombre("Alma");
			cliente.setEmail("Alma@gmail.com");
			cliente.setDomicilio("calle Tierra y Libertad #30");
			cliente.setRfc("A83MWUI45");
			cliente.setTelefono("7458904");
			
			
			clienteService.insertCliente(cliente);
			
			System.out.println("Inserción de cliente: "+cliente.getNombre());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaEliminarCliente(){
		try{
			int id = 6;
			clienteService.deleteCliente(id);		
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
}
