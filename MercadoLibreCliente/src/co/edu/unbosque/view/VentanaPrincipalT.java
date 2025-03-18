package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class VentanaPrincipalT extends JFrame {

	private PanelPrincipalT ppt;
	private PanelIniciarSesion pis;
	private PanelCrearU pcu;

	public VentanaPrincipalT() throws IOException {

		setBounds(10, 10, 1290, 750);
		setTitle("Mercado Libre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		ppt = new PanelPrincipalT();
		pis = new PanelIniciarSesion();
		pcu = new PanelCrearU();

		add(ppt).setVisible(true);
		add(pis).setVisible(false);
		add(pcu).setVisible(false);

	}

	public PanelPrincipalT getPpt() {
		return ppt;
	}

	public void setPpt(PanelPrincipalT ppt) {
		this.ppt = ppt;
	}

	public PanelIniciarSesion getPis() {
		return pis;
	}

	public void setPis(PanelIniciarSesion pis) {
		this.pis = pis;
	}

	public PanelCrearU getPcu() {
		return pcu;
	}

	public void setPcu(PanelCrearU pcu) {
		this.pcu = pcu;
	}

}
