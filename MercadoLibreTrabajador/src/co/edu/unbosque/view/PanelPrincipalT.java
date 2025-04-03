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
public class PanelPrincipalT extends JPanel {
	
	
	private JLabel fondo;
	private JButton btnIniciarS;
	private JButton btnCrearU;
	private JButton btnSalir;
	private JButton btnEspanol, btnIngles;
	private Properties prop;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelPrincipalT(Properties prop) throws IOException {
		
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		this.prop = prop;
		
		
		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.t")));
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
		btnIniciarS = new JButton();
		btnIniciarS.setBounds(140, 360, 290, 150);
		btnIniciarS.setText(prop.getProperty("archivosdepropiedades.panel.principal.sesioni"));
		btnIniciarS.setFocusable(false);
		btnIniciarS.setBackground(Color.WHITE);
		btnIniciarS.setForeground(Color.black);
		btnIniciarS.setBackground(new Color(235, 219, 79));
		btnIniciarS.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnIniciarS);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnCrearU = new JButton();
		btnCrearU.setBounds(500, 360, 290, 150);
		btnCrearU.setText(prop.getProperty("archivosdepropiedades.panel.principal.crearc"));
		btnCrearU.setFocusable(false);
		btnCrearU.setBackground(Color.WHITE);
		btnCrearU.setForeground(Color.black);
		btnCrearU.setBackground(new Color(235, 219, 79));
		btnCrearU.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnCrearU);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnSalir = new JButton();
		btnSalir.setBounds(860, 360, 290, 150);
		btnSalir.setText(prop.getProperty("archivosdepropiedades.panel.principal.exit"));
		btnSalir.setFocusable(false);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.black);
		btnSalir.setBackground(new Color(246, 86, 86));
		btnSalir.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnSalir);

		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnEspanol = new JButton();
		btnEspanol.setBounds(1190, 75, 85, 90);
		btnEspanol.setFocusable(false);
		btnEspanol.setBackground(Color.WHITE);
		btnEspanol.setBackground(new Color(246, 86, 86));
		btnEspanol.setContentAreaFilled(false);
		btnEspanol.setOpaque(false);
		btnEspanol.setBorderPainted(false);
		btnEspanol.setVisible(true);
		add(btnEspanol);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnIngles = new JButton();
		btnIngles.setBounds(1095, 75, 87, 90);
		btnIngles.setContentAreaFilled(false);
		btnIngles.setOpaque(false);
		btnIngles.setVisible(true);
		btnIngles.setBorderPainted(false);
		btnIngles.setFocusable(false);
		btnIngles.setBackground(Color.WHITE);
		btnIngles.setBackground(new Color(246, 86, 86));
		add(btnIngles);
		
		
		add(fondo); 
	}
	
	/**
	 * Meotodo el cual redimienciona la imagen del panel y su creación
	 * @throws IOException
	 */
	public void actualizarComps() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.t")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		
		btnIniciarS.setText(prop.getProperty("archivosdepropiedades.panel.principal.sesioni"));
		btnCrearU.setText(prop.getProperty("archivosdepropiedades.panel.principal.crearc"));
		btnSalir.setText(prop.getProperty("archivosdepropiedades.panel.principal.exit"));
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

	public JButton getBtnIniciarS() {
		return btnIniciarS;
	}

	public void setBtnIniciarS(JButton btnIniciarS) {
		this.btnIniciarS = btnIniciarS;
	}

	public JButton getBtnCrearU() {
		return btnCrearU;
	}

	public void setBtnCrearU(JButton btnCrearU) {
		this.btnCrearU = btnCrearU;
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

	public JButton getBtnEspanol() {
		return btnEspanol;
	}

	public void setBtnEspanol(JButton btnEspanol) {
		this.btnEspanol = btnEspanol;
	}

	public JButton getBtnIngles() {
		return btnIngles;
	}

	public void setBtnIngles(JButton btnIngles) {
		this.btnIngles = btnIngles;
	}
	
	

}
