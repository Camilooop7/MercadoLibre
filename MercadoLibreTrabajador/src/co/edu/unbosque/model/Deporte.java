package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;

public class Deporte extends Ocio implements Serializable { // Declara la clase Deporte, que hereda de Ocio e implementa
															// Serializable

	private String deporte; // Atributo que almacena el nombre del deporte relacionado con el producto
	private HashSet<Integer> generatedCodes = new HashSet<>();
	public Deporte() {
		// Constructor vacío por defecto
	}

	public Deporte(String deporte) {
		super(); // Llama al constructor de la clase padre (Ocio)
		this.deporte = deporte; // Asigna el valor al atributo deporte
	}

	public Deporte(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio,
			String deporte) {
		super(nombre, precio, id, fecha, imagen, esAccesorio); // Llama al constructor de la clase padre con los
																// parámetros
		this.deporte = deporte; // Asigna el valor al atributo deporte
	}

	public Deporte(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, fecha, imagen, esAccesorio); // Llama al constructor de la clase padre sin deporte
		// Constructor sin inicializar el atributo deporte
	}

	public String getDeporte() {
		return deporte; // Método getter que retorna el nombre del deporte
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte; // Método setter para modificar el nombre del deporte
	}

	@Override
	public String toString() {
		return super.toString() + "\nDeporte: " + deporte+"\n"; // Sobrescribe toString para incluir el atributo deporte
	}
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();
		
		 do {
	            codigo = random.nextInt((6999 - 6000 + 1)) + 6000;
	        } while (generatedCodes.contains(codigo));

	        generatedCodes.add(codigo);
	        return codigo;
	}
}
