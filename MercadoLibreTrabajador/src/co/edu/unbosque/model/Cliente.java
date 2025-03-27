package co.edu.unbosque.model; 

import java.io.Serializable; 
import java.util.ArrayList; 

public class Cliente extends Usuario implements Serializable { // Declara la clase Cliente, que hereda de Usuario e implementa Serializable
	
	private Carrito carrito;
	private ArrayList<Carrito> listaCarritos;
	private ArrayList<Producto> listaProductoFavorito; // Atributo que almacena una lista de productos favoritos del cliente

	public Cliente() { 
		carrito = null;
		listaCarritos = new ArrayList<>();
		listaProductoFavorito = new ArrayList<>(); // Inicializa la lista de productos favoritos al crear un objeto Cliente
	}

	public Cliente(ArrayList<Producto> listaProductoFavorito) { 
		super(); // Llama al constructor de la clase padre (Usuario)
		this.listaProductoFavorito = listaProductoFavorito; // Asigna la lista de productos favoritos
		carrito = null;
		listaCarritos = new ArrayList<>();
		listaProductoFavorito = new ArrayList<>(); // Inicializa la lista de productos favoritos al crear un objeto Cliente
	}

	public Cliente(String nombre, String contrasena, ArrayList<Producto> listaProductoFavorito) { 
		super(nombre, contrasena); // Llama al constructor de la clase padre con nombre y contraseña
		this.listaProductoFavorito = listaProductoFavorito; // Asigna la lista de productos favoritos
		carrito = null;
		listaCarritos = new ArrayList<>();
		listaProductoFavorito = new ArrayList<>(); // Inicializa la lista de productos favoritos al crear un objeto Cliente
	}

	public Cliente(String nombre, String contrasena) { 
		super(nombre, contrasena); // Llama al constructor de la clase padre con nombre y contraseña
		carrito = null;
		listaCarritos = new ArrayList<>();
		listaProductoFavorito = new ArrayList<>(); // Inicializa la lista de productos favoritos al crear un objeto Cliente
		// Constructor sin inicializar la lista de productos favoritos
	}

	public ArrayList<Producto> getListaProductoFavorito() { 
		return listaProductoFavorito; // Devuelve la lista de productos favoritos del cliente
	}

	public void setListaProductoFavorito(ArrayList<Producto> listaProductoFavorito) { 
		this.listaProductoFavorito = listaProductoFavorito; // Permite asignar una nueva lista de productos favoritos
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public ArrayList<Carrito> getListaCarritos() {
		return listaCarritos;
	}

	public void setListaCarritos(ArrayList<Carrito> listaCarritos) {
		this.listaCarritos = listaCarritos;
	}
	
}

