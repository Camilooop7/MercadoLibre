package co.edu.unbosque.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.*;
import co.edu.unbosque.model.Oficina;

/**
 * Clase que representa el panel de productos de oficina.
 * Permite visualizar los productos de oficina y realizar acciones como añadir al carrito o a favoritos.
 */
public class PanelOficina extends JPanel {
    /** Scroll que es usado para navegar en los productos del almacén. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del almacén. */
    private JPanel panelContenido;
    /** Lista de botones para añadir productos al carrito. */
    private ArrayList<JButton> botonesAnadir;
    /** Lista de botones para añadir productos a favoritos. */
    private ArrayList<JButton> botonesFav;
    /** Propiedades para la configuración del panel. */
    private Properties prop;

    /**
     * Constructor que configura el panel con desplazamiento vertical.
     * 
     * @param prop Propiedades para configurar el panel.
     */
    public PanelOficina(Properties prop) {
        this.prop = prop;
        setBounds(380, 240, 870, 470);
        botonesAnadir = new ArrayList<>();
        botonesFav = new ArrayList<>();
        setLayout(new BorderLayout());
        panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        agregarProducto(-1, new ArrayList<>());

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Agrega productos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Oficina> listaDatos) {
        if (cantidad == -1) {
            return;
        }
        
        for (int i = 0; i < cantidad; i++) {
            JPanel panelProducto = new JPanel();
            panelProducto.setLayout(new BorderLayout());
            panelProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panelProducto.setBackground(new Color(198,195,195));
            
            JLabel lblImagen = new JLabel(asignarImagen(listaDatos.get(i)));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            panelProducto.add(lblImagen, BorderLayout.EAST);

            JTextArea txtAreaInfo = new JTextArea(listaDatos.get(i).toString());
            txtAreaInfo.setEditable(false);
            txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 25));
            txtAreaInfo.setBackground(new Color(198,195,195));
            panelProducto.add(txtAreaInfo, BorderLayout.WEST);

            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnAgregar = new JButton(prop.getProperty("archivospropiedad.boton.carritomas"));
            btnAgregar.setBackground(new Color(235, 219, 79));
            btnAgregar.setFont(new Font("Baloo", Font.BOLD, 15));
            JButton btnFavoritos = new JButton(prop.getProperty("archivospropiedad.boton.favoritomas"));
            btnFavoritos.setBackground(new Color(235, 219, 79));
            btnFavoritos.setFont(new Font("Baloo", Font.BOLD, 15));
            
            botonesAnadir.add(btnAgregar);
            botonesFav.add(btnFavoritos);
            
            panelBotones.add(btnAgregar);
            panelBotones.add(btnFavoritos);
            panelBotones.setBackground(new Color(198,195,195));

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
    private ImageIcon asignarImagen(Oficina obj) {
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
    public void actualizarInfo(ArrayList<Oficina> listaDatos) {
        botonesAnadir.clear();
        botonesFav.clear();
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }

    /**
     * Obtiene el scroll para navegar en los productos del almacén.
     * 
     * @return Scroll para navegar en los productos.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll para navegar en los productos del almacén.
     * 
     * @param scrollPane Scroll para navegar en los productos.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene los productos del almacén.
     * 
     * @return Panel que contiene los productos.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene los productos del almacén.
     * 
     * @param panelContenido Panel que contiene los productos.
     */
    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
    }

    /**
     * Obtiene la lista de botones para añadir productos al carrito.
     * 
     * @return Lista de botones para añadir productos.
     */
    public ArrayList<JButton> getBotonesAnadir() {
        return botonesAnadir;
    }

    /**
     * Establece la lista de botones para añadir productos al carrito.
     * 
     * @param botonesAnadir Lista de botones para añadir productos.
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
     * Obtiene las propiedades de configuración del panel.
     * 
     * @return Propiedades de configuración.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Establece las propiedades de configuración del panel.
     * 
     * @param prop Propiedades de configuración.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
