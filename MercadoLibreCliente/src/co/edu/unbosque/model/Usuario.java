package co.edu.unbosque.model;

import java.io.Serializable;

/** 
 * Clase abstracta Usuario que implementa Serializable.
 */
public abstract class Usuario implements Serializable {
    
    /** Nombre del usuario */
    private String nombre;
    
    /** Contraseña del usuario */
    private String contrasena;

    /** Constructor por defecto */
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

    /** Constructor que recibe nombre y contraseña */
    public Usuario(String nombre, String contrasena) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    /** Obtiene el nombre del usuario */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre del usuario */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Obtiene la contraseña del usuario */
    public String getContrasena() {
        return contrasena;
    }

    /** Establece la contraseña del usuario */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /** Representación en cadena del objeto Usuario */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "     Contrasena: " + contrasena;
    }
}

