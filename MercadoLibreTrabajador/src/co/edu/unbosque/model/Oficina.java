package co.edu.unbosque.model;

import java.io.Serializable; 

public abstract class Oficina extends Producto implements Serializable { // Declara la clase abstracta Oficina que hereda de Producto

	private boolean esPortatil; // Atributo que indica si el producto es portátil

	public Oficina() { // Constructor vacío
		// TODO Auto-generated constructor stub
	}

	public Oficina(boolean esPortatil) { // Constructor que recibe esPortatil
		super(); // Llama al constructor de la clase padre
		this.esPortatil = esPortatil; // Asigna el valor recibido
	}

	public Oficina(String nombre, int precio, int id, int cantidad, String imagen, boolean esPortatil) { 
		super(nombre, precio, id, cantidad, imagen); // Llama al constructor de Producto
		this.esPortatil = esPortatil; // Asigna el valor recibido
	}

	public Oficina(String nombre, int precio, int id, int cantidad, String imagen) { 
		super(nombre, precio, id, cantidad, imagen); // Llama al constructor de Producto
		// TODO Auto-generated constructor stub
	}

	public boolean isEsPortatil() { // Método para obtener esPortatil
		return esPortatil; // Retorna el valor de esPortatil
	}

	public void setEsPortatil(boolean esPortatil) { // Método para modificar esPortatil
		this.esPortatil = esPortatil; // Asigna el nuevo valor
	}

	@Override
	public String toString() { // Método para representar el objeto como cadena
		return super.toString() + "¿Es portatil? " + esPortatil; // Retorna la información del objeto
	}
}

