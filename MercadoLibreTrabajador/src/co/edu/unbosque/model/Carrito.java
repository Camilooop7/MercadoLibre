package co.edu.unbosque.model; 

import java.io.Serializable; 
import java.util.ArrayList;

/**
 * Clase que representa un carrito de compras.
 */
public class Carrito implements Serializable {

	/**
	 * Lista de productos en el carrito.
	 */
	private ArrayList<Producto> listaCarrito;

	/**
	 * Constructor vacío.
	 */
	public Carrito() {
		listaCarrito = new ArrayList<>();
	}

	/**
	 * Obtiene la lista de productos en el carrito.
	 * 
	 * @return Lista de productos en el carrito.
	 */
	public ArrayList<Producto> getListaCarrito() {
		return listaCarrito;
	}

	/**
	 * Establece la lista de productos en el carrito.
	 * 
	 * @param listaCarrito Nueva lista de productos.
	 */
	public void setListaCarrito(ArrayList<Producto> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 3e13f7f58cc1d969f274bd76850382e5724d1015
