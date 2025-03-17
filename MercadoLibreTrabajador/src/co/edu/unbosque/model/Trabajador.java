package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Trabajador extends Usuario implements Serializable{
	private ArrayList<Producto> listaProductoAnadido;

	public Trabajador() {
		listaProductoAnadido = new ArrayList<>();
	}

	public Trabajador(ArrayList<Producto> listaProductoAnadido) {
		super();
		this.listaProductoAnadido = listaProductoAnadido;
	}

	public Trabajador(String nombre, String contrasena, ArrayList<Producto> listaProductoAnadido) {
		super(nombre, contrasena);
		this.listaProductoAnadido = listaProductoAnadido;
	}

	public Trabajador(String nombre, String contrasena) {
		super(nombre, contrasena);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Producto> getListaProductoAnadido() {
		return listaProductoAnadido;
	}

	public void setListaProductoAnadido(ArrayList<Producto> listaProductoAnadido) {
		this.listaProductoAnadido = listaProductoAnadido;
	}

}
