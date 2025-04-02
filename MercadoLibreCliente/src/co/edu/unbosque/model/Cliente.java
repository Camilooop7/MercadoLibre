package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un cliente, hereda de Usuario.
 */
public class Cliente extends Usuario implements Serializable {

	/**
	 * Carrito actual del cliente.
	 */
	private Carrito carrito;

	/**
	 * Lista de carritos asociados al cliente.
	 */
	private ArrayList<Carrito> listaCarritos;

	/**
	 * Lista de productos favoritos del cliente.
	 */
	private ArrayList<Producto> listaProductoFavorito;

	/**
	 * Constructor vacío.
	 */
	public Cliente() {
		carrito = null;
		listaCarritos = new ArrayList<>();
		listaProductoFavorito = new ArrayList<>();
	}

	/**
	 * Constructor que inicializa la lista de productos favoritos.
	 * 
	 * @param listaProductoFavorito Lista de productos favoritos del cliente.
	 */
	public Cliente(ArrayList<Producto> listaProductoFavorito) {
		super();
		this.listaProductoFavorito = listaProductoFavorito;
		carrito = null;
		listaCarritos = new ArrayList<>();
	}

	/**
	 * Constructor que inicializa el nombre, la contraseña y la lista de productos favoritos.
	 * 
	 * @param nombre                Nombre del cliente.
	 * @param contrasena            Contraseña del cliente.
	 * @param listaProductoFavorito Lista de productos favoritos del cliente.
	 */
	public Cliente(String nombre, String contrasena, ArrayList<Producto> listaProductoFavorito) {
		super(nombre, contrasena);
		this.listaProductoFavorito = listaProductoFavorito;
		carrito = null;
		listaCarritos = new ArrayList<>();
	}

	/**
	 * Constructor que inicializa el nombre y la contraseña.
	 * 
	 * @param nombre     Nombre del cliente.
	 * @param contrasena Contraseña del cliente.
	 */
	public Cliente(String nombre, String contrasena) {
		super(nombre, contrasena);
		carrito = null;
		listaCarritos = new ArrayList<>();
		listaProductoFavorito = new ArrayList<>();
	}

	/**
	 * Obtiene la lista de productos favoritos del cliente.
	 * 
	 * @return Lista de productos favoritos.
	 */
	public ArrayList<Producto> getListaProductoFavorito() {
		return listaProductoFavorito;
	}

	/**
	 * Establece la lista de productos favoritos del cliente.
	 * 
	 * @param listaProductoFavorito Nueva lista de productos favoritos.
	 */
	public void setListaProductoFavorito(ArrayList<Producto> listaProductoFavorito) {
		this.listaProductoFavorito = listaProductoFavorito;
	}

	/**
	 * Obtiene el carrito actual del cliente.
	 * 
	 * @return Carrito actual.
	 */
	public Carrito getCarrito() {
		return carrito;
	}

	/**
	 * Establece el carrito actual del cliente.
	 * 
	 * @param carrito Nuevo carrito.
	 */
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	/**
	 * Obtiene la lista de carritos asociados al cliente.
	 * 
	 * @return Lista de carritos.
	 */
	public ArrayList<Carrito> getListaCarritos() {
		return listaCarritos;
	}

	/**
	 * Establece la lista de carritos asociados al cliente.
	 * 
	 * @param listaCarritos Nueva lista de carritos.
	 */
	public void setListaCarritos(ArrayList<Carrito> listaCarritos) {
		this.listaCarritos = listaCarritos;
	}
}

