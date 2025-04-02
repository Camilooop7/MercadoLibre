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

public class PanelTrabajador extends JPanel {

	private JLabel fondo;
	private JButton btnAnadir;
	private JButton btnModificarProducto;
	private JButton btnEliminarProducto;
	private JButton btnModificarUsuario;
	private JButton btnSalir;
	private Properties prop;

	public PanelTrabajador(Properties prop) throws IOException {

		setBounds(0, 0, 1290, 750);
		setLayout(null);
		this.prop = prop;

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.pt")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnAnadir = new JButton();
		btnAnadir.setBounds(75, 323, 210, 214);
		btnAnadir.setFocusable(false);
		btnAnadir.setBackground(new Color(0, 0, 0));
		btnAnadir.setContentAreaFilled(false);
		btnAnadir.setOpaque(false);
		btnAnadir.setBorderPainted(false);
		btnAnadir.setVisible(true);
		add(btnAnadir);

		btnModificarProducto = new JButton();
		btnModificarProducto.setBounds(372, 323, 214, 224);
		btnModificarProducto.setFocusable(false);
		btnModificarProducto.setBackground(new Color(0, 0, 0, 0));
		btnModificarProducto.setContentAreaFilled(false);
		btnModificarProducto.setOpaque(false);
		btnModificarProducto.setBorderPainted(false);
		btnModificarProducto.setVisible(true);
		add(btnModificarProducto);

		btnEliminarProducto = new JButton();
		btnEliminarProducto.setBounds(666, 323, 216, 224);
		btnEliminarProducto.setFocusable(false);
		btnEliminarProducto.setBackground(new Color(0, 0, 0));
		btnEliminarProducto.setContentAreaFilled(false);
		btnEliminarProducto.setOpaque(false);
		btnEliminarProducto.setBorderPainted(false);
		btnEliminarProducto.setVisible(true);
		add(btnEliminarProducto);

		btnModificarUsuario = new JButton();
		btnModificarUsuario.setBounds(960, 323, 219, 224);
		btnModificarUsuario.setFocusable(false);
		btnModificarUsuario.setBackground(new Color(0, 0, 0));
		btnModificarUsuario.setContentAreaFilled(false);
		btnModificarUsuario.setOpaque(false);
		btnModificarUsuario.setBorderPainted(false);
		btnModificarUsuario.setVisible(true);
		add(btnModificarUsuario);

		btnSalir = new JButton();
		btnSalir.setBounds(1092, 71, 130, 97);
		btnSalir.setFocusable(false);
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setContentAreaFilled(false);
		btnSalir.setOpaque(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setVisible(true);
		add(btnSalir);

		add(fondo);

	}
	
	public void actualizarComps() throws IOException{
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.pt")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JButton getBtnModificarProducto() {
		return btnModificarProducto;
	}

	public void setBtnModificarProducto(JButton btnModificarProducto) {
		this.btnModificarProducto = btnModificarProducto;
	}

	public JButton getBtnEliminarProducto() {
		return btnEliminarProducto;
	}

	public void setBtnEliminarProducto(JButton btnEliminarProducto) {
		this.btnEliminarProducto = btnEliminarProducto;
	}

	public JButton getBtnModificarUsuario() {
		return btnModificarUsuario;
	}

	public void setBtnModificarUsuario(JButton btnModificarUsuario) {
		this.btnModificarUsuario = btnModificarUsuario;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	

}
