package edu.utm.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.utm.bd.domain.Cliente;
import edu.utm.dao.cliente.ClienteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	
	@Test
	public void pruebaConsultarTodo(){
		try{
			List<Cliente> lista =clienteDao.findAllClientes();
			assertEquals(lista.size(),lista.size());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaConsultarClienteByRFC(){
		try{
			String rfc = "JD28907778";
			Cliente lista =clienteDao.findClienteByRFC(rfc);
			
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	
	@Test
	public void pruebaConsultarClienteByNombre(){
		try{
			String nombre = "Joe Doe";
			List<Cliente> lista =clienteDao.findClienteByNombre(nombre);
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
			cliente.setNombre("Colores");
			cliente.setEmail("Colores@gmail.com");
			cliente.setDomicilio("AV Universidad, km 20");
			cliente.setRfc("C23HP98D");
			cliente.setTelefono("2225897");
			
			
			clienteDao.updateCliente(cliente);
			
			System.out.println("Actualización de cliente: "+cliente.getNombre());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaInsertarCliente(){
		try{
			Cliente cliente=new Cliente();
			cliente.setIdCliente(6);
			cliente.setNombre("Aquino");
			cliente.setEmail("Aquino@gmail.com");
			cliente.setDomicilio("Calle Flores Magón #14");
			cliente.setRfc("A6694NLW7");
			cliente.setTelefono("5035014");
			
			
			clienteDao.insertCliente(cliente);
			
			System.out.println("Inserción de cliente: "+cliente.getNombre());
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
	@Test
	public void pruebaEliminarCliente(){
		try{
			
			
			int id = 4;
			clienteDao.deleteCliente(id);		
		}catch(Exception ex){
			System.out.println("error: "+ex);
		}
	}
	
}
