package edu.utm.dao.cliente;

import java.util.List;

import edu.utm.bd.domain.Cliente;

public interface ClienteDao {
	List<Cliente>findAllClientes();
	Cliente findClienteByRFC(String rfc);
	List<Cliente> findClienteByNombre(String nombre);
	void updateCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
	void deleteCliente(int id);
}
