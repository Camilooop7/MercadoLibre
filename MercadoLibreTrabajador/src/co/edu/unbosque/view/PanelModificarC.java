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
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * Clase la cual es llamada como Ventana y extiende JPanel 
 * lo que permite agregar botones y o componentes de interfaz grafica.
 * y creación de las variables con su nombre privadas.
 */
public class PanelModificarC extends JPanel {

	private JLabel fondo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea text;
	private String texto;
	private JScrollPane barraV;

	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelModificarC() throws IOException {
		/**
		 * Uso del setBounds para fijar la posción del panel setLayaout permite
		 * modificar manualmente los elementos.
		 */
		setBounds(166, 245, 950, 433);
		setLayout(null);

		/**
		 * Inicialización del JLabel BufferedImage con el objetivo de establecer la
		 * ubicación del archivo de la imagen dentro de los archivos. Image Redim
		 * redimenzionar las medidas establecidas de la imagen.
		 */
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelU.png"));
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
		btnModificar = new JButton();
		btnModificar.setBounds(778, 100, 120, 100);
		btnModificar.setFocusable(false);
		btnModificar.setBackground(new Color(0, 0, 0));
		btnModificar.setContentAreaFilled(false);
		btnModificar.setOpaque(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setVisible(true);
		add(btnModificar);
		
		/**
		 * En este caso se inicializa el Jbutton para su uso 
		 * .setbounds para definir el tamaño y posicion dentro del panel
		 * .setbackground se establece el color.
		 * .contentareafilled para que el area de boton sea transparente
		 * .borderpainted quitar el borde establecido preterminado del boton.
		 * .add añadir el boton.
		 */
		btnEliminar = new JButton();
		btnEliminar.setBounds(778, 260, 120, 100);
		btnEliminar.setFocusable(false);
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setVisible(true);
		add(btnEliminar);
		
		/**
		 * Inicialización del texto . .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		text = new JTextArea();
		text.setBounds(10, 90, 400, 420);
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
		 * Inicialización del texto  .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 */
		barraV = new JScrollPane(text);
		barraV.setBounds(10, 90, 750, 340);
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

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
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

	public JScrollPane getBarraV() {
		return barraV;
	}

	public void setBarraV(JScrollPane barraV) {
		this.barraV = barraV;
	}

}
