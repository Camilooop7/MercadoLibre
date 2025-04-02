package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * Clase abstracta que representa productos de oficina, hereda de Producto.
 */
public abstract class Oficina extends Producto implements Serializable {

	/**
	 * Indica si el producto es portátil.
	 */
	private boolean esPortatil;

	/**
	 * Constructor vacío.
	 */
	public Oficina() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa el atributo esPortatil.
	 * 
	 * @param esPortatil Indica si el producto es portátil.
	 */
	public Oficina(boolean esPortatil) {
		super();
		this.esPortatil = esPortatil;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre     Nombre del producto.
	 * @param precio     Precio del producto.
	 * @param id         Identificador único.
	 * @param fecha      Fecha de creación.
	 * @param imagen     Ruta de la imagen.
	 * @param esPortatil Indica si el producto es portátil.
	 */
	public Oficina(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil) {
		super(nombre, precio, id, fecha, imagen);
		this.esPortatil = esPortatil;
	}

	/**
	 * Constructor que inicializa atributos excepto esPortatil.
	 * 
	 * @param nombre Nombre del producto.
	 * @param precio Precio del producto.
	 * @param id     Identificador único.
	 * @param fecha  Fecha de creación.
	 * @param imagen Ruta de la imagen.
	 */
	public Oficina(String nombre, int precio, int id, String fecha, String imagen) {
		super(nombre, precio, id, fecha, imagen);
	}

	/**
	 * Obtiene si el producto es portátil.
	 * 
	 * @return true si es portátil, false en caso contrario.
	 */
	public boolean isEsPortatil() {
		return esPortatil;
	}

	/**
	 * Establece si el producto es portátil.
	 * 
	 * @param esPortatil Nuevo valor para el atributo esPortatil.
	 */
	public void setEsPortatil(boolean esPortatil) {
		this.esPortatil = esPortatil;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n¿Es portátil? " + (esPortatil ? "Si" : "No");
	}
}
