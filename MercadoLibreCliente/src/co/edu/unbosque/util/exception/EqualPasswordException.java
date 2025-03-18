package co.edu.unbosque.util.exception;

public class EqualPasswordException extends Exception {

	public EqualPasswordException() {
		super("Las contraseñas deben coincidir.");
	}
}
