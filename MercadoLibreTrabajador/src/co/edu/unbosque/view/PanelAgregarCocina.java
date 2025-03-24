package co.edu.unbosque.view;

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

public class PanelAgregarCocina extends JPanel {

	private JLabel fondo;
	private JButton btnAgregar;
	private JLabel textNombre;
	private JTextField nombre;
	private JLabel textPrecio;
	private JSpinner precio;
	private JLabel ImportImg;
	private JButton imagen;
	private JLabel textDecoracion;
	private JRadioButton siD;
	private JRadioButton noD;
	private JLabel textPeligro;
	private JRadioButton siP;
	private JRadioButton noP;
	private JLabel textResistecia;
	private JRadioButton siR;
	private JRadioButton noR;

	public PanelAgregarCocina() throws IOException {

		setBounds(412, 250, 780, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelAgregar.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		btnAgregar = new JButton();
		btnAgregar.setBounds(625, 298, 112, 112);
		btnAgregar.setFocusable(false);
		btnAgregar.setBackground(new Color(0, 0, 0));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setOpaque(false);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setVisible(true);
		add(btnAgregar);

		textNombre = new JLabel();
		textNombre.setBounds(44, 40, 150, 60);
		textNombre.setText("Nombre: ");
		textNombre.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textNombre);

		nombre = new JTextField();
		nombre.setBounds(140, 40, 490, 50);
		nombre.setFont(new Font("Baloo", Font.BOLD, 24));
		add(nombre);

		textPrecio = new JLabel();
		textPrecio.setBounds(50, 130, 150, 60);
		textPrecio.setText("Precio: ");
		textPrecio.setFont(new Font("Baloo", Font.BOLD, 24));
		add(textPrecio);

		precio = new JSpinner();
		precio.setBounds(140, 130, 490, 50);
		precio.setFont(new Font("Baloo", Font.BOLD, 24));
		add(precio);

		ImportImg = new JLabel();
		ImportImg.setBounds(50, 220, 150, 60);
		ImportImg.setText("Imagen: ");
		ImportImg.setFont(new Font("Baloo", Font.BOLD, 24));
		add(ImportImg);

		imagen = new JButton();
		imagen.setBounds(149, 227, 250, 40);
		imagen.setText("Seleccionar Imagen");
		imagen.setFocusable(false);
		imagen.setForeground(Color.black);
		imagen.setBackground(new Color(235, 219, 79));
		imagen.setFont(new Font("Baloo", Font.BOLD, 21));
		add(imagen);

		textDecoracion = new JLabel();
		textDecoracion.setBounds(50, 260, 400, 60);
		textDecoracion.setText("¿Es decoración? ");
		textDecoracion.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textDecoracion);

		siD = new JRadioButton("SI");
		siD.setBounds(257, 280, 80, 30); // Ajustar el tamaño para que el texto sea visible
		siD.setFont(new Font("Baloo", Font.BOLD, 15));
		siD.setOpaque(false);
		siD.setContentAreaFilled(false);
		siD.setBorderPainted(false);
		siD.setFocusPainted(false);
		add(siD);

		noD = new JRadioButton("NO");
		noD.setBounds(340, 280, 80, 30); // Ajustar el tamaño para que el texto sea visible
		noD.setFont(new Font("Baloo", Font.BOLD, 15));
		noD.setOpaque(false);
		noD.setContentAreaFilled(false);
		noD.setBorderPainted(false);
		noD.setFocusPainted(false);
		add(noD);
		// Agrupar los JRadioButton
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(siD);
		grupo.add(noD);

		textPeligro = new JLabel();
		textPeligro.setBounds(50, 310, 400, 60);
		textPeligro.setText("¿Es peligroso? ");
		textPeligro.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textPeligro);

		siP = new JRadioButton("SI");
		siP.setBounds(257, 330, 80, 30); // Ajustar el tamaño para que el texto sea visible
		siP.setFont(new Font("Baloo", Font.BOLD, 15));
		siP.setOpaque(false);
		siP.setContentAreaFilled(false);
		siP.setBorderPainted(false);
		siP.setFocusPainted(false);
		add(siP);

		noP = new JRadioButton("NO");
		noP.setBounds(340, 330, 80, 30); // Ajustar el tamaño para que el texto sea visible
		noP.setFont(new Font("Baloo", Font.BOLD, 15));
		noP.setOpaque(false);
		noP.setContentAreaFilled(false);
		noP.setBorderPainted(false);
		noP.setFocusPainted(false);
		add(noP);
		// Agrupar los JRadioButton
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(siP);
		grupo1.add(noP);

		textResistecia = new JLabel();
		textResistecia.setBounds(50, 360, 400, 60);
		textResistecia.setText("¿Resiste altas temperatuas? ");
		textResistecia.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textResistecia);

		siR = new JRadioButton("SI");
		siR.setBounds(410, 380, 80, 30); // Ajustar el tamaño para que el texto sea visible
		siR.setFont(new Font("Baloo", Font.BOLD, 15));
		siR.setOpaque(false);
		siR.setContentAreaFilled(false);
		siR.setBorderPainted(false);
		siR.setFocusPainted(false);
		add(siR);

		noR = new JRadioButton("NO");
		noR.setBounds(494, 380, 80, 30); // Ajustar el tamaño para que el texto sea visible
		noR.setFont(new Font("Baloo", Font.BOLD, 15));
		noR.setOpaque(false);
		noR.setContentAreaFilled(false);
		noR.setBorderPainted(false);
		noR.setFocusPainted(false);
		add(noR);
		// Agrupar los JRadioButton
		ButtonGroup grupo2 = new ButtonGroup();
		grupo2.add(siR);
		grupo2.add(noR);

		add(fondo);
	}

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

	public JLabel getImportImg() {
		return ImportImg;
	}

	public void setImportImg(JLabel importImg) {
		ImportImg = importImg;
	}

	public JButton getImagen() {
		return imagen;
	}

	public void setImagen(JButton imagen) {
		this.imagen = imagen;
	}

	public JLabel getTextPeligro() {
		return textPeligro;
	}

	public void setTextPeligro(JLabel textPeligro) {
		this.textPeligro = textPeligro;
	}

	public JRadioButton getSiP() {
		return siP;
	}

	public void setSiP(JRadioButton siP) {
		this.siP = siP;
	}

	public JRadioButton getNoP() {
		return noP;
	}

	public void setNoP(JRadioButton noP) {
		this.noP = noP;
	}

	public JLabel getTextResistecia() {
		return textResistecia;
	}

	public void setTextResistecia(JLabel textResistecia) {
		this.textResistecia = textResistecia;
	}

	public JRadioButton getSiR() {
		return siR;
	}

	public void setSiR(JRadioButton siR) {
		this.siR = siR;
	}

	public JRadioButton getNoR() {
		return noR;
	}

	public void setNoR(JRadioButton noR) {
		this.noR = noR;
	}

	public JLabel getTextDecoracion() {
		return textDecoracion;
	}

	public void setTextDecoracion(JLabel textDecoracion) {
		this.textDecoracion = textDecoracion;
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

}
