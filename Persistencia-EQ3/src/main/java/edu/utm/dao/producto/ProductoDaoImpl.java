package edu.utm.dao.producto;





import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;







import edu.utm.bd.domain.Producto;
import edu.utm.bd.mappers.ProductoMapper;


@Named
public class ProductoDaoImpl implements ProductoDao {
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}

	
	@Override
	public void insertProducto(Producto producto) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.insertProducto(producto);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	@Override
	public void updateProducto(Producto producto){
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			
			productoMapper.updateProducto(producto);
			System.out.print(producto.getTipo());
			System.out.print(producto.getMarca());
			System.out.print(producto.getCantidad());
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
		
	}

	@Override
	public void deleteProducto(int id) {
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.deleteProducto(id);
			System.out.println("Producto Eliminado: "+id);
			
		}
		catch(Exception e){
			System.out.println("Error: "+e);
			FacesMessage msg = new FacesMessage("Error","Error al eliminar Producto");
			FacesContext.getCurrentInstance().addMessage(null,msg);
		}
		
	}



	@Override
	public List<Producto> findProductoByMarca(String marca) {
		List <Producto> list=null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list= productoMapper.findProductoByMarca(marca);			
			for(Producto c:list){
				System.out.print("Producto by Marca --");
				System.out.print("Id: "+c.getIdProducto());
				System.out.println("Marca: "+c.getMarca());
				
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}



	@Override
	public List<Producto> findProductoByTipo(String tipo) {
		
		List <Producto> list=null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list=productoMapper.findProductoByTipo(tipo);			
			for(Producto c:list){
				System.out.print("Producto by Tipo  --");
				System.out.print("id: "+c.getIdProducto());
				System.out.println("Tipo: "+c.getTipo());
				
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}



	@Override
	public List<Producto> findProductoByPrecio(double precio) {
		List <Producto> list=null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list=productoMapper.findProductoByPrecio(precio);			
			for(Producto c:list){
				System.out.print("Producto by Tipo  --");
				System.out.print("id: "+c.getIdProducto());
				System.out.println("Tipo: "+c.getTipo());
				System.out.println("precio Venta: "+c.getPrecioVenta());
				
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}



	@Override
	public List<Producto> findAllProducto() {
		List <Producto> list=null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			list= productoMapper.findAllProducto();	
			System.out.print("Todos los productos del la base de datos");
			for(Producto c:list){
				
				System.out.print("Id: "+c.getIdProducto());
				System.out.println("Marca: "+c.getMarca());
				
			}  
			return list;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}


	@Override
	public Producto findProductoByDescripcion(String descripcion) {
		Producto producto=null;
		try{
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			producto= productoMapper.findProductoByDescripcion(descripcion);	
			System.out.print("Buscar producto por descripcion: ");
				
			System.out.println("Id: "+producto.getIdProducto());
			System.out.println("Marca: "+producto.getMarca());
				
		
			return producto;
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		return null;
	}
	

}
