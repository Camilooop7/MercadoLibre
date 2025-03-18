package co.edu.unbosque.util.exception;

/**
 * Clase la cual es publica para ser llamada dentro de otras clases
 * la cual es heredada de Exception
 */
public class CapitalException extends Exception {

	/**
	 * Se crea un constructor el cual no recibe ningun tipo de parametro se llama el
	 * super como constructor de la clase madre recibiendo un texto.
	 */
	public CapitalException() {
		super("Debe contener una mayuscula.");

	}
}
