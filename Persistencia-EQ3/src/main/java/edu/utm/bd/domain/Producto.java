package edu.utm.bd.domain;

public class Producto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.id_producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    private Integer idProducto;
    
    

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.SKU
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    private String descripcion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.tipo
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    private String tipo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.marca
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    private String marca;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.precio_compra
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    private Double precioCompra;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column producto.precio_venta
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    private Double precioVenta;
    private Integer cantidad;
    private Double subtotal;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.id_producto
     *
     * @return the value of producto.id_producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.id_producto
     *
     * @param idProducto the value for producto.id_producto
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.tipo
     *
     * @return the value of producto.tipo
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.tipo
     *
     * @param tipo the value for producto.tipo
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.marca
     *
     * @return the value of producto.marca
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public String getMarca() {
        return marca;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.marca
     *
     * @param marca the value for producto.marca
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.precio_compra
     *
     * @return the value of producto.precio_compra
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public Double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.precio_compra
     *
     * @param precioCompra the value for producto.precio_compra
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column producto.precio_venta
     *
     * @return the value of producto.precio_venta
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column producto.precio_venta
     *
     * @param precioVenta the value for producto.precio_venta
     *
     * @mbggenerated Wed Apr 25 18:12:03 CDT 2018
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}