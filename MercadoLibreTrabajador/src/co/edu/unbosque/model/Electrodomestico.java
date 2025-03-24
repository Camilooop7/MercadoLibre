package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;

public class Electrodomestico extends Oficina implements Serializable { // Declara la clase Electrodomestico, que hereda
																		// de Oficina e implementa Serializable

	private String fuenteDeEnergia; // Atributo que almacena la fuente de energía del electrodoméstico (ej.
									// electricidad, gas)
	private HashSet<Integer> generatedCodes = new HashSet<>();
	public Electrodomestico() {
		// Constructor vacío por defecto
	}

	public Electrodomestico(String fuenteDeEnergia) {
		super(); // Llama al constructor de la clase padre (Oficina)
		this.fuenteDeEnergia = fuenteDeEnergia; // Asigna el valor al atributo fuenteDeEnergia
	}

	public Electrodomestico(String nombre, int precio, int id, LocalDate fecha, String imagen, boolean esPortatil,
			String fuenteDeEnergia) {
		super(nombre, precio, id, fecha, imagen, esPortatil); // Llama al constructor de la clase padre con los
																// parámetros
		this.fuenteDeEnergia = fuenteDeEnergia; // Asigna el valor al atributo fuenteDeEnergia
	}

	public Electrodomestico(String nombre, int precio, int id, LocalDate fecha, String imagen, boolean esPortatil) {
		super(nombre, precio, id, fecha, imagen, esPortatil); // Llama al constructor de la clase padre sin
																// fuenteDeEnergia
		// Constructor sin inicializar el atributo fuenteDeEnergia
	}

	public String getFuenteDeEnergia() {
		return fuenteDeEnergia; // Método getter que retorna la fuente de energía
	}

	public void setFuenteDeEnergia(String fuenteDeEnergia) {
		this.fuenteDeEnergia = fuenteDeEnergia; // Método setter para modificar la fuente de energía
	}

	@Override
	public String toString() {
		return super.toString() + "\n¿Qué fuente de energía tiene? " + fuenteDeEnergia+"\n";
		// Sobrescribe toString para incluir el atributo fuenteDeEnergia
	}
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
