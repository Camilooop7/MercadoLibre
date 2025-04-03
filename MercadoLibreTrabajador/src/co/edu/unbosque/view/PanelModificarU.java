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


/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelModificarU extends JPanel {

	private JLabel fondo;
	private JButton btnTrabajador;
	private JButton btnCliente;
	private Properties prop;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelModificarU(Properties prop) throws IOException {
		setBounds(166, 245, 950, 433);
		setLayout(null);
		
		this.prop = prop;

		
		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoUs.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(950, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 950, 433);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnTrabajador = new JButton();
		btnTrabajador.setBounds(150, 140, 200, 150);
		btnTrabajador.setFocusable(false);
		btnTrabajador.setBackground(new Color(0, 0, 0));
		btnTrabajador.setContentAreaFilled(false);
		btnTrabajador.setOpaque(false);
		btnTrabajador.setBorderPainted(false);
		btnTrabajador.setVisible(true);
		add(btnTrabajador);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnCliente = new JButton();
		btnCliente.setBounds(545, 140, 260, 155);
		btnCliente.setFocusable(false);
		btnCliente.setBackground(new Color(0, 0, 0));
		btnCliente.setContentAreaFilled(false);
		btnCliente.setOpaque(false);
		btnCliente.setBorderPainted(false);
		btnCliente.setVisible(true);
		add(btnCliente);

		add(fondo);

	}
	
	/**
	 * Meotodo el cual redimienciona la imagen del panel y su creación
	 * @throws IOException
	 */
	public void actualizarComps() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.user")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(950, 433, Image.SCALE_SMOOTH);
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

	public JButton getBtnTrabajador() {
		return btnTrabajador;
	}

	public void setBtnTrabajador(JButton btnTrabajador) {
		this.btnTrabajador = btnTrabajador;
	}

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	
	

}
