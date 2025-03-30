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

	public PanelIniciarSesion(Properties prop) throws IOException {
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
		btnVolver.setBounds(800, 530, 170, 50);
		btnVolver.setText(prop.getProperty("archivospropiedad.boton.volver"));
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.black);
		btnVolver.setBackground(new Color(246, 86, 86));
		btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnVolver);

		btnIngresar = new JButton();
		btnIngresar.setBounds(480, 530, 320, 50);
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

		contrasena = new JPasswordField();
		contrasena.setBounds(480, 400, 490, 60);
		contrasena.setFont(new Font("Baloo", Font.BOLD, 26));
		mostrarContrasena= new JCheckBox();
		mostrarContrasena.setBounds(980, 420, 20, 20);
		mostrarContrasena.setOpaque(false);
		mostrarContrasena.setContentAreaFilled(false);
		mostrarContrasena.setBorderPainted(false);
		mostrarContrasena.setFocusPainted(false);
		add(mostrarContrasena);
		add(contrasena);

		textNombre = new JLabel();
		textNombre.setBounds(340, 300, 400, 60);
		textNombre.setText(prop.getProperty("archivospropiedad.texto.usuario"));
		textNombre.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textNombre);

		textContra = new JLabel();
		textContra.setBounds(324, 400, 400, 60);
		textContra.setText(prop.getProperty("archivospropiedad.texto.contrasena"));
		textContra.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textContra);

		add(fondo);

	}
	
	public void actualizarComps() {
		btnVolver.setText(prop.getProperty("archivospropiedad.boton.volver"));
		btnIngresar.setText(prop.getProperty("archivospropiedad.boton.ingresar"));
		textNombre.setText(prop.getProperty("archivospropiedad.texto.usuario"));
		textContra.setText(prop.getProperty("archivospropiedad.texto.contrasena"));
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JTextField getNombreUsuario() {
		return nombreUsuario;
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
