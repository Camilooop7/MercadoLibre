package co.edu.unbosque.model;

import java.util.ArrayList;

public class Carrito {

	private ArrayList<Producto> listaCarrito;

	public Carrito() {
		listaCarrito = new ArrayList<>();
	}

	public ArrayList<Producto> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(ArrayList<Producto> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}

}
