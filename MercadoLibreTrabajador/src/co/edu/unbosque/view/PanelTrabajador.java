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
public class PanelTrabajador extends JPanel {

	private JLabel fondo;
	private JButton btnAnadir;
	private JButton btnModificarProducto;
	private JButton btnEliminarProducto;
	private JButton btnModificarUsuario;
	private JButton btnSalir;
	private Properties prop;

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelTrabajador(Properties prop) throws IOException {

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
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.pt")));
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
		btnAnadir = new JButton();
		btnAnadir.setBounds(75, 323, 210, 214);
		btnAnadir.setFocusable(false);
		btnAnadir.setBackground(new Color(0, 0, 0));
		btnAnadir.setContentAreaFilled(false);
		btnAnadir.setOpaque(false);
		btnAnadir.setBorderPainted(false);
		btnAnadir.setVisible(true);
		add(btnAnadir);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnModificarProducto = new JButton();
		btnModificarProducto.setBounds(372, 323, 214, 224);
		btnModificarProducto.setFocusable(false);
		btnModificarProducto.setBackground(new Color(0, 0, 0, 0));
		btnModificarProducto.setContentAreaFilled(false);
		btnModificarProducto.setOpaque(false);
		btnModificarProducto.setBorderPainted(false);
		btnModificarProducto.setVisible(true);
		add(btnModificarProducto);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnEliminarProducto = new JButton();
		btnEliminarProducto.setBounds(666, 323, 216, 224);
		btnEliminarProducto.setFocusable(false);
		btnEliminarProducto.setBackground(new Color(0, 0, 0));
		btnEliminarProducto.setContentAreaFilled(false);
		btnEliminarProducto.setOpaque(false);
		btnEliminarProducto.setBorderPainted(false);
		btnEliminarProducto.setVisible(true);
		add(btnEliminarProducto);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnModificarUsuario = new JButton();
		btnModificarUsuario.setBounds(960, 323, 219, 224);
		btnModificarUsuario.setFocusable(false);
		btnModificarUsuario.setBackground(new Color(0, 0, 0));
		btnModificarUsuario.setContentAreaFilled(false);
		btnModificarUsuario.setOpaque(false);
		btnModificarUsuario.setBorderPainted(false);
		btnModificarUsuario.setVisible(true);
		add(btnModificarUsuario);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnSalir = new JButton();
		btnSalir.setBounds(1092, 71, 130, 97);
		btnSalir.setFocusable(false);
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setContentAreaFilled(false);
		btnSalir.setOpaque(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setVisible(true);
		add(btnSalir);

		add(fondo);

	}
	
	/**
	 * Meotodo el cual redimienciona la imagen del panel y su creación
	 * @throws IOException
	 */
	public void actualizarComps() throws IOException{
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.pt")));
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

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JButton getBtnModificarProducto() {
		return btnModificarProducto;
	}

	public void setBtnModificarProducto(JButton btnModificarProducto) {
		this.btnModificarProducto = btnModificarProducto;
	}

	public JButton getBtnEliminarProducto() {
		return btnEliminarProducto;
	}

	public void setBtnEliminarProducto(JButton btnEliminarProducto) {
		this.btnEliminarProducto = btnEliminarProducto;
	}

	public JButton getBtnModificarUsuario() {
		return btnModificarUsuario;
	}

	public void setBtnModificarUsuario(JButton btnModificarUsuario) {
		this.btnModificarUsuario = btnModificarUsuario;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	

}
