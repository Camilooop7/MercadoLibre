package co.edu.unbosque.view;

import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de la aplicación.
 * Contiene diferentes paneles para gestionar las funcionalidades.
 */
public class VentanaPrincipalC extends JFrame {
    /** Panel principal de la aplicación. */
    private PanelPrincipalC ppc;
    /** Panel para iniciar sesión. */
    private PanelIniciarSesion pis;
    /** Panel para crear un usuario. */
    private PanelCrearU pcu;
    /** Panel del menú del cliente. */
    private PanelClienteMenu pcm;
    /** Panel del carrito de compras. */
    private PanelCarrito pc;
    /** Panel del historial de compras. */
    private PanelHistorial ph;
    /** Panel de la tienda. */
    private PanelTienda pt;
    /** Panel de favoritos. */
    private PanelFavorito pf;

    /**
     * Constructor que inicializa la ventana principal con sus paneles.
     * 
     * @param prop Propiedades para configurar los paneles.
     * @throws IOException Si ocurre un error al cargar los paneles.
     */
    public VentanaPrincipalC(Properties prop) throws IOException {

        setBounds(150, 150, 1300, 750);
        setTitle("Mercado Libre");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);
        setResizable(false);
        
        ppc = new PanelPrincipalC(prop);
        pis = new PanelIniciarSesion(prop);
        pcu = new PanelCrearU(prop);
        pcm = new PanelClienteMenu(prop);
        pc = new PanelCarrito(prop);
        ph = new PanelHistorial(prop);
        pt = new PanelTienda(prop);
        pf = new PanelFavorito(prop);

        add(ppc).setVisible(true);
        add(pis).setVisible(false);
        add(pcu).setVisible(false);
        add(pcm).setVisible(false);
        add(pc).setVisible(false);
        add(ph).setVisible(false);
        add(pt).setVisible(false);
        add(pf).setVisible(false);
        

    }
    
    /**
     * Refresca la interfaz de usuario actualizando los paneles con nuevas propiedades.
     * 
     * @param prop Propiedades actualizadas.
     * @throws IOException Si ocurre un error al actualizar los paneles.
     */
    public void refrescarUI(Properties prop) throws IOException {
        // Aplicar revalidate() y repaint() a todos los paneles
        ppc.setProp(prop);
        ppc.actualizarComp();
        ppc.revalidate();
        ppc.repaint();
        
        pis.setProp(prop);
        pis.actualizarComp();
        pis.revalidate();
        pis.repaint();

        pcu.setProp(prop);
        pcu.actualizarComp();
        pcu.revalidate();
        pcu.repaint();

        pcm.setProp(prop);
        pcm.actualizarComp();
        pcm.revalidate();
        pcm.repaint();

        pc.setProp(prop);
        pc.actualizarComp();
        pc.revalidate();
        pc.repaint();

        ph.setProp(prop);
        ph.actualizarComp();
        ph.revalidate();
        ph.repaint();

        pt.setProp(prop);
        pt.actualizarComp();
        pt.revalidate();
        pt.repaint();

        pf.setProp(prop);
        pf.actualizarComp();
        pf.revalidate();
        pf.repaint();
        
        // También actualizar la ventana principal
        this.revalidate();
        this.repaint();
    }

    // Métodos getter y setter

    /**
     * Obtiene el panel del carrito de compras.
     * 
     * @return Panel del carrito de compras.
     */
    public PanelCarrito getPc() {
        return pc;
    }

    /**
     * Establece el panel del carrito de compras.
     * 
     * @param pc Panel del carrito de compras.
     */
    public void setPc(PanelCarrito pc) {
        this.pc = pc;
    }  

    /**
     * Obtiene el panel principal de la aplicación.
     * 
     * @return Panel principal de la aplicación.
     */
    public PanelPrincipalC getPpc() {
        return ppc;
    }

    /**
     * Establece el panel principal de la aplicación.
     * 
     * @param ppc Panel principal de la aplicación.
     */
    public void setPpc(PanelPrincipalC ppc) {
        this.ppc = ppc;
    }

    /**
     * Obtiene el panel para iniciar sesión.
     * 
     * @return Panel para iniciar sesión.
     */
    public PanelIniciarSesion getPis() {
        return pis;
    }

    /**
     * Establece el panel para iniciar sesión.
     * 
     * @param pis Panel para iniciar sesión.
     */
    public void setPis(PanelIniciarSesion pis) {
        this.pis = pis;
    }

    /**
     * Obtiene el panel para crear un usuario.
     * 
     * @return Panel para crear un usuario.
     */
    public PanelCrearU getPcu() {
        return pcu;
    }

    /**
     * Establece el panel para crear un usuario.
     * 
     * @param pcu Panel para crear un usuario.
     */
    public void setPcu(PanelCrearU pcu) {
        this.pcu = pcu;
    }

    /**
     * Obtiene el panel del menú del cliente.
     * 
     * @return Panel del menú del cliente.
     */
    public PanelClienteMenu getPcm() {
        return pcm;
    }

    /**
     * Establece el panel del menú del cliente.
     * 
     * @param pcm Panel del menú del cliente.
     */
    public void setPc(PanelClienteMenu pcm) {
        this.pcm = pcm;
    }

    /**
     * Obtiene el panel del historial de compras.
     * 
     * @return Panel del historial de compras.
     */
    public PanelHistorial getPh() {
        return ph;
    }

    /**
     * Establece el panel del historial de compras.
     * 
     * @param ph Panel del historial de compras.
     */
    public void setPh(PanelHistorial ph) {
        this.ph = ph;
    }

    /**
     * Obtiene el panel de la tienda.
     * 
     * @return Panel de la tienda.
     */
    public PanelTienda getPt() {
        return pt;
    }

    /**
     * Establece el panel de la tienda.
     * 
     * @param pt Panel de la tienda.
     */
    public void setPt(PanelTienda pt) {
        this.pt = pt;
    }

    /**
     * Obtiene el panel de favoritos.
     * 
     * @return Panel de favoritos.
     */
    public PanelFavorito getPf() {
        return pf;
    }

    /**
     * Establece el panel de favoritos.
     * 
     * @param pf Panel de favoritos.
     */
    public void setPf(PanelFavorito pf) {
        this.pf = pf;
    }

    /**
     * Establece el panel del menú del cliente.
     * 
     * @param pcm Panel del menú del cliente.
     */
    public void setPcm(PanelClienteMenu pcm) {
        this.pcm = pcm;
    }
}
