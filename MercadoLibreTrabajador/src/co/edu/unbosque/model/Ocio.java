package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase abstracta que representa productos de ocio, hereda de Producto.
 */
public abstract class Ocio extends Producto implements Serializable {

	/**
	 * Indica si el producto es un accesorio.
	 */
	private boolean esAccesorio;

	/**
	 * Constructor vacío.
	 */
	public Ocio() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa el atributo esAccesorio.
	 * 
	 * @param esAccesorio Indica si el producto es un accesorio.
	 */
	public Ocio(boolean esAccesorio) {
		super();
		this.esAccesorio = esAccesorio;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre      Nombre del producto.
	 * @param precio      Precio del producto.
	 * @param id          Identificador único.
	 * @param fecha       Fecha de creación.
	 * @param imagen      Ruta de la imagen.
	 * @param esAccesorio Indica si el producto es un accesorio.
	 */
	public Ocio(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, fecha, imagen);
		this.esAccesorio = esAccesorio;
	}

	/**
	 * Constructor que inicializa atributos excepto esAccesorio.
	 * 
	 * @param nombre Nombre del producto.
	 * @param precio Precio del producto.
	 * @param id     Identificador único.
	 * @param fecha  Fecha de creación.
	 * @param imagen Ruta de la imagen.
	 */
	public Ocio(String nombre, int precio, int id, String fecha, String imagen) {
		super(nombre, precio, id, fecha, imagen);
	}

	/**
	 * Obtiene si el producto es un accesorio.
	 * 
	 * @return true si es un accesorio, false en caso contrario.
	 */
	public boolean isEsAccesorio() {
		return esAccesorio;
	}

	/**
	 * Establece si el producto es un accesorio.
	 * 
	 * @param esAccesorio Nuevo valor para el atributo esAccesorio.
	 */
	public void setEsAccesorio(boolean esAccesorio) {
		this.esAccesorio = esAccesorio;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n¿Es accesorio? " + (esAccesorio ? "Si" : "No");
	}
}
