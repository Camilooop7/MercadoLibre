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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelIniciarSesion extends JPanel {

	private JLabel fondo;
	private JTextField nombreUsuario;
	private JPasswordField contrasena;
	private JButton btnVolver;
	private JButton btnIngresar;
	private JLabel textNombre;
	private JLabel textContra;
	private JLabel textEstandar;
	private JCheckBox mostrarContrasena;
	private Properties prop;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelIniciarSesion(Properties prop) throws IOException {
		
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
		btnVolver = new JButton();
		btnVolver.setBounds(800, 530, 170, 50);
		btnVolver.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.volver"));
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.black);
		btnVolver.setBackground(new Color(246, 86, 86));
		btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnVolver);

		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnIngresar = new JButton();
		btnIngresar.setBounds(480, 530, 320, 50);
		btnIngresar.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.ingresar"));
		btnIngresar.setFocusable(false);
		btnIngresar.setForeground(Color.black);
		btnIngresar.setBackground(new Color(235, 219, 79));
		btnIngresar.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnIngresar);

		
		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(480, 300, 490, 60);
		nombreUsuario.setFont(new Font("Baloo", Font.BOLD, 26));
		add(nombreUsuario);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		contrasena = new JPasswordField();
		contrasena.setBounds(480, 400, 490, 60);
		contrasena.setFont(new Font("Baloo", Font.BOLD, 26));
		mostrarContrasena= new JCheckBox();
		mostrarContrasena.setBounds(1020, 420, 25, 25);
		mostrarContrasena.setOpaque(false);
		mostrarContrasena.setContentAreaFilled(false);
		mostrarContrasena.setBorderPainted(false);
		mostrarContrasena.setFocusPainted(false);

		add(mostrarContrasena);
		add(contrasena);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		textNombre = new JLabel();
		textNombre.setBounds(230, 300, 400, 60);
		textNombre.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.nombreusuario"));
		textNombre.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textNombre);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		textContra = new JLabel();
		textContra.setBounds(324, 400, 400, 60);
		textContra.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.contrasena"));
		textContra.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textContra);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		textEstandar = new JLabel();
		textEstandar.setBounds(480, 441, 800, 60);
		textEstandar.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.caracteres"));
		textEstandar.setFont(new Font("Baloo", Font.BOLD, 10));
		add(textEstandar);

		add(fondo);

	}
	
	/**
	 * Metodo en el cual se llama a los getproperty en donde se llaman dentro de la clase
	 */
	public void actualizarComps() {
		btnVolver.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.volver"));
		btnIngresar.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.ingresar"));
		textNombre.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.nombreusuario"));
		textContra.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.contrasena"));
		textEstandar.setText(prop.getProperty("archivosdepropiedades.panel.iniciarsesion.caracteres"));
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

	public String getNombreUsuario() {
		return (String) nombreUsuario.getText();
	}

	public void setNombreUsuario(JTextField nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		char[] con = contrasena.getPassword();
		return new String(con);
	}

	public JPasswordField getContrasenaF() {
		return this.contrasena;
	}
	
	public void setContrasena(JPasswordField contrasena) {
		this.contrasena = contrasena;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JLabel getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JLabel textNombre) {
		this.textNombre = textNombre;
	}

	public JLabel getTextContra() {
		return textContra;
	}

	public void setTextContra(JLabel textContra) {
		this.textContra = textContra;
	}

	public JLabel getTextEstandar() {
		return textEstandar;
	}

	public void setTextEstandar(JLabel textEstandar) {
		this.textEstandar = textEstandar;
	}

	public JCheckBox getMostrarContrasena() {
		return mostrarContrasena;
	}

	public void setMostrarContrasena(JCheckBox mostrarContrasena) {
		this.mostrarContrasena = mostrarContrasena;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	
}
