package edu.utm.dao.cliente;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.mappers.ClienteMapper;

@Named
public class ClienteDaoImpl implements ClienteDao {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}

	@Override
	public List<Cliente> findAllClientes() {
		List <Cliente> list=null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list=clienteMapper.findAllClientes();			
			for(Cliente c:list){
				System.out.println("Id: "+c.getIdCliente());
				System.out.println("Nombre: "+c.getNombre());
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	
	@Override
	public Cliente findClienteByRFC(String rfc) {
		Cliente cliente=null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			cliente= clienteMapper.findClienteByRFC(rfc);		
				System.out.print("Cliente por RFC --");
				System.out.print("Id: "+cliente.getIdCliente());
				System.out.println("RFC: "+cliente.getRfc());
			return cliente;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}


	@Override
	public List<Cliente> findClienteByNombre(String nombre) {
		
		List <Cliente> list=null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list=clienteMapper.findClienteByNombre(nombre);			
			for(Cliente c:list){
				System.out.print("Cliente por Nombre  --");
				System.out.print("id: "+c.getIdCliente());
				System.out.println("Nombre: "+c.getNombre());
				
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	@Override
	public void updateCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.updateCliente(cliente);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	public void insertCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.insertCliente(cliente);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	public void deleteCliente(int id) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			clienteMapper.deleteCliente(id);
			System.out.println("Cliente Eliminado: "+id);
			
		}
		catch(Exception e){
			System.out.println("Error: "+e);
			FacesMessage msg = new FacesMessage("Error","Error al eliminar cliente ");
			FacesContext.getCurrentInstance().addMessage(null,msg);
		}
		
	}

}
