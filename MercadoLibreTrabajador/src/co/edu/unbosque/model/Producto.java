package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Producto implements Serializable{
	private String nombre;
	private int precio;
	private int id;
	private int cantidad;
	private String imagen;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, int precio, int id, int cantidad, String imagen) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.cantidad = cantidad;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "Precio: " + precio + "ID: " + id + "Cantidad: " + cantidad + "Imagen: " + imagen;
	}

}
