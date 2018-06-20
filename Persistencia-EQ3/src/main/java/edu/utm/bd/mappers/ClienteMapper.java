package edu.utm.bd.mappers;
import java.util.List;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.mappers.ClienteMapper;

public interface ClienteMapper {
	List<Cliente>findAllClientes();
	Cliente findClienteByRFC(String rfc);
	List<Cliente> findClienteByNombre(String nombre);
	void updateCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
	void deleteCliente(int id);
}

