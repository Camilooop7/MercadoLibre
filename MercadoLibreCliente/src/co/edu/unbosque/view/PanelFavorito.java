package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Producto;

/**
 * Clase que representa el panel de productos favoritos.
 * Permite visualizar los productos marcados como favoritos y realizar acciones como añadir al carrito o eliminarlos de favoritos.
 */
public class PanelFavorito extends JPanel {
    /** Fondo del panel. */
    private JLabel fondo;
    /** Botón para volver al menú anterior. */
    private JButton btnVolver;
    /** Scroll que es usado para navegar en los productos favoritos. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos favoritos. */
    private JPanel panelContenido;
    /** Lista de botones para añadir productos al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Lista de botones para eliminar productos de favoritos. */
    private ArrayList<JButton> botonesFav;
    /** Propiedades para la configuración del panel. */
    private Properties prop;

    /**
     * Constructor que inicializa el panel de favoritos.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public PanelFavorito(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1290, 750);
        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());

        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1290, 750);

        btnVolver = new JButton();
        btnVolver.setBounds(1120, 70, 120, 70);
        btnVolver.setFocusable(false);
        btnVolver.setBackground(new Color(0, 0, 0));
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setVisible(true);

        agregarProducto(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.green);
        scrollPane.setBounds(150, 230, 1000, 480);

        JPanel pP = new JPanel();
        pP.setBounds(150, 230, 1000, 500);
        pP.setBackground(Color.GREEN);

        add(btnVolver);
        //add(pP);
        add(scrollPane);
        add(fondo);
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
    }

    /**
     * Agrega productos con sus botones correspondientes al panel de favoritos.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Producto> listaDatos) {
        if (cantidad == -1) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            JPanel panelProducto = new JPanel();
            panelProducto.setLayout(new BorderLayout());
            panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelProducto.setBackground(new Color(198, 195, 195));

            JLabel lblImagen = new JLabel(asignarImagen(listaDatos.get(i)));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            panelProducto.add(lblImagen, BorderLayout.EAST);

            JTextArea txtAreaInfo = new JTextArea(listaDatos.get(i).toString());
            txtAreaInfo.setEditable(false);
            txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 25));
            txtAreaInfo.setBackground(new Color(198, 195, 195));
            panelProducto.add(txtAreaInfo, BorderLayout.WEST);

            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnAgregar = new JButton(prop.getProperty("archivospropiedad.boton.carritomas"));
            btnAgregar.setBackground(new Color(235, 219, 79));
            btnAgregar.setFont(new Font("Baloo", Font.BOLD, 15));
            JButton btnFavoritos = new JButton(prop.getProperty("archivospropiedad.boton.favoritomenos"));
            btnFavoritos.setBackground(new Color(235, 219, 79));
            btnFavoritos.setFont(new Font("Baloo", Font.BOLD, 15));

            botonesAnadir.add(btnAgregar);
            botonesFav.add(btnFavoritos);

            panelBotones.add(btnAgregar);
            panelBotones.add(btnFavoritos);
            panelBotones.setBackground(new Color(198, 195, 195));

            panelProducto.add(panelBotones, BorderLayout.SOUTH);
            panelContenido.add(panelProducto);
        }
    }

    /**
     * Asigna una imagen a un producto.
     * 
     * @param obj Producto al que se le asignará la imagen.
     * @return Icono de la imagen asignada.
     */
    private ImageIcon asignarImagen(Producto obj) {
        try {
            String ruta = obj.getImagen();

            // Convertir rutas Windows a formato válido
            ruta = ruta.replace("\\", "/");

            BufferedImage fd = ImageIO.read(new File(ruta));

            ImageIcon imagen = new ImageIcon(fd);

            Image fdRedim = fd.getScaledInstance(500, 325, Image.SCALE_SMOOTH);
            return new ImageIcon(fdRedim);

        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza la información mostrada en el panel.
     * 
     * @param listaDatos Lista con la nueva información de los productos.
     */
    public void actualizarInfo(ArrayList<Producto> listaDatos) {
        botonesAnadir.clear();
        botonesFav.clear();
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }

    // Métodos getter y setter

    /**
     * Obtiene el fondo del panel.
     * 
     * @return Fondo del panel.
     */
    public JLabel getFondo() {
        return fondo;
    }

    /**
     * Establece el fondo del panel.
     * 
     * @param fondo Fondo del panel.
     */
    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    /**
     * Obtiene el botón para volver al menú anterior.
     * 
     * @return Botón para volver al menú anterior.
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón para volver al menú anterior.
     * 
     * @param btnVolver Botón para volver al menú anterior.
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Obtiene el scroll usado para navegar en los productos favoritos.
     * 
     * @return Scroll usado para navegar en los productos favoritos.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll usado para navegar en los productos favoritos.
     * 
     * @param scrollPane Scroll usado para navegar en los productos favoritos.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene las propiedades para la configuración del panel.
     * 
     * @return Propiedades para la configuración del panel.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Establece las propiedades para la configuración del panel.
     * 
     * @param prop Propiedades para la configuración del panel.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

    /**
     * Obtiene el panel en el que se guardan todos los productos favoritos.
     * 
     * @return Panel en el que se guardan todos los productos favoritos.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel en el que se guardan todos los productos favoritos.
     * 
     * @param panelContenido Panel en el que se guardan todos los productos favoritos.
     */
    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
    }

    /**
     * Obtiene la lista de botones para añadir productos al carrito.
     * 
     * @return Lista de botones para añadir productos al carrito.
     */
    public ArrayList<JButton> getBotonesAnadir() {
        return botonesAnadir;
    }

    /**
     * Establece la lista de botones para añadir productos al carrito.
     * 
     * @param botonesAnadir Lista de botones para añadir productos al carrito.
     */
    public void setBotonesAnadir(ArrayList<JButton> botonesAnadir) {
        this.botonesAnadir = botonesAnadir;
    }

    /**
     * Obtiene la lista de botones para eliminar productos de favoritos.
     * 
     * @return Lista de botones para eliminar productos de favoritos.
     */
    public ArrayList<JButton> getBotonesFav() {
        return botonesFav;
    }

    /**
     * Establece la lista de botones para eliminar productos de favoritos.
     * 
     * @param botonesFav Lista de botones para eliminar productos de favoritos.
     */
    public void setBotonesFav(ArrayList<JButton> botonesFav) {
        this.botonesFav = botonesFav;
    }
}
