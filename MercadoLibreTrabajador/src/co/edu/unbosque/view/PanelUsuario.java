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
import javax.swing.JTextArea;

public class PanelUsuario extends JPanel {

	private JLabel fondo;
	private JButton btnVolver;
	private String texto;
	private PanelModificarU pmu;
	private PanelModificarT pmt;
	private PanelModificarC pmc;
	private Properties prop;
	

	public PanelUsuario(Properties prop) throws IOException {
		setBounds(0, 0, 1290, 750);
		setLayout(null);
		
		this.prop = prop;

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoTBack.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1290, 750);

		btnVolver = new JButton();
		btnVolver.setBounds(1092, 71, 130, 97);
		btnVolver.setFocusable(false);
		btnVolver.setBackground(new Color(0, 0, 0));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setVisible(true);
		add(btnVolver);

		pmu = new PanelModificarU();
		pmt = new PanelModificarT();
		pmc = new PanelModificarC();

		add(pmc).setVisible(false);
		add(pmt).setVisible(false);
		add(pmu).setVisible(true);

		add(fondo);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public PanelModificarU getPmu() {
		return pmu;
	}

	public void setPmu(PanelModificarU pmu) {
		this.pmu = pmu;
	}

	public PanelModificarT getPmt() {
		return pmt;
	}

	public void setPmt(PanelModificarT pmt) {
		this.pmt = pmt;
	}

	public PanelModificarC getPmc() {
		return pmc;
	}

	public void setPmc(PanelModificarC pmc) {
		this.pmc = pmc;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	

}
