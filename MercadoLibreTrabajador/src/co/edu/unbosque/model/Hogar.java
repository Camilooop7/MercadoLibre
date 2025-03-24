package co.edu.unbosque.model; 

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime; 

public abstract class Hogar extends Producto implements Serializable { // Clase abstracta Hogar que hereda de Producto e implementa Serializable

	private boolean esDecoracion; // Atributo que indica si el producto es de decoración

	public Hogar() { 
		// Constructor vacío por defecto
	}

	public Hogar(boolean esDecoracion) { 
		super(); // Llama al constructor de la clase padre (Producto)
		this.esDecoracion = esDecoracion; // Asigna el valor al atributo esDecoracion
	}

	public Hogar(String nombre, int precio, int id, LocalDateTime fecha, String imagen, boolean esDecoracion) { 
		super(nombre, precio, id, fecha, imagen); // Llama al constructor de la clase padre con parámetros
		this.esDecoracion = esDecoracion; // Asigna el valor al atributo esDecoracion
	}

	public Hogar(String nombre, int precio, int id, LocalDateTime fecha, String imagen) { 
		super(nombre, precio, id, fecha, imagen); // Llama al constructor de la clase padre sin esDecoracion
		// Constructor sin inicializar el atributo esDecoracion
	}

	public boolean isEsDecoracion() { 
		return esDecoracion; // Método getter que retorna si el producto es de decoración
	}

	public void setEsDecoracion(boolean esDecoracion) { 
		this.esDecoracion = esDecoracion; // Método setter para modificar si es de decoración
	}

	@Override
	public String toString() { 
		return super.toString() + "\n¿Es decoración? " + esDecoracion; 
		// Sobrescribe toString para incluir el atributo esDecoracion
	}

}

