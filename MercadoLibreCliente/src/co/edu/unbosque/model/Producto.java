package co.edu.unbosque.model;

import java.io.Serializable; // Importa la interfaz Serializable
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Producto implements Serializable { // Declara la clase abstracta Producto

	private String nombre; // Atributo que almacena el nombre del producto
	private int precio; // Atributo que almacena el precio del producto
	private int id; // Atributo que almacena el identificador del producto
	private String fecha; // Atributo que almacena la cantidad disponible del producto
	private String imagen; // Atributo que almacena la ruta de la imagen del producto

	public Producto() { // Constructor vacío
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, int precio, int id, String fecha, String imagen) { // Constructor con parámetros
		super(); // Llama al constructor de la clase padre
		this.nombre = nombre; // Asigna el valor del nombre
		this.precio = precio; // Asigna el valor del precio
		this.id = id; // Asigna el valor del id
		this.fecha = fecha; // Asigna el valor de la cantidad
		this.imagen = imagen; // Asigna la ruta de la imagen
	}

	public String getNombre() { // Método para obtener el nombre del producto
		return nombre; // Retorna el nombre
	}

	public void setNombre(String nombre) { // Método para modificar el nombre del producto
		this.nombre = nombre; // Asigna el nuevo nombre
	}

	public int getPrecio() { // Método para obtener el precio del producto
		return precio; // Retorna el precio
	}

	public void setPrecio(int precio) { // Método para modificar el precio del producto
		this.precio = precio; // Asigna el nuevo precio
	}

	public int getId() { // Método para obtener el identificador del producto
		return id; // Retorna el identificador
	}

	public void setId(int id) { // Método para modificar el identificador del producto
		this.id = id; // Asigna el nuevo identificador
	}

	public String getImagen() { // Método para obtener la imagen del producto
		return imagen; // Retorna la imagen
	}

	public void setImagen(String imagen) { // Método para modificar la imagen del producto
		this.imagen = imagen; // Asigna la nueva imagen
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() { // Método para representar el objeto como cadena
		return "\nNombre: " + nombre + "\nPrecio: $" + precio + "\nID: " + id /*+ "\nFecha: " + fecha*/;
	}
}
