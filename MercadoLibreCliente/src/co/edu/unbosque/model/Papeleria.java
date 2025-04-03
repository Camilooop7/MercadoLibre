package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;

/**
 * Clase que representa productos de papelería, hereda de Oficina.
 */
public class Papeleria extends Oficina implements Serializable {

	/**
	 * Cantidad de productos por paquete.
	 */
	private int cantidadPorPaquete;

	/**
	 * Conjunto para almacenar códigos generados aleatoriamente.
	 */
	private HashSet<Integer> generatedCodes = new HashSet<>();

	/**
	 * Constructor vacío.
	 */
	public Papeleria() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa la cantidad por paquete.
	 * 
	 * @param cantidadPorPaquete Cantidad de productos por paquete.
	 */
	public Papeleria(int cantidadPorPaquete) {
		super();
		this.cantidadPorPaquete = cantidadPorPaquete;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre             Nombre del producto.
	 * @param precio             Precio del producto.
	 * @param id                 Identificador único.
	 * @param fecha              Fecha de creación.
	 * @param imagen             Ruta de la imagen.
	 * @param esPortatil         Indica si es portátil.
	 * @param cantidadPorPaquete Cantidad de productos por paquete.
	 */
	public Papeleria(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil,
			int cantidadPorPaquete) {
		super(nombre, precio, id, fecha, imagen, esPortatil);
		this.cantidadPorPaquete = cantidadPorPaquete;
	}

	/**
	 * Constructor que inicializa atributos excepto la cantidad por paquete.
	 * 
	 * @param nombre     Nombre del producto.
	 * @param precio     Precio del producto.
	 * @param id         Identificador único.
	 * @param fecha      Fecha de creación.
	 * @param imagen     Ruta de la imagen.
	 * @param esPortatil Indica si es portátil.
	 */
	public Papeleria(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil) {
		super(nombre, precio, id, fecha, imagen, esPortatil);
	}

	/**
	 * Obtiene la cantidad de productos por paquete.
	 * 
	 * @return Cantidad de productos por paquete.
	 */
	public int getCantidadPorPaquete() {
		return cantidadPorPaquete;
	}

	/**
	 * Establece la cantidad de productos por paquete.
	 * 
	 * @param cantidadPorPaquete Nueva cantidad de productos por paquete.
	 */
	public void setCantidadPorPaquete(int cantidadPorPaquete) {
		this.cantidadPorPaquete = cantidadPorPaquete;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\nUnidades por paquete: " + cantidadPorPaquete + "\n";
	}

	/**
	 * Genera un código aleatorio único entre 4000 y 4999.
	 * 
	 * @return Código aleatorio generado.
	 */
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();

		do {
			codigo = random.nextInt((4999 - 4000 + 1)) + 4000;
		} while (generatedCodes.contains(codigo));

		generatedCodes.add(codigo);
		return codigo;
	}
}
