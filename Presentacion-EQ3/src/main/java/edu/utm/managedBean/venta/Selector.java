
package edu.utm.managedBean.venta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import edu.utm.bd.domain.Cliente;
import edu.utm.bd.domain.Producto;
import edu.utm.bd.domain.Venta;

@ManagedBean
@ViewScoped
@Named
public class Selector implements Serializable {
	
    private static final long serialVersionUID = -1776353555799643520L;
    @Inject
    edu.utm.service.cliente.ClienteService clienteService;
    @Inject
    edu.utm.service.producto.ProductoService productoService;
    @Inject
    edu.utm.service.venta.VentaService ventaService;
    private List<SelectItem> clientes;
    private List<SelectItem> productos;
    private List<Producto> productoList;
    private List<Producto> infoVenta;
    private String selectedCliente;
    private String selectedProducto;
    private Integer cantidad;
    private Double total;
    
    /*Init code *****************************/
	
	
	private String descripcion;
	private String tipo;
	private String marca;
	private double precioCompra;
	private double precioVenta;
	
	
	
	public void deleteProducto(Producto producto){
		//invoca al servicio
		productoService.deleteProducto(producto.getIdProducto());
		
		//actualiza los valores de la tabla
		setProductoList(productoService.findAllProducto());
		getProductoList();
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Successful",  "Producto Eliminado") );
	}
	public void onRowEdit(RowEditEvent event){
		Producto producto = ((Producto) event.getObject());
		
		productoService.updateProducto(producto);
		
		FacesMessage msg = new FacesMessage("Successful","Producto "+producto.getIdProducto().toString()+" Actualizado ");
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
    /***********************************end code *************************************************************/

    /**
     * Default Constructor.
     */
    public Selector() {
    	clientes = new ArrayList<SelectItem>();
        productos = new ArrayList<SelectItem>();
        infoVenta = new ArrayList<Producto>();
        total=0.0;
    }
    @PostConstruct
    private void initialize() {
    	
    	List<Cliente> clienteList=clienteService.findAllClientes();
    	List<Producto> productoList=productoService.findAllProducto();
        for(Cliente c:clienteList){
			System.out.println("Id: "+c.getIdCliente());
			System.out.println("Nombre: "+c.getNombre());
			clientes.add(new SelectItem(c.getRfc()));
		}  
        for(Producto p:productoList){
			System.out.println("Id: "+p.getIdProducto());
			System.out.println("Marca: "+p.getMarca());
			productos.add(new SelectItem(p.getDescripcion()));
		}  
    }
    public String getSelectedProducto() {
        return selectedProducto;
    }
    public void setSelectedProducto(String selectedProducto) {
        this.selectedProducto = selectedProducto;
    }
    public List<SelectItem> getProductos() {
        return productos;
    }
    public String getSelectedCliente() {
        return selectedCliente;
    }
    public void setSelectedCliente(String selectedCliente) {
        this.selectedCliente = selectedCliente;
    }public List<SelectItem> getClientes() {
        return clientes;
    }public void stateChangeListener(ValueChangeEvent event) {
        if (event.getNewValue() != selectedCliente) {
            selectedProducto = null;
        }
    }
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public List<Producto> getInfoVenta(){	
		return infoVenta;
	}
	public List<Producto> setInfoVenta(){
		Producto producto=productoService.findProductoByDescripcion(selectedProducto);
		if(producto!=null){
			producto.setCantidad(cantidad);
			producto.setSubtotal(cantidad*producto.getPrecioVenta());
			total=total+producto.getSubtotal();
			System.out.println(producto.getIdProducto());
			System.out.println(producto.getDescripcion());
			System.out.println(producto.getTipo());
			infoVenta.add(producto);
		}
		System.out.println(crearUUID());
		System.out.println("Tamaño: "+ infoVenta.size());
		return infoVenta;
	}
	public Double getTotal() {
		return total;
	}
	public static Integer crearUUID() {
		return (int) (Math.random() * 2147483647) + 1;
	}
	
	public void createVenta(){	
		Integer numVenta=crearUUID();
		System.out.println("NumVenta= "+numVenta);
		Date date= new Date();
		System.out.println("Fecha= "+date);
		Cliente cliente=clienteService.findClienteByRFC(getSelectedCliente());
		System.out.println("Cliente= "+cliente);
		for(Producto p:getInfoVenta()){
			Producto producto=productoService.findProductoByDescripcion(p.getDescripcion());
			producto.setCantidad(producto.getCantidad()-p.getCantidad());
			Venta venta = new Venta();
			venta.setNumVenta(numVenta);
			venta.setIdCliente(cliente.getIdCliente());
			venta.setIdProducto(p.getIdProducto());
			venta.setFecha(date);
			venta.setCantidad(p.getCantidad());
			ventaService.registrarVenta(venta);
			System.out.println("Prueba exitosa de VentaServiceImplement");
			productoService.updateProducto(producto);
	   }
		actualizar();
		setProductoList(productoService.findAllProducto());
		getProductoList();
	}
	
	 public void actualizar() {
	        infoVenta = new ArrayList<Producto>();
	        this.cantidad=null;
	        this.selectedProducto=null;
	        this.selectedCliente=null;
	        total=0.0;
	    }
	public List<Producto> getProductoList() {
		if(productoList == null)
			setProductoList(productoService.findAllProducto());
		//System.out.println("Impresion desde el managedBean");
		return productoList;
	}
	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
	}

}
