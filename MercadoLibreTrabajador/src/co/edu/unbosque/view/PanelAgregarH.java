package co.edu.unbosque.view;

/**
 * 
 * Importanción de las librerias para el uso de imagenes, texto, botones, colores, paneles.
 */
import java.awt.Color;
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

/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelAgregarH extends JPanel {

	private JLabel fondo;
	private JButton btnCocina;
	private JButton btnBano;
	private Properties prop;

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelAgregarH(Properties prop) throws IOException {

		/**
		 * Uso del setBounds para fijar la posción del panel setLayaout permite
		 * modificar manualmente los elementos.
		 */
		setBounds(412, 250, 780, 433);
		setLayout(null);
		this.prop = prop;

		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondohogar")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnCocina = new JButton();
		btnCocina.setBounds(140, 128, 182, 180);
		btnCocina.setFocusable(false);
		btnCocina.setBackground(new Color(0, 0, 0));
		btnCocina.setContentAreaFilled(false);
		btnCocina.setOpaque(false);
		btnCocina.setBorderPainted(false);
		btnCocina.setVisible(true);
		add(btnCocina);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnBano = new JButton();
		btnBano.setBounds(440, 128, 182, 180);
		btnBano.setFocusable(false);
		btnBano.setBackground(new Color(0, 0, 0));
		btnBano.setContentAreaFilled(false);
		btnBano.setOpaque(false);
		btnBano.setBorderPainted(false);
		btnBano.setVisible(true);
		add(btnBano);

		add(fondo);

	}
	
	public void actualizarComps() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondohogar")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
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

	public JButton getBtnCocina() {
		return btnCocina;
	}

	public void setBtnCocina(JButton btnCocina) {
		this.btnCocina = btnCocina;
	}

	public JButton getBtnBano() {
		return btnBano;
	}

	public void setBtnBano(JButton btnBano) {
		this.btnBano = btnBano;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}
