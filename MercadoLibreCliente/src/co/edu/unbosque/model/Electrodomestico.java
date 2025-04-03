package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;

/**
 * Clase que representa electrodomésticos, hereda de Oficina.
 */
public class Electrodomestico extends Oficina implements Serializable {

	/**
	 * Fuente de energía del electrodoméstico (ej. electricidad, gas).
	 */
	private String fuenteDeEnergia;

	/**
	 * Conjunto para almacenar códigos generados aleatoriamente.
	 */
	private HashSet<Integer> generatedCodes = new HashSet<>();

	/**
	 * Constructor vacío.
	 */
	public Electrodomestico() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa la fuente de energía.
	 * 
	 * @param fuenteDeEnergia Fuente de energía del electrodoméstico.
	 */
	public Electrodomestico(String fuenteDeEnergia) {
		super();
		this.fuenteDeEnergia = fuenteDeEnergia;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre          Nombre del producto.
	 * @param precio          Precio del producto.
	 * @param id              Identificador único.
	 * @param fecha           Fecha de creación.
	 * @param imagen          Ruta de la imagen.
	 * @param esPortatil      Indica si es portátil.
	 * @param fuenteDeEnergia Fuente de energía del electrodoméstico.
	 */
	public Electrodomestico(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil,
			String fuenteDeEnergia) {
		super(nombre, precio, id, fecha, imagen, esPortatil);
		this.fuenteDeEnergia = fuenteDeEnergia;
	}

	/**
	 * Constructor que inicializa atributos excepto la fuente de energía.
	 * 
	 * @param nombre     Nombre del producto.
	 * @param precio     Precio del producto.
	 * @param id         Identificador único.
	 * @param fecha      Fecha de creación.
	 * @param imagen     Ruta de la imagen.
	 * @param esPortatil Indica si es portátil.
	 */
	public Electrodomestico(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil) {
		super(nombre, precio, id, fecha, imagen, esPortatil);
	}

	/**
	 * Obtiene la fuente de energía del electrodoméstico.
	 * 
	 * @return Fuente de energía del electrodoméstico.
	 */
	public String getFuenteDeEnergia() {
		return fuenteDeEnergia;
	}

	/**
	 * Establece la fuente de energía del electrodoméstico.
	 * 
	 * @param fuenteDeEnergia Nueva fuente de energía.
	 */
	public void setFuenteDeEnergia(String fuenteDeEnergia) {
		this.fuenteDeEnergia = fuenteDeEnergia;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\nFuente de energía: " + fuenteDeEnergia + "\n";
	}

	/**
	 * Genera un código aleatorio único entre 3000 y 3999.
	 * 
	 * @return Código aleatorio generado.
	 */
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();

		do {
			codigo = random.nextInt((3999 - 3000 + 1)) + 3000;
		} while (generatedCodes.contains(codigo));

		generatedCodes.add(codigo);
		return codigo;
	}
}
