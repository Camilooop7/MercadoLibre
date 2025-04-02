package co.edu.unbosque.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.*;
import co.edu.unbosque.model.Producto;

/**
 * Clase que representa el panel del carrito de compras.
 * Permite visualizar los productos añadidos al carrito y realizar acciones como comprar o eliminar productos.
 */
public class PanelCarrito extends JPanel {
    /** Fondo del panel. */
    private JLabel fondo;
    /** Botón para volver al menú anterior. */
    private JButton btnVolver;
    /** Botón para realizar la compra. */
    private JButton btnComprar;
    /** Área de texto para mostrar el precio total. */
    private JTextArea precioTexto;
    /** Scroll que es usado para navegar en los productos del carrito. */
    private JScrollPane scrollPane;
    /** Panel en el que se guardan todos los productos del carrito. */
    private JPanel panelContenido;
    /** Lista de botones para eliminar productos del carrito. */
    private ArrayList<JButton> botonesEliminar;
    /** Propiedades para la configuración del panel. */
    private Properties prop;

    /**
     * Constructor que inicializa el panel del carrito.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public PanelCarrito(Properties prop) throws IOException {
        this.prop = prop;

        setBounds(0, 0, 1290, 750);
        botonesEliminar = new ArrayList<>();
        setLayout(new BorderLayout());

        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(198, 195, 195));
        panelContenido.setLayout(new GridLayout(0, 1, 10, 10));

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.fondovolver")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1290, 750);

        btnComprar = new JButton();
        btnComprar.setBounds(750, 600, 400, 100);
        btnComprar.setText(prop.getProperty("archivospropiedad.boton.comprar"));
        btnComprar.setFocusable(false);
        btnComprar.setBackground(Color.WHITE);
        btnComprar.setForeground(Color.black);
        btnComprar.setBackground(new Color(235, 219, 79));
        btnComprar.setFont(new Font("Baloo", Font.BOLD, 35));

        precioTexto = new JTextArea();
        precioTexto.setBounds(750, 230, 400, 350);
        precioTexto.setEditable(false);
        precioTexto.setFont(new Font("Baloo", Font.BOLD, 10));
        precioTexto.setBackground(new Color(198, 195, 195));

        btnVolver = new JButton();
        btnVolver.setBounds(1120, 70, 120, 70);
        btnVolver.setFocusable(false);
        btnVolver.setBackground(new Color(0, 0, 0));
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setOpaque(false);
        btnVolver.setVisible(true);

        agregarProducto(-1, new ArrayList<>());

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.green);
        scrollPane.setBounds(50, 230, 500, 480);

        JPanel pP = new JPanel();
        pP.setBounds(150, 230, 1000, 500);
        pP.setBackground(Color.GREEN);

        add(precioTexto);
        add(btnVolver);
        add(btnComprar);
        // add(pP);
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
        btnComprar.setText(prop.getProperty("archivospropiedad.boton.comprar"));
    }

    /**
     * Agrega productos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Producto> listaDatos) {
        if (cantidad == -1) {
            return;
        }
        String salidaPrecio = "";
        int precioTotal = 0;
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
            txtAreaInfo.setFont(new Font("Baloo", Font.BOLD, 10));
            txtAreaInfo.setBackground(new Color(198, 195, 195));
            panelProducto.add(txtAreaInfo, BorderLayout.WEST);

            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btnAgregar = new JButton(prop.getProperty("archivospropiedad.boton.carritomenos"));
            btnAgregar.setBackground(new Color(235, 219, 79));
            btnAgregar.setFont(new Font("Baloo", Font.BOLD, 10));

            botonesEliminar.add(btnAgregar);

            panelBotones.add(btnAgregar);
            panelBotones.setBackground(new Color(198, 195, 195));

            panelProducto.add(panelBotones, BorderLayout.SOUTH);
            panelContenido.add(panelProducto);

            salidaPrecio += "\n" + listaDatos.get(i).getNombre() + ": $" + listaDatos.get(i).getPrecio();
            precioTotal += listaDatos.get(i).getPrecio();
        }
        salidaPrecio += "\n" + prop.getProperty("archivospropiedad.texto.pagototal") + precioTotal;

        precioTexto.setText(salidaPrecio);
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

            Image fdRedim = fd.getScaledInstance(300, 190, Image.SCALE_SMOOTH);
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
        botonesEliminar.clear();
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }

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
     * Obtiene el scroll para navegar en los productos del carrito.
     * 
     * @return Scroll para navegar en los productos.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll para navegar en los productos del carrito.
     * 
     * @param scrollPane Scroll para navegar en los productos.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Obtiene el panel que contiene los productos del carrito.
     * 
     * @return Panel que contiene los productos.
     */
    public JPanel getPanelContenido() {
        return panelContenido;
    }

    /**
     * Establece el panel que contiene los productos del carrito.
     * 
     * @param panelContenido Panel que contiene los productos.
     */
    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
    }

    /**
     * Obtiene el botón para realizar la compra.
     * 
     * @return Botón para realizar la compra.
     */
    public JButton getBtnComprar() {
        return btnComprar;
    }

    /**
     * Establece el botón para realizar la compra.
     * 
     * @param btnComprar Botón para realizar la compra.
     */
    public void setBtnComprar(JButton btnComprar) {
        this.btnComprar = btnComprar;
    }

    /**
     * Obtiene el área de texto que muestra el precio total.
     * 
     * @return Área de texto con el precio total.
     */
    public JTextArea getPrecioTexto() {
        return precioTexto;
    }

    /**
     * Establece el área de texto que muestra el precio total.
     * 
     * @param precioTexto Área de texto con el precio total.
     */
    public void setPrecioTexto(JTextArea precioTexto) {
        this.precioTexto = precioTexto;
    }

    /**
     * Obtiene la lista de botones para eliminar productos del carrito.
     * 
     * @return Lista de botones para eliminar productos.
     */
    public ArrayList<JButton> getBotonesEliminar() {
        return botonesEliminar;
    }

    /**
     * Establece la lista de botones para eliminar productos del carrito.
     * 
     * @param botonesEliminar Lista de botones para eliminar productos.
     */
    public void setBotonesEliminar(ArrayList<JButton> botonesEliminar) {
        this.botonesEliminar = botonesEliminar;
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
