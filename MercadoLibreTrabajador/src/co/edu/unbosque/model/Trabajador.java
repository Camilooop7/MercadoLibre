package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/** 
 * Clase Trabajador que extiende de Usuario e implementa Serializable.
 */
public class Trabajador extends Usuario implements Serializable{

    /** Lista de productos añadidos por el trabajador */
   
    private LocalDateTime fecha;
    private String producto; 
    /** Constructor por defecto */
    public Trabajador() {
      
    }

    public Trabajador(LocalDateTime fecha, String producto) {
    	super();
    	this.fecha = fecha;
    	this.producto = producto;
    }

	public Trabajador(String nombre, String contrasena, LocalDateTime fecha, String producto) {
		super(nombre, contrasena);
		this.fecha = fecha;
		this.producto = producto;
	}

	public Trabajador(String nombre, String contrasena) {
		super(nombre, contrasena);
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
}

