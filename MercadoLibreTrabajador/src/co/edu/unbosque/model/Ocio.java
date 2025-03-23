package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Ocio extends Producto implements Serializable { // Declara la clase Ocio como abstracta y hereda
																		// de Producto

	private boolean esAccesorio; // Atributo que indica si el producto es un accesorio

	public Ocio() { // Constructor vacío
		// TODO Auto-generated constructor stub
	}

	public Ocio(boolean esAccesorio) { // Constructor que recibe esAccesorio
		super(); // Llama al constructor de la clase padre
		this.esAccesorio = esAccesorio; // Asigna el valor recibido
	}

	public Ocio(String nombre, int precio, int id, LocalDate fecha, String imagen, boolean esAccesorio) {
		super(nombre, precio, id, fecha, imagen); // Llama al constructor de Producto
		this.esAccesorio = esAccesorio; // Asigna el valor recibido
	}

	public Ocio(String nombre, int precio, int id, LocalDate fecha, String imagen) {
		super(nombre, precio, id, fecha, imagen); // Llama al constructor de Producto
		// TODO Auto-generated constructor stub
	}

	public boolean isEsAccesorio() { // Método para obtener esAccesorio
		return esAccesorio; // Retorna el valor de esAccesorio
	}

	public void setEsAccesorio(boolean esAccesorio) { // Método para modificar esAccesorio
		this.esAccesorio = esAccesorio; // Asigna el nuevo valor
	}

	@Override
	public String toString() { // Método para representar el objeto como cadena
		return super.toString() + "¿Es accesorio? " + esAccesorio; // Retorna la información del objeto
	}
}
