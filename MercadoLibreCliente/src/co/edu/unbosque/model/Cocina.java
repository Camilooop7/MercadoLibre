package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;

/**
 * Clase que representa productos de cocina, hereda de Hogar.
 */
public class Cocina extends Hogar implements Serializable {

	/**
	 * Indica si el producto resiste altas temperaturas.
	 */
	private boolean resisteAltaTemperatuta;

	/**
	 * Indica si el producto es peligroso.
	 */
	private boolean esPeligroso;

	/**
	 * Conjunto para almacenar códigos generados aleatoriamente.
	 */
	private HashSet<Integer> generatedCodes = new HashSet<>();

	/**
	 * Constructor vacío.
	 */
	public Cocina() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa los atributos resisteAltaTemperatuta y esPeligroso.
	 * 
	 * @param resisteAltaTemperatuta Indica si el producto resiste altas temperaturas.
	 * @param esPeligroso            Indica si el producto es peligroso.
	 */
	public Cocina(boolean resisteAltaTemperatuta, boolean esPeligroso) {
		super();
		this.resisteAltaTemperatuta = resisteAltaTemperatuta;
		this.esPeligroso = esPeligroso;
	}

	/**
	 * Constructor que inicializa todos los atributos.
	 * 
	 * @param nombre                 Nombre del producto.
	 * @param precio                 Precio del producto.
	 * @param id                     Identificador único.
	 * @param fecha                  Fecha de creación.
	 * @param imagen                 Ruta de la imagen.
	 * @param esDecoracion           Indica si es decorativo.
	 * @param resisteAltaTemperatuta Indica si resiste altas temperaturas.
	 * @param esPeligroso            Indica si es peligroso.
	 */
	public Cocina(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion,
			boolean resisteAltaTemperatuta, boolean esPeligroso) {
		super(nombre, precio, id, fecha, imagen, esDecoracion);
		this.resisteAltaTemperatuta = resisteAltaTemperatuta;
		this.esPeligroso = esPeligroso;
	}

	/**
	 * Constructor que inicializa atributos excepto resisteAltaTemperatuta y esPeligroso.
	 * 
	 * @param nombre       Nombre del producto.
	 * @param precio       Precio del producto.
	 * @param id           Identificador único.
	 * @param fecha        Fecha de creación.
	 * @param imagen       Ruta de la imagen.
	 * @param esDecoracion Indica si es decorativo.
	 */
	public Cocina(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, fecha, imagen, esDecoracion);
	}

	/**
	 * Obtiene si el producto resiste altas temperaturas.
	 * 
	 * @return true si resiste altas temperaturas, false en caso contrario.
	 */
	public boolean isResisteAltaTemperatuta() {
		return resisteAltaTemperatuta;
	}

	/**
	 * Establece si el producto resiste altas temperaturas.
	 * 
	 * @param resisteAltaTemperatuta Nuevo valor para el atributo.
	 */
	public void setResisteAltaTemperatuta(boolean resisteAltaTemperatuta) {
		this.resisteAltaTemperatuta = resisteAltaTemperatuta;
	}

	/**
	 * Obtiene si el producto es peligroso.
	 * 
	 * @return true si es peligroso, false en caso contrario.
	 */
	public boolean isEsPeligroso() {
		return esPeligroso;
	}

	/**
	 * Establece si el producto es peligroso.
	 * 
	 * @param esPeligroso Nuevo valor para el atributo.
	 */
	public void setEsPeligroso(boolean esPeligroso) {
		this.esPeligroso = esPeligroso;
	}

	/**
	 * Representa el objeto como una cadena de texto.
	 * 
	 * @return Cadena con la información del objeto.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "\n¿Resiste altas temperaturas? " + (resisteAltaTemperatuta ? "Si" : "No")
				+ "\n" + "\n¿Es peligroso? " + (esPeligroso ? "Si" : "No") + "\n";
	}

	/**
	 * Genera un código aleatorio único entre 1000 y 1999.
	 * 
	 * @return Código aleatorio generado.
	 */
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();

		do {
			codigo = random.nextInt((1999 - 1000 + 1)) + 1000;
		} while (generatedCodes.contains(codigo));

		generatedCodes.add(codigo);
		return codigo;
	}
}
