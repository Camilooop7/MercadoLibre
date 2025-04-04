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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que representa el panel para crear un usuario.
 * Permite al usuario ingresar un nombre de usuario y establecer una contraseña.
 */
public class PanelCrearU extends JPanel {
    /** Fondo del panel. */
    private JLabel fondo;
    /** Campo de texto para el nombre de usuario. */
    private JTextField nombreUsuario;
    /** Campo de texto para la primera contraseña. */
    private JPasswordField contrasena1;
    /** Campo de texto para la segunda contraseña (confirmación). */
    private JPasswordField contrasena2;
    /** Botón para volver al menú anterior. */
    private JButton btnVolver;
    /** Botón para confirmar la creación del usuario. */
    private JButton btnIngresar;
    /** Etiqueta para el texto del nombre de usuario. */
    private JLabel textNombre;
    /** Etiqueta para el texto de la primera contraseña. */
    private JLabel textContra1;
    /** Etiqueta para el texto de la segunda contraseña. */
    private JLabel textContra2;
    /** Etiqueta para los requisitos del nombre de usuario. */
    private JLabel textEstandarNombre;
    /** Etiqueta para los requisitos de la contraseña. */
    private JLabel textEstandarContra;
    /** Checkbox para mostrar la primera contraseña. */
    private JCheckBox mostrarContrasena;
    /** Checkbox para mostrar la segunda contraseña. */
    private JCheckBox mostrarContrasena2;
    /** Propiedades para la configuración del panel. */
    private Properties prop;

    /**
     * Constructor que inicializa el panel para crear un usuario.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public PanelCrearU(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1290, 750);
        setLayout(null);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovacio")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1290, 750);

        btnVolver = new JButton();
        btnVolver.setBounds(800, 600, 170, 50);
        btnVolver.setText(prop.getProperty("archivospropiedad.boton.volver"));
        btnVolver.setFocusable(false);
        btnVolver.setForeground(Color.black);
        btnVolver.setBackground(new Color(246, 86, 86));
        btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
        add(btnVolver);

        btnIngresar = new JButton();
        btnIngresar.setBounds(480, 600, 320, 50);
        btnIngresar.setText(prop.getProperty("archivospropiedad.boton.ingresar"));
        btnIngresar.setFocusable(false);
        btnIngresar.setForeground(Color.black);
        btnIngresar.setBackground(new Color(235, 219, 79));
        btnIngresar.setFont(new Font("Baloo", Font.BOLD, 26));
        add(btnIngresar);

        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(480, 300, 490, 60);
        nombreUsuario.setFont(new Font("Baloo", Font.BOLD, 26));
        add(nombreUsuario);

        contrasena1 = new JPasswordField();
        contrasena1.setBounds(480, 400, 490, 60);
        contrasena1.setFont(new Font("Baloo", Font.BOLD, 26));
        add(contrasena1);

        contrasena2 = new JPasswordField();
        contrasena2.setBounds(480, 500, 490, 60);
        contrasena2.setFont(new Font("Baloo", Font.BOLD, 26));
        add(contrasena2);

        textNombre = new JLabel();
        textNombre.setBounds(340, 300, 400, 60);
        textNombre.setText(prop.getProperty("archivospropiedad.texto.usuario"));
        textNombre.setFont(new Font("Baloo", Font.BOLD, 26));
        add(textNombre);

        textContra1 = new JLabel();
        textContra1.setBounds(324, 400, 400, 60);
        textContra1.setText(prop.getProperty("archivospropiedad.texto.contrasena"));
        textContra1.setFont(new Font("Baloo", Font.BOLD, 26));
        mostrarContrasena = new JCheckBox();
        mostrarContrasena.setBounds(980, 420, 20, 20);
        mostrarContrasena.setOpaque(false);
        mostrarContrasena.setContentAreaFilled(false);
        mostrarContrasena.setBorderPainted(false);
        mostrarContrasena.setFocusPainted(false);
        add(mostrarContrasena);
        add(textContra1);

        textContra2 = new JLabel();
        textContra2.setBounds(230, 500, 400, 60);
        textContra2.setText(prop.getProperty("archivospropiedad.texto.repetircontrasena"));
        textContra2.setFont(new Font("Baloo", Font.BOLD, 26));
        mostrarContrasena2 = new JCheckBox();
        mostrarContrasena2.setBounds(980, 520, 20, 20);
        mostrarContrasena2.setOpaque(false);
        mostrarContrasena2.setContentAreaFilled(false);
        mostrarContrasena2.setBorderPainted(false);
        mostrarContrasena2.setFocusPainted(false);
        add(mostrarContrasena2);
        add(textContra2);

        textEstandarNombre = new JLabel();
        textEstandarNombre.setBounds(480, 341, 400, 60);
        textEstandarNombre.setText(prop.getProperty("archivospropiedad.texto.requsuario"));
        textEstandarNombre.setFont(new Font("Baloo", Font.BOLD, 10));
        add(textEstandarNombre);

        textEstandarContra = new JLabel();
        textEstandarContra.setBounds(480, 441, 800, 60);
        textEstandarContra.setText(prop.getProperty("archivospropiedad.texto.reqcontrasena"));
        textEstandarContra.setFont(new Font("Baloo", Font.BOLD, 10));
        add(textEstandarContra);

        add(fondo);

    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovacio")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        btnVolver.setText(prop.getProperty("archivospropiedad.boton.volver"));
        btnIngresar.setText(prop.getProperty("archivospropiedad.boton.ingresar"));
        textNombre.setText(prop.getProperty("archivospropiedad.texto.usuario"));
        textContra1.setText(prop.getProperty("archivospropiedad.texto.contrasena"));
        textContra2.setText(prop.getProperty("archivospropiedad.texto.repetircontrasena"));
        textEstandarNombre.setText(prop.getProperty("archivospropiedad.texto.requsuario"));
        textEstandarContra.setText(prop.getProperty("archivospropiedad.texto.reqcontrasena"));
    }

    /**
     * Obtiene el fondo del panel.
     * 
     * @return Fondo del panel.
     */
    public JLabel getFondo() {
        return fondo;
    }

