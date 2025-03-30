package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

public class ViewFacade {

	private VentanaEmergente vemer;
	private VentanaPrincipalC vpc;
	
	
	public ViewFacade(Properties prop) throws IOException {
		vemer = new VentanaEmergente();
		vpc = new VentanaPrincipalC(prop);
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
