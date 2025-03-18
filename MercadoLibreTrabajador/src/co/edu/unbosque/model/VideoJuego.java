package co.edu.unbosque.model;

import java.io.Serializable;

/** 
 * Clase VideoJuego que extiende de Ocio e implementa Serializable.
 */
public class VideoJuego extends Ocio implements Serializable {

    /** Referencia de la consola en la que se puede jugar el videojuego */
    private String referenciaConsola;

    /** Constructor por defecto */
    public VideoJuego() {
        // TODO Auto-generated constructor stub
    }

    /** Constructor que recibe la referencia de la consola */
    public VideoJuego(String referenciaConsola) {
        super();
        this.referenciaConsola = referenciaConsola;
    }

    /** Constructor que recibe todos los atributos de Ocio y la referencia de la consola */
    public VideoJuego(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio,
                      String referenciaConsola) {
        super(nombre, precio, id, cantidad, imagen, esAccesorio);
        this.referenciaConsola = referenciaConsola;
    }

    /** Constructor que recibe todos los atributos de Ocio sin la referencia de la consola */
    public VideoJuego(String nombre, int precio, int id, int cantidad, String imagen, boolean esAccesorio) {
        super(nombre, precio, id, cantidad, imagen, esAccesorio);
        // TODO Auto-generated constructor stub
    }

    /** Obtiene la referencia de la consola */
    public String getReferenciaConsola() {
        return referenciaConsola;
    }

    /** Establece la referencia de la consola */
    public void setReferenciaConsola(String referenciaConsola) {
        this.referenciaConsola = referenciaConsola;
    }

    /** Representación en cadena del objeto VideoJuego */
    @Override
    public String toString() {
        return super.toString() + " ¿Que consola es? " + referenciaConsola;
    }
}

