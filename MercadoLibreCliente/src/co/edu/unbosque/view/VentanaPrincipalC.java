package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class VentanaPrincipalC extends JFrame {

	private PanelPrincipalC ppc;
	private PanelIniciarSesion pis;
	private PanelCrearU pcu;
	private PanelClienteMenu pcm;
	private PanelCarrito pc;
	private PanelHistorial ph;
	private PanelTienda pt;
	private PanelFavorito pf;

	public VentanaPrincipalC() throws IOException {

		setBounds(10, 10, 1290, 750);
		setTitle("Mercado Libre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(null);
		
		ppc = new PanelPrincipalC();
		pis = new PanelIniciarSesion();
		pcu = new PanelCrearU();
		pcm = new PanelClienteMenu();
		pc = new PanelCarrito();
		ph = new PanelHistorial();
		pt = new PanelTienda();
		pf = new PanelFavorito();

		add(ppc).setVisible(true);
		add(pis).setVisible(false);
		add(pcu).setVisible(false);
		add(pcm).setVisible(false);
		add(pc).setVisible(false);
		add(ph).setVisible(false);
		add(pt).setVisible(false);
		add(pf).setVisible(false);
		

	}

	public PanelCarrito getPc() {
		return pc;
	}

	public void setPc(PanelCarrito pc) {
		this.pc = pc;
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

	public PanelHistorial getPh() {
		return ph;
	}

	public void setPh(PanelHistorial ph) {
		this.ph = ph;
	}

	public PanelTienda getPt() {
		return pt;
	}

	public void setPt(PanelTienda pt) {
		this.pt = pt;
	}

	public PanelFavorito getPf() {
		return pf;
	}

	public void setPf(PanelFavorito pf) {
		this.pf = pf;
	}

	public void setPcm(PanelClienteMenu pcm) {
		this.pcm = pcm;
	}
	
	
	
	
	

}
