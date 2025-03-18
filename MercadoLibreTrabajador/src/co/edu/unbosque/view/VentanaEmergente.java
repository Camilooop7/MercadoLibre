package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class VentanaEmergente {
	/*
	 * Constgructor vacio.
	 */
	public VentanaEmergente() {
	}

	/*
	 * metodo donde se muestra una ventana emergente la cual tiene como parametro un
	 * String.
	 */
	public void mostrar(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/*
	 * metodo donde se muestra una ventana emergente solicitando un numero entero al
	 * usuario la cual tiene como parametro un String. y retorna el valor asignado.
	 */
	public int leerInt(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		int dato = Integer.parseInt(aux);
		return dato;
	}

	/*
	 * Metodo el cual atravez de una ventana socilita un texto recibe un parametro
	 * String y retorna el dato del usuario.
	 * 
	 */
	public String leerTexto(String mensaje) {
		String dato = JOptionPane.showInputDialog(mensaje);
		return dato;
	}

	/*
	 * Metodo el cual emite una ventana emergente solicitando un boolean. definido
	 * con la palabra si.
	 */

	
	  public  boolean leerBoleano(String mensaje) {
	        Object[] opciones = {"Sí", "No"};
	        int respuesta = JOptionPane.showOptionDialog(
	                null,
	                mensaje,
	                "Verdadero o falso",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                opciones,
	                opciones[0]
	        );
	        return respuesta == 0;
	    } 

}