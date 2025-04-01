package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

public class ViewFacade {

	private VentanaEmergente vemer;
	private VentanaPrincipalT vpt;
	
	
	public ViewFacade(Properties prop) throws IOException {
		vemer = new VentanaEmergente();
		vpt = new VentanaPrincipalT(prop);
	}


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
