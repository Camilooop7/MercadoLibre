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

public class PanelModificarC extends JPanel {

	private JLabel fondo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea text;
	private String texto;
	private JScrollPane barraV;

	public PanelModificarC() throws IOException {
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
		
		text = new JTextArea();
		text.setBounds(10, 90, 400, 420);
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
		barraV.setBounds(10, 90, 750, 340);
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

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
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

	public JScrollPane getBarraV() {
		return barraV;
	}

	public void setBarraV(JScrollPane barraV) {
		this.barraV = barraV;
	}

}
