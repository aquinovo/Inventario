package edu.utm.service.producto;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import edu.utm.bd.domain.Producto;
import edu.utm.dao.producto.ProductoDao;


@Named
public class ProductoServiceImpl implements ProductoService{
	@Inject
	ProductoDao productoDao;
	
	@Override
	public void insertProducto(Producto producto)
	{
		productoDao.insertProducto(producto);
	}
	
	@Override
	public void updateProducto(Producto producto) {
		productoDao.updateProducto(producto);
		
	}

	@Override
	public void deleteProducto(int id) {
		productoDao.deleteProducto(id);
		
	}

	@Override
	public List<Producto> findProductoByMarca(String marca) {
		return productoDao.findProductoByMarca(marca);
	}

	@Override
	public List<Producto> findProductoByTipo(String tipo) {
		return productoDao.findProductoByTipo(tipo);
	}

	@Override
	public List<Producto> findProductoByPrecio(double precio) {

		return productoDao.findProductoByPrecio(precio);
	}

	@Override
	public List<Producto> findAllProducto() {
		return productoDao.findAllProducto();
	}

	@Override
	public Producto findProductoByDescripcion(String descripcion) {
		return productoDao.findProductoByDescripcion(descripcion);
	}
	
}
