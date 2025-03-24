package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;

public class Cocina extends Hogar implements Serializable { // Declara la clase Cocina, que hereda de Hogar e implementa
															// Serializable

	private boolean resisteAltaTemperatuta; // Atributo que indica si el producto resiste altas temperaturas
	private boolean esPeligroso; // Atributo que indica si el producto es peligroso
	private HashSet<Integer> generatedCodes = new HashSet<>();
	public Cocina() {
		// Constructor vacío por defecto
	}

	public Cocina(boolean resisteAltaTemperatuta, boolean esPeligroso) {
		super(); // Llama al constructor de la clase padre (Hogar)
		this.resisteAltaTemperatuta = resisteAltaTemperatuta; // Asigna el valor al atributo resisteAltaTemperatuta
		this.esPeligroso = esPeligroso; // Asigna el valor al atributo esPeligroso
	}

	public Cocina(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion,
			boolean resisteAltaTemperatuta, boolean esPeligroso) {
		super(nombre, precio, id, fecha, imagen, esDecoracion); // Llama al constructor de la clase padre con los
																// parámetros
		this.resisteAltaTemperatuta = resisteAltaTemperatuta; // Asigna el valor al atributo resisteAltaTemperatuta
		this.esPeligroso = esPeligroso; // Asigna el valor al atributo esPeligroso
	}

	public Cocina(String nombre, int precio, int id, String fecha, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, fecha, imagen, esDecoracion); // Llama al constructor de la clase padre sin
																// resisteAltaTemperatuta ni esPeligroso
		// Constructor sin inicializar resisteAltaTemperatuta ni esPeligroso
	}

	public boolean isResisteAltaTemperatuta() {
		return resisteAltaTemperatuta; // Método getter que retorna si el producto resiste altas temperaturas
	}

	public void setResisteAltaTemperatuta(boolean resisteAltaTemperatuta) {
		this.resisteAltaTemperatuta = resisteAltaTemperatuta; // Método setter para modificar resisteAltaTemperatuta
	}

	public boolean isEsPeligroso() {
		return esPeligroso; // Método getter que retorna si el producto es peligroso
	}

	public void setEsPeligroso(boolean esPeligroso) {
		this.esPeligroso = esPeligroso; // Método setter para modificar esPeligroso
	}

	@Override
	public String toString() {
		return super.toString() + "\n¿Resiste altas temperaturas? " + resisteAltaTemperatuta + "\n¿Es peligroso? "
				+ esPeligroso+"\n";
		// Sobrescribe toString para incluir los atributos resisteAltaTemperatuta y
		// esPeligroso
	}
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
