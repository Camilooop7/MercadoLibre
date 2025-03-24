package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;

public class Bano extends Hogar implements Serializable { // Declara la clase Bano, que hereda de Hogar e implementa
															// Serializable
	private boolean esLimpieza; // Atributo booleano que indica si el producto es de limpieza
	private HashSet<Integer> generatedCodes = new HashSet<>();
	public Bano() {
		// Constructor vacío por defecto
	}

	public Bano(boolean esLimpieza) {
		super(); // Llama al constructor de la clase padre (Hogar)
		this.esLimpieza = esLimpieza; // Asigna el valor al atributo esLimpieza
	}

	public Bano(String nombre, int precio, int id, LocalDate fecha, String imagen, boolean esDecoracion,
			boolean esLimpieza) {
		super(nombre, precio, id, fecha, imagen, esDecoracion); // Llama al constructor de la clase padre con los
																// parámetros
		this.esLimpieza = esLimpieza; // Asigna el valor al atributo esLimpieza
	}

	public Bano(String nombre, int precio, int id, LocalDate fecha, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, fecha, imagen, esDecoracion); // Llama al constructor de la clase padre sin
																	// esLimpieza
		// Constructor sin asignar esLimpieza
	}

	public boolean isEsLimpieza() {
		return esLimpieza; // Método getter que retorna si es de limpieza
	}

	public void setEsLimpieza(boolean esLimpieza) {
		this.esLimpieza = esLimpieza; // Método setter para modificar esLimpieza
	}

	@Override
	public String toString() {
		return super.toString() + "\n¿Es de limpieza? " + esLimpieza; // Sobrescribe toString para incluir el atributo
																	// esLimpieza
	}
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