    /**
     * Establece el fondo del panel.
     * 
     * @param fondo Fondo del panel.
     */
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    /**
     * Obtiene el nombre de usuario ingresado.
     * 
     * @return Nombre de usuario ingresado.
     */
    public String getNombreUsuario() {
        return nombreUsuario.getText();
    }

    /**
     * Establece el campo de texto para el nombre de usuario.
     * 
     * @param nombreUsuario Campo de texto para el nombre de usuario.
     */
    public void setNombreUsuario(JTextField nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la primera contraseña ingresada como texto.
     * 
     * @return Primera contraseña ingresada.
     */
    public String getContrasena1() {
        char[] contrasena = contrasena1.getPassword();
        return new String(contrasena);
    }

    /**
     * Establece el campo de texto para la primera contraseña.
     * 
     * @param contrasena1 Campo de texto para la primera contraseña.
     */
    public void setContrasena1(JPasswordField contrasena1) {
        this.contrasena1 = contrasena1;
    }

    /**
     * Obtiene la segunda contraseña ingresada como texto.
     * 
     * @return Segunda contraseña ingresada.
     */
    public String getContrasena2() {
        char[] contrasena = contrasena2.getPassword();
        return new String(contrasena);
    }

    /**
     * Obtiene el campo de texto para la segunda contraseña.
     * 
     * @return Campo de texto para la segunda contraseña.
     */
    public JPasswordField getContrasena2F() {
        return this.contrasena2;
    }

    /**
     * Establece el campo de texto para la segunda contraseña.
     * 
     * @param contrasena2 Campo de texto para la segunda contraseña.
     */
    public void setContrasena2(JPasswordField contrasena2) {
        this.contrasena2 = contrasena2;
    }

    /**
     * Obtiene el botón para volver al menú anterior.
     * 
     * @return Botón para volver al menú anterior.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón para volver al menú anterior.
     * 
     * @param btnVolver Botón para volver al menú anterior.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Obtiene el botón para confirmar la creación del usuario.
     * 
     * @return Botón para confirmar la creación del usuario.
     */
    public JButton getBtnIngresar() {
        return btnIngresar;
    }
	public JPasswordField getContrasena1F() {
		return this.contrasena1;
	}
    /**
     * Establece el botón para confirmar la creación del usuario.
     * 
     * @param btnIngresar Botón para confirmar la creación del usuario.
     */
    public void setBtnIngresar(JButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    /**
     * Obtiene la etiqueta para el texto del nombre de usuario.
     * 
     * @return Etiqueta para el texto del nombre de usuario.
     */
    public JLabel getTextNombre() {
        return textNombre;
    }

    /**
     * Establece la etiqueta para el texto del nombre de usuario.
     * 
     * @param textNombre Etiqueta para el texto del nombre de usuario.
     */
    public void setTextNombre(JLabel textNombre) {
        this.textNombre = textNombre;
    }

    /**
     * Obtiene la etiqueta para el texto de la primera contraseña.
     * 
     * @return Etiqueta para el texto de la primera contraseña.
     */
    public JLabel getTextContra1() {
        return textContra1;
    }

    /**
     * Establece la etiqueta para el texto de la primera contraseña.
     * 
     * @param textContra1 Etiqueta para el texto de la primera contraseña.
     */
    public void setTextContra1(JLabel textContra1) {
        this.textContra1 = textContra1;
    }

    /**
     * Obtiene la etiqueta para el texto de la segunda contraseña.
     * 
     * @return Etiqueta para el texto de la segunda contraseña.
     */
    public JLabel getTextContra2() {
        return textContra2;
    }

    /**
     * Establece la etiqueta para el texto de la segunda contraseña.
     * 
     * @param textContra2 Etiqueta para el texto de la segunda contraseña.
     */
    public void setTextContra2(JLabel textContra2) {
        this.textContra2 = textContra2;
    }

    /**
     * Obtiene la etiqueta para los requisitos del nombre de usuario.
     * 
     * @return Etiqueta para los requisitos del nombre de usuario.
     */
    public JLabel getTextEstandarNombre() {
        return textEstandarNombre;
    }

    /**
     * Establece la etiqueta para los requisitos del nombre de usuario.
     * 
     * @param textEstandarNombre Etiqueta para los requisitos del nombre de usuario.
     */
    public void setTextEstandarNombre(JLabel textEstandarNombre) {
        this.textEstandarNombre = textEstandarNombre;
    }

    /**
     * Obtiene la etiqueta para los requisitos de la contraseña.
     * 
     * @return Etiqueta para los requisitos de la contraseña.
     */
    public JLabel getTextEstandarContra() {
        return textEstandarContra;
    }

    /**
     * Establece la etiqueta para los requisitos de la contraseña.
     * 
     * @param textEstandarContra Etiqueta para los requisitos de la contraseña.
     */
    public void setTextEstandarContra(JLabel textEstandarContra) {
        this.textEstandarContra = textEstandarContra;
    }

    /**
     * Obtiene el checkbox para mostrar la primera contraseña.
     * 
     * @return Checkbox para mostrar la primera contraseña.
     */
    public JCheckBox getMostrarContrasena() {
        return mostrarContrasena;
    }
    
    
    
    /**
     * Establece el checkbox para mostrar la primera contraseña.
     * 
     * @param mostrarContrasena Checkbox para mostrar la primera contraseña.
     */
    public void setMostrarContrasena(JCheckBox mostrarContrasena) {
        this.mostrarContrasena = mostrarContrasena;
    }

    /**
     * Obtiene el checkbox para mostrar la segunda contraseña.
     * 
     * @return Checkbox para mostrar la segunda contraseña.
     */
    public JCheckBox getMostrarContrasena2() {
        return mostrarContrasena2;
    }

    /**
     * Establece el checkbox para mostrar la segunda contraseña.
     * 
     * @param mostrarContrasena2 Checkbox para mostrar la segunda contraseña.
     */
    public void setMostrarContrasena2(JCheckBox mostrarContrasena2) {
        this.mostrarContrasena2 = mostrarContrasena2;
    }

    /**
     * Obtiene las propiedades de configuración del panel.
     * 
     * @return Propiedades de configuración.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Establece las propiedades de configuración del panel.
     * 
     * @param prop Propiedades de configuración.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }
    
    
}
