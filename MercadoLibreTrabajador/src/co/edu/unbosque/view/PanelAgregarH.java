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

public class PanelAgregarH extends JPanel {

	private JLabel fondo;
	private JButton btnCocina;
	private JButton btnBano;

	public PanelAgregarH() throws IOException {

		setBounds(412, 250, 780, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoHogar.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		btnCocina = new JButton();
		btnCocina.setBounds(140, 128, 182, 180);
		btnCocina.setFocusable(false);
		btnCocina.setBackground(new Color(0, 0, 0));
		btnCocina.setContentAreaFilled(false);
		btnCocina.setOpaque(false);
		btnCocina.setBorderPainted(false);
		btnCocina.setVisible(true);
		add(btnCocina);

		btnBano = new JButton();
		btnBano.setBounds(440, 128, 182, 180);
		btnBano.setFocusable(false);
		btnBano.setBackground(new Color(0, 0, 0));
		btnBano.setContentAreaFilled(false);
		btnBano.setOpaque(false);
		btnBano.setBorderPainted(false);
		btnBano.setVisible(true);
		add(btnBano);

		add(fondo);

	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnCocina() {
		return btnCocina;
	}

	public void setBtnCocina(JButton btnCocina) {
		this.btnCocina = btnCocina;
	}

	public JButton getBtnBano() {
		return btnBano;
	}

	public void setBtnBano(JButton btnBano) {
		this.btnBano = btnBano;
	}

}
