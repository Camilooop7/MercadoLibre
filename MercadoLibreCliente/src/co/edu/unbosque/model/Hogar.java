package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa productos del hogar, hereda de Producto.
 */
public abstract class Hogar extends Producto implements Serializable {
	private static final long serialVersionUID = 1L;		
	/**
	 * Indica si el producto es de decoración.
	 */
	private boolean esDecoracion;

	/**
	 * Constructor vacío.
	 */
	public Hogar() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa el atributo esDecoracion.
	 * 
	 * @param esDecoracion Indica si el producto es de decoración.
	 */
	public Hogar(boolean esDecoracion) {
		super();
		this.esDecoracion = esDecoracion;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre        Nombre del producto.
	 * @param precio        Precio del producto.
	 * @param id            Identificador único.
	 * @param fecha         Fecha de creación.
	 * @param imagen        Ruta de la imagen.
	 * @param esDecoracion  Indica si el producto es de decoración.
	 */
	public Hogar(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, fecha, imagen);
		this.esDecoracion = esDecoracion;
	}

	/**
	 * Constructor que inicializa atributos excepto esDecoracion.
	 * 
	 * @param nombre Nombre del producto.
	 * @param precio Precio del producto.
	 * @param id     Identificador único.
	 * @param fecha  Fecha de creación.
	 * @param imagen Ruta de la imagen.
	 */
	public Hogar(String nombre, int precio, int id, String fecha, String imagen) {
		super(nombre, precio, id, fecha, imagen);
	}

	/**
	 * Obtiene si el producto es de decoración.
	 * 
	 * @return true si es de decoración, false en caso contrario.
	 */
	public boolean isEsDecoracion() {
		return esDecoracion;
	}

	/**
	 * Establece si el producto es de decoración.
	 * 
	 * @param esDecoracion Nuevo valor para el atributo esDecoracion.
	 */
	public void setEsDecoracion(boolean esDecoracion) {
		this.esDecoracion = esDecoracion;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n¿Es decorativo? " + (esDecoracion ? "Si" : "No");
	}
}

