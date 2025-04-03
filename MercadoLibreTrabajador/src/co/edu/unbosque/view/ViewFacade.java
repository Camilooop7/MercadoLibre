package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class ViewFacade {

	private VentanaEmergente vemer;
	private VentanaPrincipalT vpt;
	
	/**
	 * inicialización de las ventanas principales
	 * @param prop
	 * @throws IOException
	 */
	public ViewFacade(Properties prop) throws IOException {
		vemer = new VentanaEmergente();
		vpt = new VentanaPrincipalT(prop);
	}


	/**
	 * Getters & Stters
	 * @return
	 */
	public VentanaEmergente getVemer() {
		return vemer;
	}


	public void setVemer(VentanaEmergente vemer) {
		this.vemer = vemer;
	}


	public VentanaPrincipalT getVpt() {
		return vpt;
	}


	public void setVpt(VentanaPrincipalT vpt) {
		this.vpt = vpt;
	}
	
	
	
}
