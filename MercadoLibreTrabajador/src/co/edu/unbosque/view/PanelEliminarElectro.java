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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelEliminarElectro extends JPanel {
	private JLabel fondo;
	private JButton eliminar;
	private JTextArea text;
	private String texto;
	private JScrollPane barraV;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelEliminarElectro() throws IOException {
		
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
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelEliminar.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		
		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		eliminar = new JButton();
		eliminar.setBounds(618, 295, 120, 118);
		eliminar.setFocusable(false);
		eliminar.setBackground(new Color(0, 0, 0));
		eliminar.setContentAreaFilled(false);
		eliminar.setOpaque(false);
		eliminar.setBorderPainted(false);
		eliminar.setVisible(true);
		add(eliminar);

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		text = new JTextArea();
		text.setBounds(10, 10, 400, 420);
		text.setFocusable(false);
		text.setText(texto);
		text.setBackground(new Color(198, 195, 195));
		text.setOpaque(false);
		text.setFont(new Font("Baloo", Font.BOLD, 20));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		add(text);

		UIManager.put("ScrollBar.background", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.foreground", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumb", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.track", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.trackForeground", new ColorUIResource(217, 217, 217));

		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		barraV = new JScrollPane(text);
		barraV.setBounds(10, 10, 750, 420);
		barraV.setBackground(new Color(198, 195, 195));
		barraV.setOpaque(false);
		barraV.setBorder(null); // Eliminar el borde para mayor transparencia
		barraV.getViewport().setOpaque(false); // Hacer el viewport transparente
		add(barraV);

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

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		text.setText(texto);
	}

}
