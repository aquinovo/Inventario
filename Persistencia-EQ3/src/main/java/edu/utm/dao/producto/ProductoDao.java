package edu.utm.dao.producto;




import java.util.List;



import edu.utm.bd.domain.Producto;

public interface ProductoDao {
	//Producto findProductoBySKU();
	void insertProducto(Producto producto);
	void updateProducto(Producto producto);
	void  deleteProducto(int id);
	List<Producto> findProductoByMarca(String marca);
	List<Producto> findProductoByTipo(String tipo);
	List<Producto> findProductoByPrecio(double precio);
	List<Producto> findAllProducto();
	Producto findProductoByDescripcion(String descripcion);

}
