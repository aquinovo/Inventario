package edu.utm.managedBean.producto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import edu.utm.bd.domain.Producto;
@Named
public class ProductoBean {
	@Inject
	edu.utm.service.producto.ProductoService productoService;
	private List<Producto> productoList;
	private String descripcion;
	private String tipo;
	private String marca;
	private double precioCompra;
	private double precioVenta;
	private int cantidad;
	
	public List<Producto> getProductoList(){
		if(productoList == null)
			setProductoList(productoService.findAllProducto());
		//System.out.println("Impresion desde el managedBean");
		return productoList;
		//return clienteService.findAllClientes();
		
	}
	
	public void setProductoList(List<Producto> productoList) {
		// TODO Auto-generated method stub
		this.productoList = productoList;
		
	}
	public void deleteProducto(Producto producto){
		//invoca al servicio
		productoService.deleteProducto(producto.getIdProducto());
		
		//actualiza los valores de la tabla
		setProductoList(productoService.findAllProducto());
		getProductoList();
	}
	public void onRowEdit(RowEditEvent event){
		Producto producto = ((Producto) event.getObject());
		System.out.println("datos producto"+producto.getIdProducto());
		
		productoService.updateProducto(producto);
		
		FacesMessage msg = new FacesMessage("Producto editado",producto.getIdProducto().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		
	}
	
	public void onRowCancel(RowEditEvent event){
		Producto producto = ((Producto) event.getObject());
		FacesMessage msg = new FacesMessage("Edicion Cancelada", producto.getIdProducto().toString());
		FacesContext.getCurrentInstance().addMessage(null,msg);
		
		
		
	}
	
	public void onCellEdit(CellEditEvent event){
		
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		System.out.print("verifica: "+newValue);
		
		if(newValue != null && !newValue.equals(oldValue)){
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Producto modificado",
					"Antes: "+ oldValue + ", Ahora:"+newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void createProducto() {
		
		System.out.println("Tipo: " + tipo );
		System.out.println("Marca: " + marca);
		System.out.println("PrecioCompra: " + precioVenta);
		System.out.println("PrecioVenta: " + precioCompra);
		System.out.println("Cantidad: " + cantidad);
		System.out.println("Descripcion: " + descripcion);

		
		Producto producto = new Producto();
		producto.setDescripcion(descripcion);
		producto.setTipo(tipo);
		producto.setMarca(marca);
		producto.setPrecioCompra(precioCompra);
		producto.setPrecioVenta(precioVenta);
		producto.setCantidad(cantidad);
		
		productoService.insertProducto(producto);
		setProductoList(productoService.findAllProducto());
		getProductoList();
		//System.out.print("Insercion de producto"+getDescripcion());
		
		this.tipo = null;
        this.marca = null;
        this.precioCompra = 0.0;
        this.precioVenta = 0.0;
        this.cantidad = 0;
        this.descripcion = null;
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto Registrado"));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Producto Registrado") );
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
		
	}
}
