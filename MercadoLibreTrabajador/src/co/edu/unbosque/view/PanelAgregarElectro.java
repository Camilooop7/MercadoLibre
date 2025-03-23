package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAgregarElectro extends JPanel {

	private JLabel fondo;
	private JButton btnAgregar;
	
	public PanelAgregarElectro() throws IOException {

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
		
		add(fondo);
	}

}