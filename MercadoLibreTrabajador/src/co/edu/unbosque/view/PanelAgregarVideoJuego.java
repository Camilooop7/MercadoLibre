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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelAgregarVideoJuego extends JPanel {

	private JLabel fondo;
	private JButton btnAgregar;
	private JLabel textNombre;
	private JTextField nombre;
	private JLabel textPrecio;
	private JSpinner precio;
	private JLabel textAccesorio;
	private JRadioButton siA;
	private JRadioButton noA;
	private JLabel textRefeciaConsola;
	private JTextField referenciaConsola;
	int a = 0;
	private Properties prop;

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelAgregarVideoJuego(Properties prop) throws IOException {

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
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.panel.agre")));
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
		btnAgregar = new JButton();
		btnAgregar.setBounds(625, 298, 112, 112);
		btnAgregar.setFocusable(false);
		btnAgregar.setBackground(new Color(0, 0, 0));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setVisible(true);
		add(btnAgregar);
		
		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		textNombre = new JLabel();
		textNombre.setBounds(44, 40, 150, 60);
		textNombre.setText(prop.getProperty("archivosdepropiedades.panel.principal.nombre"));
		textNombre.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textNombre);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		nombre = new JTextField();
		nombre.setBounds(140, 40, 490, 50);
		nombre.setFont(new Font("Baloo", Font.BOLD, 24));
		add(nombre);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		textPrecio = new JLabel();
		textPrecio.setBounds(50, 130, 150, 60);
		textPrecio.setText(prop.getProperty("archivosdepropiedades.panel.principal.precio"));
		textPrecio.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textPrecio);

		/**
		 * Se inicializa el JSpinner para la selección de numeros 
		 */
		precio = new JSpinner();
		precio.setBounds(140, 130, 490, 50);
		precio.setFont(new Font("Baloo", Font.BOLD, 24));
		add(precio);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		textAccesorio = new JLabel();
		textAccesorio.setBounds(50, 190, 400, 60);
		textAccesorio.setText(prop.getProperty("archivosdepropiedades.panel.agregar.videojuego.esaccesorio"));
		textAccesorio.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textAccesorio);

		/**
		 * radio button es para seleccionar un boton circular si existen varias opciones
		 * .bound para establecer el tamaño
		 * .font establecer el tipo y tamaño de la letra
		 * .borderpainte establcer e elimnar el borde
		 * .contentareafilledestablecer su limite de texto
		 */
		siA = new JRadioButton("TRUE");
		siA.setBounds(257, 210, 80, 30); // Ajustar el tamaño para que el texto sea visible
		siA.setFont(new Font("Baloo", Font.BOLD, 15));
		siA.setOpaque(false);
		siA.setContentAreaFilled(false);
		siA.setBorderPainted(false);
		siA.setFocusPainted(false);
		add(siA);

		/**
		 * radio button es para seleccionar un boton circular si existen varias opciones
		 * .bound para establecer el tamaño
		 * .font establecer el tipo y tamaño de la letra
		 * .borderpainte establcer e elimnar el borde
		 * .contentareafilledestablecer su limite de texto
		 */
		noA = new JRadioButton("FALSE");
		noA.setBounds(340, 210, 80, 30); // Ajustar el tamaño para que el texto sea visible
		noA.setFont(new Font("Baloo", Font.BOLD, 15));
		noA.setOpaque(false);
		noA.setContentAreaFilled(false);
		noA.setBorderPainted(false);
		noA.setFocusPainted(false);
		add(noA);

		/**
		 *  Agrupar los JRadioButton
		 */
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(siA);
		grupo.add(noA);
		
		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. 
		 */
		textRefeciaConsola = new JLabel();
		textRefeciaConsola.setBounds(30, 270, 220, 60);
		textRefeciaConsola.setText(prop.getProperty("archivosdepropiedades.panel.agregar.videojuego.referenciaconsola"));
		textRefeciaConsola.setFont(new Font("Baloo", Font.BOLD, 22));
		add(textRefeciaConsola);

		/**
		 * Inicialización del texto con Jtextfield. 
		 *.set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. 
		 */
		referenciaConsola = new JTextField();
		referenciaConsola.setBounds(270, 270, 340, 50);
		referenciaConsola.setFont(new Font("Baloo", Font.BOLD, 24));
		add(referenciaConsola);

		

		add(fondo);
	}
	
	public void actualizarComps() {
		textNombre.setText(prop.getProperty("archivosdepropiedades.panel.principal.nombre"));
		textPrecio.setText(prop.getProperty("archivosdepropiedades.panel.principal.precio"));
		textAccesorio.setText(prop.getProperty("archivosdepropiedades.panel.agregar.videojuego.esaccesorio"));
		textRefeciaConsola.setText(prop.getProperty("archivosdepropiedades.panel.agregar.videojuego.referenciaconsola"));
		
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

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JLabel getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JLabel textNombre) {
		this.textNombre = textNombre;
	}

	public String getNombre() {
		return (String) nombre.getText();
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JLabel getTextPrecio() {
		return textPrecio;
	}

	public void setTextPrecio(JLabel textPrecio) {
		this.textPrecio = textPrecio;
	}

	public int getPrecio() {
		return (int) precio.getValue();
	}

	public void setPrecio(JSpinner precio) {
		this.precio = precio;
	}

	public JLabel getTextAccesorio() {
		return textAccesorio;
	}

	public void setTextAccesorio(JLabel textAccesorio) {
		this.textAccesorio = textAccesorio;
	}

	public JRadioButton getSiA() {
		return siA;
	}

	public void setSiA(JRadioButton siA) {
		this.siA = siA;
	}

	public JRadioButton getNoA() {
		return noA;
	}

	public void setNoA(JRadioButton noA) {
		this.noA = noA;
	}

	public JLabel getTextRefeciaConsola() {
		return textRefeciaConsola;
	}

	public void setTextRefeciaConsola(JLabel textRefeciaConsola) {
		this.textRefeciaConsola = textRefeciaConsola;
	}

	public String getReferenciaConsola() {
		return (String) referenciaConsola.getText();
	}

	public void setReferenciaConsola(JTextField referenciaConsola) {
		this.referenciaConsola = referenciaConsola;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}