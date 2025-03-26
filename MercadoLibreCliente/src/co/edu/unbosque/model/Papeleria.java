package co.edu.unbosque.model;

import java.io.Serializable; // Importa la interfaz Serializable
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;

public class Papeleria extends Oficina implements Serializable { // Declara la clase Papeleria que hereda de Oficina

	private int cantidadPorPaquete; // Atributo que indica la cantidad de productos por paquete
	private HashSet<Integer> generatedCodes = new HashSet<>();
	public Papeleria() { // Constructor vacío
		// TODO Auto-generated constructor stub
	}

	public Papeleria(int cantidadPorPaquete) { // Constructor que recibe cantidadPorPaquete
		super(); // Llama al constructor de la clase padre
		this.cantidadPorPaquete = cantidadPorPaquete; // Asigna el valor recibido
	}

	public Papeleria(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil,
			int cantidadPorPaquete) { // Constructor que recibe todos los atributos
		super(nombre, precio, id, fecha, imagen, esPortatil); // Llama al constructor de la clase padre
		this.cantidadPorPaquete = cantidadPorPaquete; // Asigna el valor recibido
	}

	public Papeleria(String nombre, int precio, int id, String fecha, String imagen, boolean esPortatil) {
		super(nombre, precio, id, fecha, imagen, esPortatil); // Llama al constructor de la clase padre
		// TODO Auto-generated constructor stub
	}

	public int getCantidadPorPaquete() { // Método para obtener cantidadPorPaquete
		return cantidadPorPaquete; // Retorna el valor de cantidadPorPaquete
	}

	public void setCantidadPorPaquete(int cantidadPorPaquete) { // Método para modificar cantidadPorPaquete
		this.cantidadPorPaquete = cantidadPorPaquete; // Asigna el nuevo valor
	}

	@Override
	public String toString() { // Método para representar el objeto como cadena
		return super.toString()+ "\n" + "\nUnidades por paquete: " + cantidadPorPaquete+"\n"; // Retorna la información del
																							// objeto
	}
	public int codigoAleatorio() {
		int codigo;
		Random random = new Random();
		
		 do {
	            codigo = random.nextInt((4999 - 4000 + 1)) + 4000;
	        } while (generatedCodes.contains(codigo));

	        generatedCodes.add(codigo);
	        return codigo;
	}
}
