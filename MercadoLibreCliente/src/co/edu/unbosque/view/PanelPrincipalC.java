package co.edu.unbosque.view;

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
 * Clase que representa el panel principal de la aplicación.
 * Permite al usuario iniciar sesión, crear una cuenta o salir de la aplicación.
 */
public class PanelPrincipalC extends JPanel {
    /** Fondo del panel. */
    private JLabel fondo;
    /** Botón para iniciar sesión. */
    private JButton btnIniciarS;
    /** Botón para crear una cuenta. */
    private JButton btnCrearU;
    /** Botón para salir de la aplicación. */
    private JButton btnSalir;
    /** Botón para cambiar el idioma a español. */
    private JButton btnEspanol;
    /** Botón para cambiar el idioma a inglés. */
    private JButton btnIngles;
    /** Propiedades para la configuración del panel. */
    private Properties prop;

    /**
     * Constructor que inicializa el panel principal.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public PanelPrincipalC(Properties prop) throws IOException {
		
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		this.prop = prop;
		
		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondoidioma")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnIniciarS = new JButton();
		btnIniciarS.setBounds(140, 360, 290, 150);
		btnIniciarS.setText(prop.getProperty("archivospropiedad.boton.iniciarsesion"));
		btnIniciarS.setFocusable(false);
		btnIniciarS.setBackground(Color.WHITE);
		btnIniciarS.setForeground(Color.black);
		btnIniciarS.setBackground(new Color(235, 219, 79));
		btnIniciarS.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnIniciarS);

		btnCrearU = new JButton();
		btnCrearU.setBounds(500, 360, 290, 150);
		btnCrearU.setText(prop.getProperty("archivospropiedad.boton.crearcuenta"));
		btnCrearU.setFocusable(false);
		btnCrearU.setBackground(Color.WHITE);
		btnCrearU.setForeground(Color.black);
		btnCrearU.setBackground(new Color(235, 219, 79));
		btnCrearU.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnCrearU);

		btnSalir = new JButton();
		btnSalir.setBounds(860, 360, 290, 150);
		btnSalir.setText(prop.getProperty("archivospropiedad.boton.salir"));
		btnSalir.setFocusable(false);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.black);
		btnSalir.setBackground(new Color(246, 86, 86));
		btnSalir.setFont(new Font("Baloo", Font.BOLD, 35));
		add(btnSalir);

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

		add(fondo); // TODO Auto-generated constructor stub
	}

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
	public void actualizarComp() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondoidioma")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		
		btnIniciarS.setText(prop.getProperty("archivospropiedad.boton.iniciarsesion"));
		btnCrearU.setText(prop.getProperty("archivospropiedad.boton.crearcuenta"));
		btnSalir.setText(prop.getProperty("archivospropiedad.boton.salir"));
	}

    /**
     * Obtiene el fondo del panel.
     * 
     * @return JLabel que representa el fondo.
     */
	public JLabel getFondo() {
		return fondo;
	}

    /**
     * Establece el fondo del panel.
     * 
     * @param fondo JLabel que representa el fondo.
     */
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

    /**
     * Obtiene el botón para iniciar sesión.
     * 
     * @return JButton para iniciar sesión.
     */
	public JButton getBtnIniciarS() {
		return btnIniciarS;
	}

    /**
     * Establece el botón para iniciar sesión.
     * 
     * @param btnIniciarS JButton para iniciar sesión.
     */
	public void setBtnIniciarS(JButton btnIniciarS) {
		this.btnIniciarS = btnIniciarS;
	}

    /**
     * Obtiene el botón para crear una cuenta.
     * 
     * @return JButton para crear una cuenta.
     */
	public JButton getBtnCrearU() {
		return btnCrearU;
	}

    /**
     * Establece el botón para crear una cuenta.
     * 
     * @param btnCrearU JButton para crear una cuenta.
     */
	public void setBtnCrearU(JButton btnCrearU) {
		this.btnCrearU = btnCrearU;
	}

    /**
     * Obtiene el botón para salir de la aplicación.
     * 
     * @return JButton para salir de la aplicación.
     */
	public JButton getBtnSalir() {
		return btnSalir;
	}

    /**
     * Establece el botón para salir de la aplicación.
     * 
     * @param btnSalir JButton para salir de la aplicación.
     */
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

    /**
     * Obtiene el botón para cambiar el idioma a español.
     * 
     * @return JButton para cambiar el idioma a español.
     */
	public JButton getBtnEspanol() {
		return btnEspanol;
	}

    /**
     * Establece el botón para cambiar el idioma a español.
     * 
     * @param btnEspanol JButton para cambiar el idioma a español.
     */
	public void setBtnEspanol(JButton btnEspanol) {
		this.btnEspanol = btnEspanol;
	}

    /**
     * Obtiene el botón para cambiar el idioma a inglés.
     * 
     * @return JButton para cambiar el idioma a inglés.
     */
	public JButton getBtnIngles() {
		return btnIngles;
	}

    /**
     * Establece el botón para cambiar el idioma a inglés.
     * 
     * @param btnIngles JButton para cambiar el idioma a inglés.
     */
	public void setBtnIngles(JButton btnIngles) {
		this.btnIngles = btnIngles;
	}

    /**
     * Obtiene las propiedades del panel.
     * 
     * @return Properties con la configuración del panel.
     */
	public Properties getProp() {
		return prop;
	}

    /**
     * Establece las propiedades del panel.
     * 
     * @param prop Properties con la configuración del panel.
     */
	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
