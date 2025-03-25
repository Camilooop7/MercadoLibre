package co.edu.unbosque.view;

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

public class PanelModificarT extends JPanel {

	private JLabel fondo;
	private JButton btnModificar;
	private JButton btnEliminar;

	public PanelModificarT() throws IOException {
		setBounds(166, 245, 950, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelU.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(950, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 950, 433);
		
		btnModificar = new JButton();
		btnModificar.setBounds(778, 100, 120, 100);
		btnModificar.setFocusable(false);
		btnModificar.setBackground(new Color(0, 0, 0));
		btnModificar.setContentAreaFilled(false);
		btnModificar.setOpaque(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setVisible(true);
		add(btnModificar);
		
		btnEliminar = new JButton();
		btnEliminar.setBounds(778, 260, 120, 100);
		btnEliminar.setFocusable(false);
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setVisible(true);
		add(btnEliminar);
		
		add(fondo);
	}

}
