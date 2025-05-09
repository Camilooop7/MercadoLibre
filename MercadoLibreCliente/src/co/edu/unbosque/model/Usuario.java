package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Representa un usuario abstracto que implementa la interfaz Serializable.
 */
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;		
    /**
     * Nombre del usuario.
     */
    private String nombre = "";

    /**
     * Contraseña del usuario.
     */
    private String contrasena = "";

    /**
     * Constructor por defecto que inicializa un usuario sin datos.
     */
    public Usuario() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa un usuario con un nombre y una contraseña.
     *
     * @param nombre     el nombre del usuario.
     * @param contrasena la contraseña del usuario.
     */
    public Usuario(String nombre, String contrasena) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre el nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return la contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena la nueva contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     *
     * @return una cadena que representa al usuario.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "     Contrasena: " + contrasena;
    }
}

