package edu.utm.service.cliente;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Cliente;
import edu.utm.dao.cliente.ClienteDao;

@Named
public class ClienteServiceImpl implements ClienteService {
	@Inject
	ClienteDao clienteDao;

	@Override
	public List<Cliente> findAllClientes() {
		return clienteDao.findAllClientes();
	}
     
	@Override
	public Cliente findClienteByRFC(String rfc) {
		
		return clienteDao.findClienteByRFC(rfc);
	}

	@Override
	public List<Cliente> findClienteByNombre(String nombre) {
		
		return clienteDao.findClienteByNombre(nombre);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		clienteDao.updateCliente(cliente);
	}

	@Override
	public void insertCliente(Cliente cliente) {
		clienteDao.insertCliente(cliente);
	}

	@Override
	public void deleteCliente(int id) {
		clienteDao.deleteCliente(id);		
	}
	
}
