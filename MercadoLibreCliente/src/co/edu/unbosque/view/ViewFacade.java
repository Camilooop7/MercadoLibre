package co.edu.unbosque.view;

import java.io.IOException;

public class ViewFacade {

	private VentanaEmergente vemer;
	private VentanaPrincipalC vpc;
	
	
	public ViewFacade() throws IOException {
		vemer = new VentanaEmergente();
		vpc = new VentanaPrincipalC();
	}


	public VentanaEmergente getVemer() {
		return vemer;
	}


	public void setVemer(VentanaEmergente vemer) {
		this.vemer = vemer;
	}


	public VentanaPrincipalC getVpc() {
		return vpc;
	}


	public void setVpc(VentanaPrincipalC vpc) {
		this.vpc = vpc;
	}
	
	
	
}
