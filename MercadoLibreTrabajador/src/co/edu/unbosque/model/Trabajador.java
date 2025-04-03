package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representa un trabajador que extiende de la clase Usuario e implementa la interfaz Serializable.
 */
public class Trabajador extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	 /**
     * Fecha asociada al trabajador.
     */
   
    private LocalDateTime fecha;
    /**
     * Producto asociado al trabajador.
     */
    private String producto; 
    
    /**
     * Constructor por defecto.
     */
    public Trabajador() {
      
    }
    /**
     * Constructor que inicializa la fecha y el producto.
     * 
     * @param fecha    Fecha asociada al trabajador.
     * @param producto Producto asociado al trabajador.
     */

    public Trabajador(LocalDateTime fecha, String producto) {
    	super();
    	this.fecha = fecha;
    	this.producto = producto;
    }
    
    /**
     * Constructor que inicializa el nombre, la contraseña, la fecha y el producto.
     * 
     * @param nombre    Nombre del trabajador.
     * @param contrasena Contraseña del trabajador.
     * @param fecha      Fecha asociada al trabajador.
     * @param producto   Producto asociado al trabajador.
     */
    
	public Trabajador(String nombre, String contrasena, LocalDateTime fecha, String producto) {
		super(nombre, contrasena);
		this.fecha = fecha;
		this.producto = producto;
	}

	/**
     * Constructor que inicializa el nombre y la contraseña.
     * 
     * @param nombre    Nombre del trabajador.
     * @param contrasena Contraseña del trabajador.
     */
	public Trabajador(String nombre, String contrasena) {
		super(nombre, contrasena);
	}
	
	/**
     * Obtiene la fecha asociada al trabajador.
     * 
     * @return Fecha asociada al trabajador.
     */

	public LocalDateTime getFecha() {
		return fecha;
	}
	
	/**
     * Establece la fecha asociada al trabajador.
     * 
     * @param fecha Nueva fecha asociada al trabajador.
     */

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	/**
     * Obtiene el producto asociado al trabajador.
     * 
     * @return Producto asociado al trabajador.
     */

	public String getProducto() {
		return producto;
	}
	/**
     * Establece el producto asociado al trabajador.
     * 
     * @param producto Nuevo producto asociado al trabajador.
     */

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
}

