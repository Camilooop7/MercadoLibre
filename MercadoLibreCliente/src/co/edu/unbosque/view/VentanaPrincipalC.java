package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class VentanaPrincipalC extends JFrame {

	private PanelPrincipalC ppc;
	private PanelIniciarSesion pis;
	private PanelCrearU pcu;
	private PanelClienteMenu pcm;

	public VentanaPrincipalC() throws IOException {

		setBounds(10, 10, 1290, 750);
		setTitle("Mercado Libre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		ppc = new PanelPrincipalC();
		pis = new PanelIniciarSesion();
		pcu = new PanelCrearU();
		pcm = new PanelClienteMenu();

		add(ppc).setVisible(true);
		add(pis).setVisible(false);
		add(pcu).setVisible(false);
		add(pcm).setVisible(false);

	}

	public PanelPrincipalC getPpc() {
		return ppc;
	}

	public void setPpc(PanelPrincipalC ppc) {
		this.ppc = ppc;
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

	public PanelClienteMenu getPcm() {
		return pcm;
	}

	public void setPc(PanelClienteMenu pcm) {
		this.pcm = pcm;
	}
	

}
