package co.edu.unbosque.model;

import java.io.Serializable; 

public class Bano extends Hogar implements Serializable { // Declara la clase Bano, que hereda de Hogar e implementa Serializable
	private boolean esLimpieza; // Atributo booleano que indica si el producto es de limpieza

	public Bano() { 
		// Constructor vacío por defecto
	}

	public Bano(boolean esLimpieza) { 
		super(); // Llama al constructor de la clase padre (Hogar)
		this.esLimpieza = esLimpieza; // Asigna el valor al atributo esLimpieza
	}

	public Bano(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion,
			boolean esLimpieza) { 
		super(nombre, precio, id, cantidad, imagen, esDecoracion); // Llama al constructor de la clase padre con los parámetros
		this.esLimpieza = esLimpieza; // Asigna el valor al atributo esLimpieza
	}

	public Bano(String nombre, int precio, int id, int cantidad, String imagen, boolean esDecoracion) {
		super(nombre, precio, id, cantidad, imagen, esDecoracion); // Llama al constructor de la clase padre sin esLimpieza
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
		return super.toString() + "¿Es de limpieza? " + esLimpieza; // Sobrescribe toString para incluir el atributo esLimpieza
	}

}
