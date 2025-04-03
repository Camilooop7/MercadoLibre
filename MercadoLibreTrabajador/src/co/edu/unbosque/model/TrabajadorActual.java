package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representa un TrabajadorActual e implementa la interfaz Serializable.
 */

public class TrabajadorActual implements Serializable{
	 /**
     * nombre asociada al TrabajadorActual.
     */
	private String nombre;
	 /**
     * Fecha asociada al TrabajadorActual.
     */
   
    private LocalDateTime fecha;
    /**
     * Producto asociado al TrabajadorActual.
     */
    private String producto; 
    
    /**
     * Constructor por defecto.
     */
    
    public TrabajadorActual() {
		// TODO Auto-generated constructor stub
	}
 /**
  * Constructor que inicializa el nombre, la fecha y el producto.
  * 
  * @param nombre nombre asociada al TrabajadorActual
   * @param fecha    Fecha asociada al TrabajadorActual.
    * @param producto Producto asociado al TrabajadorActual.
  */


	public TrabajadorActual(String nombre, LocalDateTime fecha, String producto) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.producto = producto;
	}
	/**
     * Obtiene el nombre asociada al TrabajadorActual.
     * 
     * @return nombre asociada al TrabajadorActual.
     */
	public String getNombre() {
		return nombre;
	}
	/**
     * Establece el nombre asociada al TrabajadorActual.
     * 
     * @param nombre Nueva fecha asociada al TrabajadorActual.
     */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * Obtiene la fecha asociada al TrabajadorActual.
     * 
     * @return Fecha asociada al TrabajadorActual.
     */

	public LocalDateTime getFecha() {
		return fecha;
	}
	
	/**
     * Establece la fecha asociada al TrabajadorActual.
     * 
     * @param fecha Nueva fecha asociada al TrabajadorActual.
     */

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	/**
     * Obtiene el producto asociado al TrabajadorActual.
     * 
     * @return Producto asociado al TrabajadorActual.
     */

	public String getProducto() {
		return producto;
	}
	/**
     * Establece el producto asociado al TrabajadorActual.
     * 
     * @param producto Nuevo producto asociado al TrabajadorActual.
     */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
     * Devuelve una representación en cadena del objeto TrabajadorActual.
     *
     * @return una cadena que representa al TrabajadorActual.
     */
	@Override
	public String toString() {
		return "TrabajadorActual [nombre=" + nombre + ", fecha=" + fecha + ", producto=" + producto + "]";
	}
    
}
