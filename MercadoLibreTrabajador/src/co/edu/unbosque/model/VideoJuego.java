package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;

/**
 * Representa un videojuego que extiende de la clase Ocio e implementa la interfaz Serializable.
 */
public class VideoJuego extends Ocio implements Serializable {

	/** Referencia de la consola en la que se puede jugar el videojuego */
	private String referenciaConsola;
	private HashSet<Integer> code = new HashSet<>();
    /**
     * Referencia de la consola en la que se puede jugar el videojuego.
     */
    private String referenciaConsola;

    /**
     * Conjunto para almacenar códigos generados aleatoriamente y evitar duplicados.
     */
    private HashSet<Integer> generatedCodes = new HashSet<>();

    /**
     * Constructor por defecto que inicializa un objeto de tipo VideoJuego.
     */
    public VideoJuego() {
        // Constructor vacío.
    }

    /**
     * Constructor que inicializa el videojuego con la referencia de la consola.
     *
     * @param referenciaConsola Referencia de la consola.
     */
    public VideoJuego(String referenciaConsola) {
        super();
        this.referenciaConsola = referenciaConsola;
    }

    /**
     * Constructor que inicializa el videojuego con todos los atributos de Ocio y la referencia de la consola.
     *
     * @param nombre            Nombre del videojuego.
     * @param precio            Precio del videojuego.
     * @param id                Identificador único del videojuego.
     * @param fecha             Fecha de lanzamiento del videojuego.
     * @param imagen            URL o ruta de la imagen del videojuego.
     * @param esAccesorio       Indica si el videojuego es un accesorio.
     * @param referenciaConsola Referencia de la consola.
     */
    public VideoJuego(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio,
                      String referenciaConsola) {
        super(nombre, precio, id, fecha, imagen, esAccesorio);
        this.referenciaConsola = referenciaConsola;
    }

    /**
     * Constructor que inicializa el videojuego con todos los atributos de Ocio excepto la referencia de la consola.
     *
     * @param nombre      Nombre del videojuego.
     * @param precio      Precio del videojuego.
     * @param id          Identificador único del videojuego.
     * @param fecha       Fecha de lanzamiento del videojuego.
     * @param imagen      URL o ruta de la imagen del videojuego.
     * @param esAccesorio Indica si el videojuego es un accesorio.
     */
    public VideoJuego(String nombre, int precio, int id, String fecha, String imagen, boolean esAccesorio) {
        super(nombre, precio, id, fecha, imagen, esAccesorio);
    }

    /**
     * Obtiene la referencia de la consola en la que se puede jugar el videojuego.
     *
     * @return Referencia de la consola.
     */
    public String getReferenciaConsola() {
        return referenciaConsola;
    }

    /**
     * Establece la referencia de la consola en la que se puede jugar el videojuego.
     *
     * @param referenciaConsola Referencia de la consola.
     */
    public void setReferenciaConsola(String referenciaConsola) {
        this.referenciaConsola = referenciaConsola;
    }

    /**
     * Genera una representación en cadena del objeto VideoJuego.
     *
     * @return Cadena que representa el objeto VideoJuego.
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "\nConsola: " + referenciaConsola + "\n";
    }

<<<<<<< HEAD
		do {
			codigo = random.nextInt((5999 - 5000 + 1)) + 5000;
		} while (code.contains(codigo));

		code.add(codigo);
		return codigo;
	}
}
=======
    /**
     * Genera un código aleatorio único en el rango de 5000 a 5999.
     *
     * @return Código aleatorio generado.
     */
    public int codigoAleatorio() {
        int codigo;
        Random random = new Random();

        do {
            codigo = random.nextInt((5999 - 5000 + 1)) + 5000;
        } while (generatedCodes.contains(codigo));

        generatedCodes.add(codigo);
        return codigo;
    }
}
>>>>>>> 3e13f7f58cc1d969f274bd76850382e5724d1015
