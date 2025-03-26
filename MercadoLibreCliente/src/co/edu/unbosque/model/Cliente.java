package co.edu.unbosque.model; 

import java.io.Serializable; 
import java.util.ArrayList; 

public class Cliente extends Usuario implements Serializable { // Declara la clase Cliente, que hereda de Usuario e implementa Serializable

	private ArrayList<Producto> listaProductoFavorito; // Atributo que almacena una lista de productos favoritos del cliente

	public Cliente() { 
		listaProductoFavorito = new ArrayList<>(); // Inicializa la lista de productos favoritos al crear un objeto Cliente
	}

	public Cliente(ArrayList<Producto> listaProductoFavorito) { 
		super(); // Llama al constructor de la clase padre (Usuario)
		this.listaProductoFavorito = listaProductoFavorito; // Asigna la lista de productos favoritos
	}

	public Cliente(String nombre, String contrasena, ArrayList<Producto> listaProductoFavorito) { 
		super(nombre, contrasena); // Llama al constructor de la clase padre con nombre y contraseña
		this.listaProductoFavorito = listaProductoFavorito; // Asigna la lista de productos favoritos
	}

	public Cliente(String nombre, String contrasena) { 
		super(nombre, contrasena); // Llama al constructor de la clase padre con nombre y contraseña
		// Constructor sin inicializar la lista de productos favoritos
	}

	public ArrayList<Producto> getListaProductoFavorito() { 
		return listaProductoFavorito; // Devuelve la lista de productos favoritos del cliente
	}

	public void setListaProductoFavorito(ArrayList<Producto> listaProductoFavorito) { 
		this.listaProductoFavorito = listaProductoFavorito; // Permite asignar una nueva lista de productos favoritos
	}

}

