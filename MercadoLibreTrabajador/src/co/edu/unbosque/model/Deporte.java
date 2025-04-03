package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
/**
 * Clase que representa productos relacionados con deportes, hereda de Ocio.
 */
public class Deporte extends Ocio implements Serializable {

	/**
	 * Nombre del deporte relacionado con el producto.
	 */
	private String deporte;

<<<<<<< HEAD
	private String deporte; // Atributo que almacena el nombre del deporte relacionado con el producto
	private HashSet<Integer> code = new HashSet<>();
=======
	/**
	 * Conjunto para almacenar códigos generados aleatoriamente.
	 */
	private HashSet<Integer> generatedCodes = new HashSet<>();

	/**
	 * Constructor vacío.
	 */
>>>>>>> 3e13f7f58cc1d969f274bd76850382e5724d1015
	public Deporte() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa el nombre del deporte.
	 * 
	 * @param deporte Nombre del deporte relacionado con el producto.
	 */
	public Deporte(String deporte) {
		super();
		this.deporte = deporte;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre      Nombre del producto.
	 * @param precio      Precio del producto.
	 * @param id          Identificador único.
	 * @param fecha       Fecha de creación.
	 * @param imagen      Ruta de la imagen.
	 * @param esAccesorio Indica si es un accesorio.
	 * @param deporte     Nombre del deporte relacionado con el producto.
	 */
	public Deporte(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio, String deporte) {
		super(nombre, precio, id, fecha, imagen, esAccesorio);
		this.deporte = deporte;
	}

	/**
	 * Constructor que inicializa atributos excepto el nombre del deporte.
	 * 
	 * @param nombre      Nombre del producto.
	 * @param precio      Precio del producto.
	 * @param id          Identificador único.
	 * @param fecha       Fecha de creación.
	 * @param imagen      Ruta de la imagen.
	 * @param esAccesorio Indica si es un accesorio.
	 */
	public Deporte(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, fecha, imagen, esAccesorio);
	}

	/**
	 * Obtiene el nombre del deporte relacionado con el producto.
	 * 
	 * @return Nombre del deporte.
	 */
	public String getDeporte() {
		return deporte;
	}

	/**
	 * Establece el nombre del deporte relacionado con el producto.
	 * 
	 * @param deporte Nuevo nombre del deporte.
	 */
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\nDeporte: " + deporte + "\n";
	}

	/**
	 * Genera un código aleatorio único entre 6000 y 6999.
	 * 
	 * @return Código aleatorio generado.
	 */
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();
<<<<<<< HEAD
		
		 do {
	            codigo = random.nextInt((6999 - 6000 + 1)) + 6000;
	        } while (code.contains(codigo));

	        code.add(codigo);
	        return codigo;
=======

		do {
			codigo = random.nextInt((6999 - 6000 + 1)) + 6000;
		} while (generatedCodes.contains(codigo));

		generatedCodes.add(codigo);
		return codigo;
>>>>>>> 3e13f7f58cc1d969f274bd76850382e5724d1015
	}
}
