package co.edu.unbosque.model;

import java.util.ArrayList;

public class Cliente extends Usuario {

	private ArrayList<Producto> listaProductoFavorito;

	public Cliente() {
		listaProductoFavorito = new ArrayList<>();
	}

	public Cliente(ArrayList<Producto> listaProductoFavorito) {
		super();
		this.listaProductoFavorito = listaProductoFavorito;
	}

	public Cliente(String nombre, String contrasena, ArrayList<Producto> listaProductoFavorito) {
		super(nombre, contrasena);
		this.listaProductoFavorito = listaProductoFavorito;
	}

	public Cliente(String nombre, String contrasena) {
		super(nombre, contrasena);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Producto> getListaProductoFavorito() {
		return listaProductoFavorito;
	}

	public void setListaProductoFavorito(ArrayList<Producto> listaProductoFavorito) {
		this.listaProductoFavorito = listaProductoFavorito;
	}

}
