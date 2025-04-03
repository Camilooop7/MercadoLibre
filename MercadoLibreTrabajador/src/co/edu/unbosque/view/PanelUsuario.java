package co.edu.unbosque.view;

/**
 * 
 * Importanción de las librerias para el uso de imagenes, texto, botones, colores, paneles.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelUsuario extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private String texto;
	private PanelModificarU pmu;
	private PanelModificarT pmt;
	private PanelModificarC pmc;
	private Properties prop;
	

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelUsuario(Properties prop) throws IOException {
		
		/**
		 * Uso del setBounds para fijar la posción del panel setLayaout permite
		 * modificar manualmente los elementos.
		 */
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		this.prop = prop;

		
		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.tback")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnVolver = new JButton();
		btnVolver.setBounds(1092, 71, 130, 97);
		btnVolver.setFocusable(false);
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setVisible(true);
		add(btnVolver);

		pmu = new PanelModificarU(prop);
		pmt = new PanelModificarT();
		pmc = new PanelModificarC();

		add(pmc).setVisible(false);
		add(pmt).setVisible(false);
		add(pmu).setVisible(true);

		add(fondo);
	}
	
	
	/**
	 * Aplicar revalidate() y repaint() a todos los paneles
	 * @param prop
	 * @throws IOException
	 */
	public void refrescarUI(Properties prop) throws IOException {
	    // Aplicar revalidate() y repaint() a todos los paneles
		
		
	    pmu.setProp(prop);
	    pmu.actualizarComps();
	    pmu.revalidate();
	    pmu.repaint();
	    
	    
	    
	  
	    
	    // También actualizar la ventana principal
	    this.revalidate();
	    this.repaint();
	}
	
	/**
	 * Meotodo el cual redimienciona la imagen del panel y su creación
	 * @throws IOException
	 */
	public void actualizarComps() throws IOException{
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.tback")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
	}

	/**
	 * Getters & Stters
	 * @return fondo
	 */
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public PanelModificarU getPmu() {
		return pmu;
	}

	public void setPmu(PanelModificarU pmu) {
		this.pmu = pmu;
	}

	public PanelModificarT getPmt() {
		return pmt;
	}

	public void setPmt(PanelModificarT pmt) {
		this.pmt = pmt;
	}

	public PanelModificarC getPmc() {
		return pmc;
	}

	public void setPmc(PanelModificarC pmc) {
		this.pmc = pmc;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}
