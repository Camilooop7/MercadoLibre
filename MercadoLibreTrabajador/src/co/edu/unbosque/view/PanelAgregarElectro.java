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
public class PanelAgregarElectro extends JPanel {

	private JLabel fondo;
	private JButton btnAgregar;
	private JLabel textNombre;
	private JTextField nombre;
	private JLabel textPrecio;
	private JSpinner precio;
	private JLabel textPortatil;
	private JRadioButton siD;
	private JRadioButton noD;
	private JLabel textFuenteEnergia;
	private JTextField fuenteEnergia;
	private int a = 0;

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelAgregarElectro() throws IOException {

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
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelAgregar.png"));
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
		textNombre.setText("Nombre: ");
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
		textPrecio.setText("Precio: ");
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
		textPortatil = new JLabel();
		textPortatil.setBounds(50, 190, 400, 60);
		textPortatil.setText("¿Es Portatil? ");
		textPortatil.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textPortatil);

		/**
		 * radio button es para seleccionar un boton circular si existen varias opciones
		 * .bound para establecer el tamaño
		 * .font establecer el tipo y tamaño de la letra
		 * .borderpainte establcer e elimnar el borde
		 * .contentareafilledestablecer su limite de texto
		 */
		siD = new JRadioButton("SI");
		siD.setBounds(257, 210, 80, 30); // Ajustar el tamaño para que el texto sea visible
		siD.setFont(new Font("Baloo", Font.BOLD, 15));
		siD.setOpaque(false);
		siD.setContentAreaFilled(false);
		siD.setBorderPainted(false);
		siD.setFocusPainted(false);
		add(siD);

		/**
		 * radio button es para seleccionar un boton circular si existen varias opciones
		 * .bound para establecer el tamaño
		 * .font establecer el tipo y tamaño de la letra
		 * .borderpainte establcer e elimnar el borde
		 * .contentareafilledestablecer su limite de texto
		 */
		noD = new JRadioButton("NO");
		noD.setBounds(340, 210, 80, 30); // Ajustar el tamaño para que el texto sea visible
		noD.setFont(new Font("Baloo", Font.BOLD, 15));
		noD.setOpaque(false);
		noD.setContentAreaFilled(false);
		noD.setBorderPainted(false);
		noD.setFocusPainted(false);
		add(noD);

		/**
		 *  Agrupar los JRadioButton
		 */
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(siD);
		grupo.add(noD);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. 
		 */
		textFuenteEnergia = new JLabel();
		textFuenteEnergia.setBounds(42, 265, 400, 60);
		textFuenteEnergia.setText("Fuente de energia: ");
		textFuenteEnergia.setFont(new Font("Baloo", Font.BOLD, 22));
		add(textFuenteEnergia);

		/**
		 * Inicialización del texto con Jtextfield. 
		 *.set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. 
		 */
		fuenteEnergia = new JTextField();
		fuenteEnergia.setBounds(255, 270, 330, 50);
		fuenteEnergia.setFont(new Font("Baloo", Font.BOLD, 23));
		add(fuenteEnergia);

		add(fondo);
	}

	/**
	 * Getters & Stters
	 * @return fondo
	 */
	public JLabel getFondo() {
		return fondo;
	}

	/**
	 * 
	 * @param fondo
	 */
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	/**
	 * 
	 * @return btnAgregar
	 */
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	/**
	 * 
	 * @param btnAgregar
	 */
	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	/**
	 * 
	 * @return textNombre
	 */
	public JLabel getTextNombre() {
		return textNombre;
	}
 
	/**
	 * 
	 * @param textNombre
	 */
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

	public JLabel getTextPortatil() {
		return textPortatil;
	}

	public void setTextPortatil(JLabel textPortatil) {
		this.textPortatil = textPortatil;
	}

	public JRadioButton getSiD() {
		return siD;
	}

	public void setSiD(JRadioButton siD) {
		this.siD = siD;
	}

	public JRadioButton getNoD() {
		return noD;
	}

	public void setNoD(JRadioButton noD) {
		this.noD = noD;
	}

	public JLabel getTextFuenteEnergia() {
		return textFuenteEnergia;
	}

	public void setTextFuenteEnergia(JLabel textFuenteEnergia) {
		this.textFuenteEnergia = textFuenteEnergia;
	}

	public String getFuenteEnergia() {
		return (String) fuenteEnergia.getText();
	}

	public void setFuenteEnergia(JTextField fuenteEnergia) {
		this.fuenteEnergia = fuenteEnergia;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	

}