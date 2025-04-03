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
public class PanelCrearU extends JPanel {
	private JLabel fondo;
	private JTextField nombreUsuario;
	private JPasswordField contrasena1;
	private JPasswordField contrasena2;
	private JButton btnVolver;
	private JButton btnIngresar;
	private JLabel textNombre;
	private JLabel textContra1;
	private JLabel textContra2;
	private JLabel textEstandarContra;
	private JLabel textEstandarNombre;
	private JCheckBox mostrarContrasena;
	private JCheckBox mostrarContrasena2;
	private Properties prop;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelCrearU(Properties prop) throws IOException {
		
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
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.tc")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1300, 746, Image.SCALE_SMOOTH);
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
		btnVolver.setBounds(800, 600, 170, 50);
		btnVolver.setText(prop.getProperty("archivosdepropiedades.panel.crear.volver.u"));
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
		btnIngresar.setBounds(480, 600, 320, 50);
		btnIngresar.setText(prop.getProperty("archivosdepropiedades.panel.crear.crearusuario.u"));
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

		contrasena1 = new JPasswordField();
		contrasena1.setBounds(480, 400, 490, 60);
		contrasena1.setFont(new Font("Baloo", Font.BOLD, 26));
		mostrarContrasena = new JCheckBox();
		mostrarContrasena.setBounds(1020, 420, 25, 25);
		mostrarContrasena.setOpaque(false);
		mostrarContrasena.setContentAreaFilled(false);
		mostrarContrasena.setBorderPainted(false);
		mostrarContrasena.setFocusPainted(false);

		add(mostrarContrasena);
		add(contrasena1);

		contrasena2 = new JPasswordField();
		contrasena2.setBounds(480, 500, 490, 60);
		contrasena2.setFont(new Font("Baloo", Font.BOLD, 26));
		mostrarContrasena2 = new JCheckBox();
		mostrarContrasena2.setBounds(1020, 520, 25, 25);
		mostrarContrasena2.setOpaque(false);
		mostrarContrasena2.setContentAreaFilled(false);
		mostrarContrasena2.setBorderPainted(false);
		mostrarContrasena2.setFocusPainted(false);

		add(mostrarContrasena2);
		add(contrasena2);

		textNombre = new JLabel();
		textNombre.setBounds(230, 300, 400, 60);
		textNombre.setText(prop.getProperty("archivosdepropiedades.panel.crear.nombre.u"));
		textNombre.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textNombre);

		textContra1 = new JLabel();
		textContra1.setBounds(324, 400, 400, 60);
		textContra1.setText(prop.getProperty("archivosdepropiedades.panel.crear.contrasena.u"));
		textContra1.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textContra1);

		textContra2 = new JLabel();
		textContra2.setBounds(230, 500, 400, 60);
		textContra2.setText(prop.getProperty("archivosdepropiedades.panel.crear.contrasena.re"));
		textContra2.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textContra2);

		textEstandarNombre = new JLabel();
		textEstandarNombre.setBounds(480, 341, 400, 60);
		textEstandarNombre.setText(prop.getProperty("archivosdepropiedades.panel.crear.caracteres.u"));
		textEstandarNombre.setFont(new Font("Baloo", Font.BOLD, 10));
		add(textEstandarNombre);

		textEstandarContra = new JLabel();
		textEstandarContra.setBounds(480, 441, 800, 60);
		textEstandarContra.setText(prop.getProperty("archivosdepropiedades.panel.crear.caracterescontrasena.u"));
		textEstandarContra.setFont(new Font("Baloo", Font.BOLD, 10));
		add(textEstandarContra);

		add(fondo);

	}
	
	/**
	 * Metodo en el cual se llama a los getproperty en donde se llaman dentro de la clase
	 */
	public void actualizarComps() {
		btnVolver.setText(prop.getProperty("archivosdepropiedades.panel.crear.volver.u"));
		btnIngresar.setText(prop.getProperty("archivosdepropiedades.panel.crear.crearusuario.u"));
		textNombre.setText(prop.getProperty("archivosdepropiedades.panel.crear.nombre.u"));
		textContra1.setText(prop.getProperty("archivosdepropiedades.panel.crear.contrasena.u"));
		textContra2.setText(prop.getProperty("archivosdepropiedades.panel.crear.contrasena.re"));
		textEstandarNombre.setText(prop.getProperty("archivosdepropiedades.panel.crear.caracteres.u"));
		textEstandarContra.setText(prop.getProperty("archivosdepropiedades.panel.crear.caracterescontrasena.u"));
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

	public String getContrasena1() {
		char[] contrasena = contrasena1.getPassword();
		return new String(contrasena);
	}

	public void setContrasena1(JPasswordField contrasena1) {
		this.contrasena1 = contrasena1;
	}

	public String getContrasena2() {
		char[] contrasena = contrasena2.getPassword();
		return new String(contrasena);
	}

	public JPasswordField getContrasena1F() {
		return this.contrasena1;
	}

	public JPasswordField getContrasena2F() {
		return this.contrasena2;
	}

	public void setContrasena2(JPasswordField contrasena2) {
		this.contrasena2 = contrasena2;
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

	public JLabel getTextContra1() {
		return textContra1;
	}

	public void setTextContra1(JLabel textContra1) {
		this.textContra1 = textContra1;
	}

	public JLabel getTextContra2() {
		return textContra2;
	}

	public void setTextContra2(JLabel textContra2) {
		this.textContra2 = textContra2;
	}

	public JLabel getTextEstandarContra() {
		return textEstandarContra;
	}

	public void setTextEstandarContra(JLabel textEstandarContra) {
		this.textEstandarContra = textEstandarContra;
	}

	public JLabel getTextEstandarNombre() {
		return textEstandarNombre;
	}

	public void setTextEstandarNombre(JLabel textEstandarNombre) {
		this.textEstandarNombre = textEstandarNombre;
	}

	public JCheckBox getMostrarContrasena() {
		return mostrarContrasena;
	}

	public void setMostrarContrasena(JCheckBox mostrarContrasena) {
		this.mostrarContrasena = mostrarContrasena;
	}

	public JCheckBox getMostrarContrasena2() {
		return mostrarContrasena2;
	}

	public void setMostrarContrasena2(JCheckBox mostrarContrasena2) {
		this.mostrarContrasena2 = mostrarContrasena2;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}
