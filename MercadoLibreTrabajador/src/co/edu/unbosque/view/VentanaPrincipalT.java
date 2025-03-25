package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class VentanaPrincipalT extends JFrame {

	private PanelPrincipalT ppt;
	private PanelIniciarSesion pis;
	private PanelCrearU pcu;
	private PanelTrabajador pt;
	private PanelAnadirProducto pap;
	private PanelUsuarios pmu;
	private PanelElimianarProducto pep;

	public VentanaPrincipalT() throws IOException {

		setBounds(10, 10, 1290, 750);
		setTitle("Mercado Libre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		ppt = new PanelPrincipalT();
		pis = new PanelIniciarSesion();
		pcu = new PanelCrearU();
		pt = new PanelTrabajador();
		pap = new PanelAnadirProducto();
		pmu = new PanelUsuarios();
		pep = new PanelElimianarProducto();

		add(ppt).setVisible(true);
		add(pis).setVisible(false);
		add(pcu).setVisible(false);
		add(pt).setVisible(false);
		add(pap).setVisible(false);
		add(pmu).setVisible(false);
		add(pep).setVisible(false);

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

	public PanelTrabajador getPt() {
		return pt;
	}

	public void setPt(PanelTrabajador pt) {
		this.pt = pt;
	}

	public PanelAnadirProducto getPap() {
		return pap;
	}

	public void setPap(PanelAnadirProducto pap) {
		this.pap = pap;
	}

	public PanelUsuarios getPmu() {
		return pmu;
	}

	public void setPmu(PanelUsuarios pmu) {
		this.pmu = pmu;
	}

	public PanelElimianarProducto getPep() {
		return pep;
	}

	public void setPep(PanelElimianarProducto pep) {
		this.pep = pep;
	}

}
