package co.edu.unbosque.model; 

import java.io.Serializable; 
import java.util.ArrayList;

public class Carrito implements Serializable { // Declara la clase Carrito, que implementa Serializable para permitir su almacenamiento

	private ArrayList<Producto> listaCarrito; // Atributo que almacena una lista de productos en el carrito

	public Carrito() { 
		listaCarrito = new ArrayList<>(); // Inicializa la lista al crear un objeto Carrito
	}

	public ArrayList<Producto> getListaCarrito() { 
		return listaCarrito; // Devuelve la lista de productos en el carrito
	}

	public void setListaCarrito(ArrayList<Producto> listaCarrito) { 
		this.listaCarrito = listaCarrito; // Permite asignar una nueva lista de productos al carrito
	}

}

