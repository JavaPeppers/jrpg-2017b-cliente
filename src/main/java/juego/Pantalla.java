package juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.google.gson.Gson;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;
import frames.MenuAsignarSkills;
import frames.MenuEscape;
import frames.MenuInventario;
import frames.MenuJugar;
import frames.MenuStats;
import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * The Class Pantalla.
 */
public class Pantalla {

    /**
     * The pantalla.
     */
    private JFrame pantalla;

    /**
     * The canvas.
     */
    private Canvas canvas;

    /**
     * The menu inventario.
     */
    // Menus
    private static MenuInventario menuInventario;

    /**
     * The menu asignar.
     */
    private static MenuAsignarSkills menuAsignar;

    /**
     * The menu stats.
     */
    private static MenuStats menuStats;

    /**
     * The menu escp.
     */
    private static MenuEscape menuEscp;

    /**
     * The vent contac.
     */
    private static VentanaContactos ventContac;

    /**
     * The gson.
     */
    private final Gson gson = new Gson();

    /**
     * Instantiates a new pantalla.
     *
     * @param nombre
     *            the nombre
     * @param ancho
     *            the ancho
     * @param alto
     *            the alto
     * @param cliente
     *            the cliente
     */
    public Pantalla(final String nombre, final int ancho, final int alto,
            final Cliente cliente) {
        pantalla = new JFrame(nombre);
        pantalla.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        pantalla.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));

        pantalla.setSize(ancho, alto);
        pantalla.setResizable(false);
        pantalla.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        pantalla.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent evt) {
                try {
                    Paquete p = new Paquete();
                    p.setComando(Comando.DESCONECTAR);
                    p.setIp(cliente.getMiIp());
                    cliente.getSalida().writeObject(gson.toJson(p));
                    cliente.getEntrada().close();
                    cliente.getSalida().close();
                    cliente.getSocket().close();
                    System.exit(0);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,
                            "Fallo al intentar cerrar la aplicación.");
                    System.exit(1);
                }
            }
        });
        pantalla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_I) {
                    if (Estado.getEstado().esEstadoDeJuego()) {
                        if (menuInventario == null) {
                            menuInventario = new MenuInventario(cliente);
                            menuInventario.setVisible(true);
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    if (Estado.getEstado().esEstadoDeJuego()) {
                        if (menuAsignar == null) {
                            menuAsignar = new MenuAsignarSkills(cliente);
                            menuAsignar.setVisible(true);
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (Estado.getEstado().esEstadoDeJuego()) {
                        if (menuStats == null) {
                            menuStats = new MenuStats(cliente);
                            menuStats.setVisible(true);
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (Estado.getEstado().esEstadoDeJuego()) {
                        if (menuEscp == null) {
                            menuEscp = new MenuEscape(cliente);
                            menuEscp.setVisible(true);
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    // if(Estado.getEstado().esEstadoDeJuego()) {
                    if (ventContac == null) {
                        ventContac = new VentanaContactos(cliente.getJuego());
                        ventContac.setVisible(true);
                    }
                    // }
                }
            }
        });

        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(ancho, alto));
        canvas.setMaximumSize(new Dimension(ancho, alto));
        canvas.setMinimumSize(new Dimension(ancho, alto));
        canvas.setFocusable(false);

        pantalla.add(canvas);
        pantalla.pack();
    }

    /**
     * Gets the canvas.
     *
     * @return the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Get la ventana contactos.
     *
     * @return ventContac
     */
    public static VentanaContactos getVentContac() {
        return ventContac;
    }

    /**
     * Set la ventana contactos.
     *
     * @param ventContacParam
     *            ventana contactos a setear.
     */
    public static void setVentContac(final VentanaContactos ventContacParam) {
        Pantalla.ventContac = ventContacParam;
    }

    /**
     * Gets the frame.
     *
     * @return the frame
     */
    public JFrame getFrame() {
        return pantalla;
    }

    /**
     * Mostrar.
     */
    public void mostrar() {
        pantalla.setVisible(true);
    }

    /**
     * Center string.
     *
     * @param g
     *            the g
     * @param r
     *            the r
     * @param s
     *            the s
     */
    public static void centerString(final Graphics g, final Rectangle r,
            final String s) {
        FontRenderContext frc = new FontRenderContext(null, true, true);

        Rectangle2D r2D = g.getFont().getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;

        g.drawString(s, r.x + a, r.y + b);
    }

    /**
     * @return the menuAsignar
     */
    public static MenuAsignarSkills getMenuAsignar() {
        return menuAsignar;
    }

    /**
     * @param menuAsignarParam
     *            the menuAsignar to set
     */
    public static void setMenuAsignar(
            final MenuAsignarSkills menuAsignarParam) {
        Pantalla.menuAsignar = menuAsignarParam;
    }

    /**
     * @return the menuInventario
     */
    public static MenuInventario getMenuInventario() {
        return menuInventario;
    }

    /**
     * @param menuInventarioParam
     *            the menuInventario to set
     */
    public static void setMenuInventario(
            final MenuInventario menuInventarioParam) {
        Pantalla.menuInventario = menuInventarioParam;
    }

    /**
     * @return the menuStats
     */
    public static MenuStats getMenuStats() {
        return menuStats;
    }

    /**
     * @param menuStatsParam
     *            the menuStats to set
     */
    public static void setMenuStats(final MenuStats menuStatsParam) {
        Pantalla.menuStats = menuStatsParam;
    }

    /**
     * @return the menuEscp
     */
    public static MenuEscape getMenuEscp() {
        return menuEscp;
    }

    /**
     * @param menuEscpParam
     *            the menuEscp to set
     */
    public static void setMenuEscp(final MenuEscape menuEscpParam) {
        Pantalla.menuEscp = menuEscpParam;
    }
}
