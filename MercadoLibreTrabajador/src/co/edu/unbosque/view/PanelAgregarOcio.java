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
public class PanelAgregarOcio extends JPanel {
	
	private JLabel fondo;
	private JButton btnVideoJuego;
	private JButton btnDeporte;
	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelAgregarOcio()throws IOException {

		/**
		 * Uso del setBounds para fijar la posción del panel setLayaout permite
		 * modificar manualmente los elementos.
		 */
		setBounds(412, 250, 780, 433);
		setLayout(null);

		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoOcio.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		btnVideoJuego = new JButton();
		btnVideoJuego.setBounds(133, 128, 182, 180);
		btnVideoJuego.setFocusable(false);
		btnVideoJuego.setBackground(new Color(0, 0, 0));
		btnVideoJuego.setContentAreaFilled(false);
		btnVideoJuego.setOpaque(false);
		btnVideoJuego.setBorderPainted(false);
		btnVideoJuego.setVisible(true);
		add(btnVideoJuego);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnDeporte = new JButton();
		btnDeporte.setBounds(460, 128, 182, 180);
		btnDeporte.setFocusable(false);
		btnDeporte.setBackground(new Color(0, 0, 0));
		btnDeporte.setContentAreaFilled(false);
		btnDeporte.setOpaque(false);
		btnDeporte.setBorderPainted(false);
		btnDeporte.setVisible(true);
		add(btnDeporte);

		add(fondo);

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

	public JButton getBtnVideoJuego() {
		return btnVideoJuego;
	}

	public void setBtnVideoJuego(JButton btnVideoJuego) {
		this.btnVideoJuego = btnVideoJuego;
	}

	public JButton getBtnDeporte() {
		return btnDeporte;
	}

	public void setBtnDeporte(JButton btnDeporte) {
		this.btnDeporte = btnDeporte;
	}

}
