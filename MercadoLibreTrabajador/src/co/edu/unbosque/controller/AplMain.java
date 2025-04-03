package co.edu.unbosque.controller;

import java.io.IOException;
/**
 * clase encargada de correr el programa
 * 
 */
public class AplMain {
	/**
     * El método principal que se ejecuta al iniciar el programa.
     *
     * @param args Los argumentos de la línea de comandos.
     * @throws IOException Si ocurre un error durante la ejecución.
     */

	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
		c.run();
	}

}
