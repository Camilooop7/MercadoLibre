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
public class PanelAgregarOficina extends JPanel {

	private JLabel fondo;
	private JButton btnElectrodomestico;
	private JButton btnPapeleria;
	private Properties prop;

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelAgregarOficina(Properties prop) throws IOException {

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
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoOficina.png"));
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
		btnElectrodomestico = new JButton();
		btnElectrodomestico.setBounds(120, 128, 182, 180);
		btnElectrodomestico.setFocusable(false);
		btnElectrodomestico.setBackground(new Color(0, 0, 0));
		btnElectrodomestico.setContentAreaFilled(false);
		btnElectrodomestico.setOpaque(false);
		btnElectrodomestico.setBorderPainted(false);
		btnElectrodomestico.setVisible(true);
		add(btnElectrodomestico);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnPapeleria = new JButton();
		btnPapeleria.setBounds(460, 128, 182, 180);
		btnPapeleria.setFocusable(false);
		btnPapeleria.setBackground(new Color(0, 0, 0));
		btnPapeleria.setContentAreaFilled(false);
		btnPapeleria.setOpaque(false);
		btnPapeleria.setBorderPainted(false);
		btnPapeleria.setVisible(true);
		add(btnPapeleria);

		add(fondo);

	}
	
	public void actualizarComps() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondooficina")));
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

	public JButton getBtnElectrodomestico() {
		return btnElectrodomestico;
	}

	public void setBtnElectrodomestico(JButton btnElectrodomestico) {
		this.btnElectrodomestico = btnElectrodomestico;
	}

	public JButton getBtnPapeleria() {
		return btnPapeleria;
	}

	public void setBtnPapeleria(JButton btnPapeleria) {
		this.btnPapeleria = btnPapeleria;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	
	
}
