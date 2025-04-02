package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Producto;

/**
 * Clase que representa el panel del historial de compras.
 * Permite visualizar los productos comprados previamente.
 */
public class PanelHistorial extends JPanel {
    /** Fondo del panel. */
    private JLabel fondo;
    /** Botón para volver al menú anterior. */
    private JButton btnVolver;
    /** Botón para limpiar el historial. */
    private JButton btnLimpiar;
    /** Scroll que es usado para navegar en los productos del historial. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del historial. */
    private JPanel panelContenido;
    /** Lista de botones para añadir productos al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Lista de botones para añadir productos a favoritos. */
    private ArrayList<JButton> botonesFav;
    /** Propiedades para la configuración del panel. */
    private Properties prop;

    /**
     * Constructor que inicializa el panel del historial.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public PanelHistorial(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1290, 750);
        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());

        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH));
        fondo.setIcon(imagenFondo);
        fondo.setBounds(0, 0, 1290, 750);

        btnLimpiar = new JButton();
        btnLimpiar.setBounds(1050, 600, 200, 100);
        btnLimpiar.setText(prop.getProperty("archivospropiedad.boton.limpiar"));
        btnLimpiar.setFocusable(false);
        btnLimpiar.setBackground(Color.WHITE);
        btnLimpiar.setForeground(Color.black);
        btnLimpiar.setBackground(new Color(235, 219, 79));
        btnLimpiar.setFont(new Font("Baloo", Font.BOLD, 15));

        btnVolver = new JButton();
        btnVolver.setBounds(1120, 70, 120, 70);
        btnVolver.setFocusable(false);
        btnVolver.setBackground(new Color(0, 0, 0));
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(false);

        JScrollPane scrollPrincipal = new JScrollPane(panelContenido);
        scrollPrincipal.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPrincipal.setBounds(50, 230, 1000, 480);

        add(btnVolver);
        add(btnLimpiar);
        add(scrollPrincipal);
        add(fondo);
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH));
        fondo.setIcon(imagenFondo);
        btnLimpiar.setText(prop.getProperty("archivospropiedad.boton.limpiar"));
    }

    /**
     * Agrega productos con sus botones correspondientes al historial.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Carrito> listaDatos) {
        if (cantidad == -1) {
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            JLabel nProducto = new JLabel(" " + (i + 1));

            JPanel panelCarrito = new JPanel();
            panelCarrito.setLayout(new BorderLayout());
            panelCarrito.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            panelCarrito.setBackground(new Color(198, 195, 195));

            panelCarrito.add(nProducto, BorderLayout.NORTH);

            JPanel panelProductos = new JPanel();
            panelProductos.setLayout(new GridLayout(0, 1, 5, 5));

            for (Producto producto : listaDatos.get(i).getListaCarrito()) {
                JPanel panelProducto = new JPanel(new BorderLayout());
                panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelProducto.setBackground(new Color(230, 230, 230));

                JLabel lblImagen = new JLabel(asignarImagen(producto));
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                panelProducto.add(lblImagen, BorderLayout.EAST);

                JTextArea txtAreaInfo = new JTextArea(producto.toString());
                txtAreaInfo.setEditable(false);
                txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 18));
                txtAreaInfo.setBackground(new Color(230, 230, 230));
                panelProducto.add(txtAreaInfo, BorderLayout.CENTER);

                panelProductos.add(panelProducto);
            }

            JScrollPane scrollProductos = new JScrollPane(panelProductos);
            scrollProductos.setPreferredSize(new Dimension(950, 450));
            scrollProductos.setBorder(BorderFactory.createEmptyBorder());

            panelCarrito.add(scrollProductos, BorderLayout.CENTER);
            panelContenido.add(panelCarrito);
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
    public void actualizarInfo(ArrayList<Carrito> listaDatos) {
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
     * Obtiene el scroll usado para navegar en los productos del historial.
     * 
     * @return Scroll usado para navegar en los productos del historial.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll usado para navegar en los productos del historial.
     * 
     * @param scrollPane Scroll usado para navegar en los productos del historial.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel en el que se guardan todos los productos del historial.
     * 
     * @return Panel en el que se guardan todos los productos del historial.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel en el que se guardan todos los productos del historial.
     * 
     * @param panelContenido Panel en el que se guardan todos los productos del historial.
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
     * Obtiene la lista de botones para añadir productos a favoritos.
     * 
     * @return Lista de botones para añadir productos a favoritos.
     */
    public ArrayList<JButton> getBotonesFav() {
        return botonesFav;
    }

    /**
     * Establece la lista de botones para añadir productos a favoritos.
     * 
     * @param botonesFav Lista de botones para añadir productos a favoritos.
     */
    public void setBotonesFav(ArrayList<JButton> botonesFav) {
        this.botonesFav = botonesFav;
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
     * Obtiene el boton limpiar del panel.
     * 
     * @return Boton limpiar del panel.
     */
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
    /**
     * Establece el boton limpiar del panel.
     * 
     * @param prop Boton limpiar del panel.
     */
	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}
    
    
}
