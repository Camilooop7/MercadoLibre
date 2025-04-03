package co.edu.unbosque.model;

import java.io.Serializable; 
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * Clase abstracta que representa un producto. Implementa la interfaz Serializable.
 */
public abstract class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	/** Nombre del producto. */
	private String nombre;

	/** Precio del producto. */
	private int precio;

	/** Identificador único del producto. */
	private int id;

	/** Fecha asociada al producto. */
	private String fecha;

	/** Ruta de la imagen del producto. */
	private String imagen;

	/**
	 * Constructor vacío de la clase Producto.
	 */
	public Producto() {
		// Constructor vacío
	}

	/**
	 * Constructor con parámetros para inicializar un producto.
	 * 
	 * @param nombre Nombre del producto.
	 * @param precio Precio del producto.
	 * @param id Identificador único del producto.
	 * @param fecha Fecha asociada al producto.
	 * @param imagen Ruta de la imagen del producto.
	 */
	public Producto(String nombre, int precio, int id, String fecha, String imagen) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.fecha = fecha;
		this.imagen = imagen;
	}

	/**
	 * Obtiene el nombre del producto.
	 * 
	 * @return Nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del producto.
	 * 
	 * @param nombre Nuevo nombre del producto.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el precio del producto.
	 * 
	 * @return Precio del producto.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio del producto.
	 * 
	 * @param precio Nuevo precio del producto.
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene el identificador único del producto.
	 * 
	 * @return Identificador único del producto.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador único del producto.
	 * 
	 * @param id Nuevo identificador único del producto.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene la ruta de la imagen del producto.
	 * 
	 * @return Ruta de la imagen del producto.
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Modifica la ruta de la imagen del producto.
	 * 
	 * @param imagen Nueva ruta de la imagen del producto.
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene la fecha asociada al producto.
	 * 
	 * @return Fecha asociada al producto.
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha asociada al producto.
	 * 
	 * @param fecha Nueva fecha asociada al producto.
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Representa el objeto Producto como una cadena de texto.
	 * 
	 * @return Cadena de texto que representa el producto.
	 */
	@Override
	public String toString() { // Método para representar el objeto como cadena
		return "Nombre: " + nombre + "\nPrecio: $" + precio + "\nID: " + id + "\nFecha: " + fecha;
	}
}
