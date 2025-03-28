
/**
 * Este paquete contiene las clases relacionadas con la interfaz gráfica de usuario
 * para la aplicación de gestión de baños. Incluye paneles, botones, y otros componentes
 * visuales necesarios para la interacción del usuario.
 */
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
public class PanelActualizarBano extends JPanel {
	private JLabel fondo;
	private JButton actualizar;
	private JTextArea text;
	private String texto;
	private JScrollPane barraV;

	
	/**
	 * Constructor del panel donde se ejecuta la logica en general de cada parametro
	 * que se encuentra en la ventana. además se declara la excepción de
	 * IOexception.
	 */
	public PanelActualizarBano() throws IOException {
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
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelActualizar.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		
		/**
		 * Inicialización del boton .setBounds su ubicación definida dentro del panel.
		 * .setFocusable con el objetivo de mantener desactivada su función.
		 * .setBackground establcer el color que se encuentra en el fondo del boton.
		 * .setBorderPainted para que el fondo predeterminaod de java no aparezca y el boton no tenga fondo.
		 * .setOpaque vizualización detras del boton.
		 */
		actualizar = new JButton();
		actualizar.setBounds(618, 295, 120, 118);
		actualizar.setFocusable(false);
		actualizar.setBackground(new Color(0, 0, 0));
		actualizar.setContentAreaFilled(false);
		actualizar.setOpaque(false);
		actualizar.setBorderPainted(false);
		actualizar.setVisible(true);
		add(actualizar);
		
		/**
		 * Inicialización del texto con JLabel. .set text para agregar la opción de
		 * establcer un texto. .set Bounds establecer la ubicación. .setFont establecer
		 * el tamaño y tipo de letra del texto. .setOpaque vizualización detras del texto.
		 * .setLineWrap se utiliza para que el texto cuando llegue al limite tenga un retorno y no continue de largo.
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

		/**
		 * UIManager import tiene como objetivo modificar simultaneamente cada panel.
		 * En este caso .background para cambiar el color 
		 * .thumb cambia el color de la barra la cual selecciona el usuario.
		 * .thumbshadow establece la sombra del thumb elemento el cual es seleccionado por el usuario.
		 * .trackForeground cambia el color del riel de la barra.
		 */
		UIManager.put("ScrollBar.background", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.foreground", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumb", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.track", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.trackForeground", new ColorUIResource(217, 217, 217));
		

		/**
		 * Inicialización del scrollpane en el cual se determina la dimensión de los componentes fijados 
		 * que se encuentra dentro de la barra de movimiento
		 * .bounds establecer el tamaño del sector 
		 * .
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

	
	// GETTERS & SETTERS
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}



	public JButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}

	public JScrollPane getBarraV() {
		return barraV;
	}

	public void setBarraV(JScrollPane barraV) {
		this.barraV = barraV;
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
