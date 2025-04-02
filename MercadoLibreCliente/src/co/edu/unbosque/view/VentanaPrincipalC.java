package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;

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
	

	public VentanaPrincipalC(Properties prop) throws IOException {

		setBounds(150, 150, 1300, 750);
		setTitle("Mercado Libre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(null);
		setResizable(false);
		
		ppc = new PanelPrincipalC(prop);
		pis = new PanelIniciarSesion(prop);
		pcu = new PanelCrearU(prop);
		pcm = new PanelClienteMenu(prop);
		pc = new PanelCarrito(prop);
		ph = new PanelHistorial(prop);
		pt = new PanelTienda(prop);
		pf = new PanelFavorito(prop);

		add(ppc).setVisible(true);
		add(pis).setVisible(false);
		add(pcu).setVisible(false);
		add(pcm).setVisible(false);
		add(pc).setVisible(false);
		add(ph).setVisible(false);
		add(pt).setVisible(false);
		add(pf).setVisible(false);
		

	}
	
	public void refrescarUI(Properties prop) throws IOException {
	    // Aplicar revalidate() y repaint() a todos los paneles
	    ppc.setProp(prop);
	    ppc.actualizarComp();
	    ppc.revalidate();
	    ppc.repaint();
	    
	    pis.setProp(prop);
	    pis.actualizarComp();
	    pis.revalidate();
	    pis.repaint();

	    pcu.setProp(prop);
	    pcu.actualizarComp();
	    pcu.revalidate();
	    pcu.repaint();

	    pcm.setProp(prop);
	    pcm.actualizarComp();
	    pcm.revalidate();
	    pcm.repaint();

	    pc.setProp(prop);
	    pc.actualizarComp();
	    pc.revalidate();
	    pc.repaint();

	    ph.setProp(prop);
	    ph.actualizarComp();
	    ph.revalidate();
	    ph.repaint();

	    pt.setProp(prop);
	    pt.actualizarComp();
	    pt.revalidate();
	    pt.repaint();

	    pf.setProp(prop);
	    pf.actualizarComp();
	    pf.revalidate();
	    pf.repaint();
	    
	    // También actualizar la ventana principal
	    this.revalidate();
	    this.repaint();
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
