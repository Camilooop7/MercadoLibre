package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;

/**
 * Clase que representa un baño, hereda de Hogar e implementa Serializable.
 */
public class Bano extends Hogar implements Serializable {

	/**
	 * Indica si el producto es de limpieza.
	 */
	private boolean esLimpieza;

	/**
	 * Conjunto para almacenar códigos generados aleatoriamente y evitar duplicados.
	 */
	private HashSet<Integer> generatedCodes = new HashSet<>();

	/**
	 * Constructor vacío por defecto.
	 */
	public Bano() {
		// Constructor vacío por defecto
	}

	/**
	 * Constructor que inicializa el atributo esLimpieza.
	 * 
	 * @param esLimpieza Indica si el producto es de limpieza.
	 */
	public Bano(boolean esLimpieza) {
		super(); // Llama al constructor de la clase padre (Hogar)
		this.esLimpieza = esLimpieza; // Asigna el valor al atributo esLimpieza
	}

	/**
	 * Constructor que inicializa todos los atributos, incluyendo esLimpieza.
	 * 
	 * @param nombre       Nombre del producto.
	 * @param precio       Precio del producto.
	 * @param id           Identificador del producto.
	 * @param fecha        Fecha asociada al producto.
	 * @param imagen       Imagen del producto.
	 * @param esDecoracion Indica si el producto es de decoración.
	 * @param esLimpieza   Indica si el producto es de limpieza.
	 */
	public Bano(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion,
			boolean esLimpieza) {
		super(nombre, precio, id, fecha, imagen, esDecoracion); // Llama al constructor de la clase padre con los
																// parámetros
		this.esLimpieza = esLimpieza; // Asigna el valor al atributo esLimpieza
	}

	/**
	 * Constructor que inicializa todos los atributos excepto esLimpieza.
	 * 
	 * @param nombre       Nombre del producto.
	 * @param precio       Precio del producto.
	 * @param id           Identificador del producto.
	 * @param fecha        Fecha asociada al producto.
	 * @param imagen       Imagen del producto.
	 * @param esDecoracion Indica si el producto es de decoración.
	 */
	public Bano(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, fecha, imagen, esDecoracion); // Llama al constructor de la clase padre sin
																	// esLimpieza
		// Constructor sin asignar esLimpieza
	}

	/**
	 * Obtiene el valor del atributo esLimpieza.
	 * 
	 * @return true si el producto es de limpieza, false en caso contrario.
	 */
	public boolean isEsLimpieza() {
		return esLimpieza; // Método getter que retorna si es de limpieza
	}

	/**
	 * Modifica el valor del atributo esLimpieza.
	 * 
	 * @param esLimpieza Nuevo valor para el atributo esLimpieza.
	 */
	public void setEsLimpieza(boolean esLimpieza) {
		this.esLimpieza = esLimpieza; // Método setter para modificar esLimpieza
	}

	/**
	 * Genera una representación en cadena del objeto, incluyendo el atributo
	 * esLimpieza.
	 * 
	 * @return Cadena que representa el objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n¿Es un producto de limpieza de limpieza?: " + (esLimpieza?"Si" : "No")+"\n"; // Sobrescribe toString para incluir el atributo
																	// esLimpieza
	}

	/**
	 * Genera un código aleatorio único en el rango de 2000 a 2999.
	 * 
	 * @return Código aleatorio generado.
	 */
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();
		
		 do {
	            codigo = random.nextInt((2999 - 2000 + 1)) + 2000;
	        } while (generatedCodes.contains(codigo));

	        generatedCodes.add(codigo);
	        return codigo;
	}
}

