package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrito implements Serializable{

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
