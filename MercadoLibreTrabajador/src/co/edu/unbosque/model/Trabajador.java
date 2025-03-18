package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/** 
 * Clase Trabajador que extiende de Usuario e implementa Serializable.
 */
public class Trabajador extends Usuario implements Serializable{

    /** Lista de productos añadidos por el trabajador */
    private ArrayList<Producto> listaProductoAnadido;

    /** Constructor por defecto */
    public Trabajador() {
        listaProductoAnadido = new ArrayList<>();
    }

    /** Constructor que recibe una lista de productos añadidos. */
    public Trabajador(ArrayList<Producto> listaProductoAnadido) {
        super();
        this.listaProductoAnadido = listaProductoAnadido;
    }

    /** Constructor que recibe nombre, contraseña y lista de productos añadidos. */
    public Trabajador(String nombre, String contrasena, ArrayList<Producto> listaProductoAnadido) {
        super(nombre, contrasena);
        this.listaProductoAnadido = listaProductoAnadido;
    }

    /** Constructor que recibe nombre y contraseña. */
    public Trabajador(String nombre, String contrasena) {
        super(nombre, contrasena);
        // TODO Auto-generated constructor stub
    }

    /** Obtiene la lista de productos añadidos. */
    public ArrayList<Producto> getListaProductoAnadido() {
        return listaProductoAnadido;
    }

    /** Establece la lista de productos añadidos. */
    public void setListaProductoAnadido(ArrayList<Producto> listaProductoAnadido) {
        this.listaProductoAnadido = listaProductoAnadido;
    }
}

