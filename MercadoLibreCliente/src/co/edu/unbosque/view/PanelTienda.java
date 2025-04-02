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
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que representa el panel de la tienda, donde se muestran las opciones
 * de navegación para las secciones de hogar, oficina y ocio.
 */
public class PanelTienda extends JPanel {
    /**
     * Etiqueta para el fondo del panel.
     */
    private JLabel fondo;

    /**
     * Botón para volver al menú principal.
     */
    private JButton btnVolver;

    /**
     * Botón para acceder a la sección de hogar.
     */
    private JButton btnHogar;

    /**
     * Botón para acceder a la sección de oficina.
     */
    private JButton btnOficina;

    /**
     * Botón para acceder a la sección de ocio.
     */
    private JButton btnOcio;

    /**
     * Panel que contiene los botones de navegación.
     */
    private JPanel panelBotones;

    /**
     * Panel correspondiente a la sección de ocio.
     */
    private PanelOcio panelOcio;

    /**
     * Panel correspondiente a la sección de oficina.
     */
    private PanelOficina panelOficina;

    /**
     * Panel correspondiente a la sección de hogar.
     */
    private PanelHogar panelHogar;

    /**
     * Propiedades para cargar configuraciones externas.
     */
    private Properties prop;

    /**
     * Constructor de la clase PanelTienda.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar los recursos.
     */
    public PanelTienda(Properties prop) throws IOException {
        this.prop = prop;

        setLayout(null);
        setBounds(0, 0, 1290, 750);
        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondotienda")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1290, 750);

        panelHogar = new PanelHogar(prop);
        panelHogar.setVisible(false);
        panelOficina = new PanelOficina(prop);
        panelOficina.setVisible(false);
        panelOcio = new PanelOcio(prop);
        panelOcio.setVisible(false);

        panelBotones = new JPanel(new GridLayout(3, 1));
        panelBotones.setBounds(50, 250, 300, 350);
        btnHogar = new JButton(prop.getProperty("archivospropiedad.boton.hogar"));
        btnHogar.setBackground(new Color(235, 219, 79));
        btnHogar.setFont(new Font("Baloo", Font.BOLD, 30));
        btnHogar.setForeground(Color.black);
        btnOficina = new JButton(prop.getProperty("archivospropiedad.boton.oficina"));
        btnOficina.setBackground(new Color(235, 219, 79));
        btnOficina.setFont(new Font("Baloo", Font.BOLD, 30));
        btnOficina.setForeground(Color.black);
        btnOcio = new JButton(prop.getProperty("archivospropiedad.boton.ocio"));
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
        btnVolver.setBorderPainted(false);
        btnVolver.setVisible(true);

        add(btnVolver);
        add(panelBotones);
        add(panelOcio);
        add(panelOficina);
        add(panelHogar);
        add(fondo);
    }

    /**
     * Método para actualizar los componentes del panel.
     * 
     * @throws IOException Si ocurre un error al cargar los recursos.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondotienda")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        btnHogar = new JButton(prop.getProperty("archivospropiedad.boton.hogar"));
        btnOficina = new JButton(prop.getProperty("archivospropiedad.boton.oficina"));
        btnOcio = new JButton(prop.getProperty("archivospropiedad.boton.ocio"));
    }

    /**
     * Obtiene el panel de la sección de hogar.
     * 
     * @return El panel de hogar.
     */
    public PanelHogar getPanelHogar() {
        return panelHogar;
    }

    /**
     * Establece el panel de la sección de hogar.
     * 
     * @param panelHogar El panel de hogar a establecer.
     */
    public void setPanelHogar(PanelHogar panelHogar) {
        this.panelHogar = panelHogar;
    }

    /**
     * Obtiene el botón para volver al menú principal.
     * 
     * @return El botón de volver.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón para volver al menú principal.
     * 
     * @param btnVolver El botón de volver a establecer.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Obtiene la etiqueta del fondo.
     * 
     * @return La etiqueta del fondo.
     */
    public JLabel getFondo() {
        return fondo;
    }

    /**
     * Establece la etiqueta del fondo.
     * 
     * @param fondo La etiqueta del fondo a establecer.
     */
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    /**
     * Obtiene el botón para la sección de hogar.
     * 
     * @return El botón de hogar.
     */
    public JButton getBtnHogar() {
        return btnHogar;
    }

    /**
     * Establece el botón para la sección de hogar.
     * 
     * @param btnHogar El botón de hogar a establecer.
     */
    public void setBtnHogar(JButton btnHogar) {
        this.btnHogar = btnHogar;
    }

    /**
     * Obtiene el botón para la sección de oficina.
     * 
     * @return El botón de oficina.
     */
    public JButton getBtnOficina() {
        return btnOficina;
    }

    /**
     * Establece el botón para la sección de oficina.
     * 
     * @param btnOficina El botón de oficina a establecer.
     */
    public void setBtnOficina(JButton btnOficina) {
        this.btnOficina = btnOficina;
    }

    /**
     * Obtiene el botón para la sección de ocio.
     * 
     * @return El botón de ocio.
     */
    public JButton getBtnOcio() {
        return btnOcio;
    }

    /**
     * Establece el botón para la sección de ocio.
     * 
     * @param btnOcio El botón de ocio a establecer.
     */
    public void setBtnOcio(JButton btnOcio) {
        this.btnOcio = btnOcio;
    }

    /**
     * Obtiene el panel que contiene los botones de navegación.
     * 
     * @return El panel de botones.
     */
    public JPanel getPanelBotones() {
        return panelBotones;
    }

    /**
     * Establece el panel que contiene los botones de navegación.
     * 
     * @param panelBotones El panel de botones a establecer.
     */
    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    /**
     * Obtiene el panel de la sección de ocio.
     * 
     * @return El panel de ocio.
     */
    public PanelOcio getPanelOcio() {
        return panelOcio;
    }

    /**
     * Establece el panel de la sección de ocio.
     * 
     * @param panelOcio El panel de ocio a establecer.
     */
    public void setPanelOcio(PanelOcio panelOcio) {
        this.panelOcio = panelOcio;
    }

    /**
     * Obtiene el panel de la sección de oficina.
     * 
     * @return El panel de oficina.
     */
    public PanelOficina getPanelOficina() {
        return panelOficina;
    }

    /**
     * Establece el panel de la sección de oficina.
     * 
     * @param panelOficina El panel de oficina a establecer.
     */
    public void setPanelOficina(PanelOficina panelOficina) {
        this.panelOficina = panelOficina;
    }

    /**
     * Obtiene las propiedades configuradas.
     * 
     * @return Las propiedades.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Establece las propiedades configuradas.
     * 
     * @param prop Las propiedades a establecer.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
