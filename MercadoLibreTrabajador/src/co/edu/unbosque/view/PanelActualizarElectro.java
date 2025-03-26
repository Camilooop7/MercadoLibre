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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class PanelActualizarElectro extends JPanel {
	private JLabel fondo;
	private JButton actualizar;
	private JTextArea text;
	private String texto;
	private JScrollPane barraV;

	public PanelActualizarElectro() throws IOException {
		setBounds(412, 250, 780, 433);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/PanelActualizar.png"));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(780, 433, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 780, 433);

		actualizar = new JButton();
		actualizar.setBounds(618, 295, 120, 118);
		actualizar.setFocusable(false);
		actualizar.setBackground(new Color(0, 0, 0));
		actualizar.setContentAreaFilled(false);
		actualizar.setOpaque(false);
		actualizar.setBorderPainted(false);
		actualizar.setVisible(true);
		add(actualizar);

		text = new JTextArea();
		text.setBounds(10, 10, 400, 420);
		text.setFocusable(false);
		text.setText(texto);
		text.setBackground(new Color(198, 195, 195));
		text.setOpaque(false);
		text.setFont(new Font("Baloo", Font.BOLD, 20));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		add(text);

		UIManager.put("ScrollBar.background", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.foreground", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumb", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(217, 217, 217));
		UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.track", new ColorUIResource(198, 195, 195));
		UIManager.put("ScrollBar.trackForeground", new ColorUIResource(217, 217, 217));
		

		barraV = new JScrollPane(text);
		barraV.setBounds(10, 10, 750, 420);
		barraV.setBackground(new Color(198, 195, 195));
		barraV.setOpaque(false);
		barraV.setBorder(null); // Eliminar el borde para mayor transparencia
		barraV.getViewport().setOpaque(false); // Hacer el viewport transparente
		add(barraV);

		add(fondo);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getEliminar() {
		return actualizar;
	}

	public void setEliminar(JButton eliminar) {
		this.actualizar = eliminar;
	}

	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		text.setText(texto);
	}

}
