package co.edu.unbosque.view;


/**
 * 
 * Importanción de las librerias para el uso de imagenes, texto, botones, colores, paneles.
 */
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;


/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class VentanaPrincipalT extends JFrame {

	private PanelPrincipalT ppt;
	private PanelIniciarSesion pis;
	private PanelCrearU pcu;
	private PanelTrabajador pt;
	private PanelAnadirProducto pap;
	private PanelUsuario pmu;
	private PanelElimianarProducto pep;
	private PanelActualizarProducto papro;
	
	

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public VentanaPrincipalT(Properties prop) throws IOException {

		setBounds(10, 10, 1290, 750);
		setTitle("Mercado Libre");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		
		/**
		 * inicialización de paneles
		 */
		ppt = new PanelPrincipalT(prop);
		pis = new PanelIniciarSesion(prop);
		pcu = new PanelCrearU(prop);
		pt = new PanelTrabajador(prop);
		pap = new PanelAnadirProducto(prop);
		pmu = new PanelUsuario(prop);
		pep = new PanelElimianarProducto(prop);
		papro = new PanelActualizarProducto(prop);
		
		

		/**
		 * inicialización de paneles e implementación con .add
		 */
		add(ppt).setVisible(true);
		add(pis).setVisible(false);
		add(pcu).setVisible(false);
		add(pt).setVisible(false);
		add(pap).setVisible(false);
		add(pmu).setVisible(false);
		add(pep).setVisible(false);
		add(papro).setVisible(false);
		

	}
	
	
	/**
	 * Aplicar revalidate() y repaint() a todos los paneles
	 * @param prop
	 * @throws IOException
	 */
	public void refrescarUI(Properties prop) throws IOException {
	    // Aplicar revalidate() y repaint() a todos los paneles
		
		pap.refrescarUI(prop);
		pmu.refrescarUI(prop);
		papro.refrescarUI(prop);
		pep.refrescarUI(prop);
		
		pap.actualizarCompss();
		pep.actualizarCompss();
		papro.actualizarCompss();
		
	    ppt.setProp(prop);
	    ppt.actualizarComps();
	    ppt.revalidate();
	    ppt.repaint();
	    
	    pis.setProp(prop);
	    pis.actualizarComps();
	    pis.revalidate();
	    pis.repaint();

	    pcu.setProp(prop);
	    pcu.actualizarComps();
	    pcu.revalidate();
	    pcu.repaint();

	    pt.setProp(prop);
	    pt.actualizarComps();
	    pt.revalidate();
	    pt.repaint();

	    pap.setProp(prop);
	    pap.actualizarComps();
	    pap.revalidate();
	    pap.repaint();

	    pmu.setProp(prop);
	    pmu.actualizarComps();
	    pmu.revalidate();
	    pmu.repaint();

	    pep.setProp(prop);
	    pep.actualizarComps();
	    pep.revalidate();
	    pep.repaint();

	    papro.setProp(prop);
	    papro.actualizarComps();
	    papro.revalidate();
	    papro.repaint();
	    
	   
	    
	    // También actualizar la ventana principal
	    this.revalidate();
	    this.repaint();
	}
	
	
	/**
	 * Getters & Stters
	 */
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

	public PanelUsuario getPmu() {
		return pmu;
	}

	public void setPmu(PanelUsuario pmu) {
		this.pmu = pmu;
	}

	public PanelElimianarProducto getPep() {
		return pep;
	}

	public void setPep(PanelElimianarProducto pep) {
		this.pep = pep;
	}

	public PanelActualizarProducto getPapro() {
		return papro;
	}

	public void setPapro(PanelActualizarProducto papro) {
		this.papro = papro;
	}
	

	
	
}
