package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTienda extends JPanel {
	private JLabel fondo;
	private JButton btnVolver, btnHogar, btnOficina, btnOcio;
	
    private JPanel panelBotones;
    private PanelOcio panelOcio; 
    private PanelOficina panelOficina;
    private PanelHogar panelHogar;
	
	 public PanelTienda() throws IOException {
		 	
		 	setLayout(null);
		 	setBounds(0, 0, 1290, 750);
			fondo = new JLabel();
			BufferedImage fd = ImageIO.read(new File("src/co/edu/unbosque/view/FondoVerTienda.png"));
			ImageIcon imagenFondo = new ImageIcon(fd);
			Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
			fondo.setIcon(new ImageIcon(fdRedim));
			fondo.setBounds(0, 0, 1290, 750);
			
			panelHogar = new PanelHogar();
			panelHogar.setVisible(false);
			panelOficina = new PanelOficina();
			panelOficina.setVisible(false);
			panelOcio = new PanelOcio();
			panelOcio.setVisible(false);
			
	        panelBotones = new JPanel(new GridLayout(3, 1));
	        panelBotones.setBounds(50, 250, 300, 350);
	        btnHogar = new JButton("Hogar");
	        btnHogar.setBackground(new Color(235, 219, 79));
			btnHogar.setFont(new Font("Baloo", Font.BOLD, 30));
	        btnHogar.setForeground(Color.black);
	        btnOficina = new JButton("Oficina");
	        btnOficina.setBackground(new Color(235, 219, 79));
			btnOficina.setFont(new Font("Baloo", Font.BOLD, 30));
	        btnOficina.setForeground(Color.black);
	        btnOcio = new JButton("Ocio");
	        btnOcio.setBackground(new Color(235, 219, 79));
	        btnOcio.setFont(new Font("Baloo", Font.BOLD, 30));
	        btnOcio.setForeground(Color.black);
	        
	        panelBotones.add(btnHogar);
	        panelBotones.add(btnOficina);
	        panelBotones.add(btnOcio);
	        
			btnVolver = new JButton();
			btnVolver.setBounds(1120, 70, 120, 70);
			btnVolver.setFocusable(false);
			btnVolver.setBackground(new Color(0, 0, 0));
			btnVolver.setContentAreaFilled(false);
			btnVolver.setOpaque(false);
			btnVolver.setVisible(true);

			
			add(btnVolver);
	        add(panelBotones);
	        add(panelOcio);
	        add(panelOficina);
	        add(panelHogar);
			add(fondo); 
	}
	 
	 
	public PanelHogar getPanelHogar() {
		return panelHogar;
	}


	public void setPanelHogar(PanelHogar panelHogar) {
		this.panelHogar = panelHogar;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}


	public JLabel getFondo() {
		return fondo;
	}
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}


	public JButton getBtnHogar() {
		return btnHogar;
	}


	public void setBtnHogar(JButton btnHogar) {
		this.btnHogar = btnHogar;
	}


	public JButton getBtnOficina() {
		return btnOficina;
	}


	public void setBtnOficina(JButton btnOficina) {
		this.btnOficina = btnOficina;
	}


	public JButton getBtnOcio() {
		return btnOcio;
	}


	public void setBtnOcio(JButton btnOcio) {
		this.btnOcio = btnOcio;
	}


	public JPanel getPanelBotones() {
		return panelBotones;
	}


	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}


	public PanelOcio getPanelOcio() {
		return panelOcio;
	}


	public void setPanelOcio(PanelOcio panelOcio) {
		this.panelOcio = panelOcio;
	}


	public PanelOficina getPanelOficina() {
		return panelOficina;
	}


	public void setPanelOficina(PanelOficina panelOficina) {
		this.panelOficina = panelOficina;
	}
	 
	

}
