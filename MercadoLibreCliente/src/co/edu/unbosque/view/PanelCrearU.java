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
		mostrarContrasena= new JCheckBox();
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
		mostrarContrasena2= new JCheckBox();
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
	
	public void actualizarComps() throws IOException{
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

	public JPasswordField getContrasena2F() {
		return this.contrasena2;
	}
	public JPasswordField getContrasena1F() {
		return this.contrasena1;
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
