package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entidades.Entidad;
import interfaz.EstadoDePersonaje;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoJuego.
 */
public class EstadoJuego extends Estado {

    /**
     * The entidad personaje.
     */
    private Entidad entidadPersonaje;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The mundo.
     */
    private Mundo mundo;

    /**
     * The ubicacion personajes.
     */
    private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;

    /**
     * The personajes conectados.
     */
    private Map<Integer, PaquetePersonaje> personajesConectados;

    /**
     * The enemigos.
     */
    private Map<Integer, PaqueteEnemigo> enemigos;

    /**
     * The hay solicitud.
     */
    private boolean haySolicitud;

    /**
     * The tipo solicitud.
     */
    private int tipoSolicitud;

    /**
     * The gson.
     */
    private final Gson gson = new Gson();

    /**
     * The miniatura personaje.
     */
    private BufferedImage miniaturaPersonaje;

    /**
     * The menu enemigo.
     */
    private MenuInfoPersonaje menuEnemigo;

    /**
     * Instantiates a new estado juego.
     *
     * @param juego
     *            the juego
     */
    public EstadoJuego(final Juego juego) {
        super(juego);
        mundo = new Mundo(juego, "recursos/" + getMundo() + ".txt",
                "recursos/" + getMundo() + ".txt");
        paquetePersonaje = juego.getPersonaje();
        entidadPersonaje = new Entidad(juego, mundo, 64, 64,
                juego.getPersonaje().getNombre(), 0, 0,
                Recursos.getPersonaje().get(juego.getPersonaje().getRaza()),
                150);
        miniaturaPersonaje = Recursos.getPersonaje()
                .get(paquetePersonaje.getRaza()).get(5)[0];

        try {
            // Le envio al servidor que me conecte al mapa y mi posicion
            juego.getPersonaje().setComando(Comando.CONEXION);
            juego.getPersonaje().setEstado(Estado.ESTADOJUEGO);
            juego.getCliente().getSalida().writeObject(
                    gson.toJson(juego.getPersonaje(), PaquetePersonaje.class));
            juego.getCliente().getSalida().writeObject(gson.toJson(
                    juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo la conexión con el servidor al ingresar al mundo");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see estados.Estado#actualizar()
     */
    @Override
    public void actualizar() {
        mundo.actualizar();
        entidadPersonaje.actualizar();
    }

    /*
     * (non-Javadoc)
     *
     * @see estados.Estado#graficar(java.awt.Graphics)
     */
    @Override
    public void graficar(final Graphics g) {
        g.drawImage(Recursos.getBackground(), 0, 0, juego.getAncho(),
                juego.getAlto(), null);
        mundo.graficar(g);
        graficarPersonajes(g);
        graficarEnemigos(g);
        mundo.graficarObstaculos(g);
        entidadPersonaje.graficarNombre(g);
        g.drawImage(Recursos.getMarco(), 0, 0, juego.getAncho(),
                juego.getAlto(), null);
        EstadoDePersonaje.dibujarEstadoDePersonaje(g, 5, 5, paquetePersonaje,
                miniaturaPersonaje);
        g.drawImage(Recursos.getMochila(), 738, 545, 59, 52, null);
        g.drawImage(Recursos.getMenu(), 3, 562, 102, 35, null);
        g.drawImage(Recursos.getChat(), 3, 524, 102, 35, null);
        if (haySolicitud) {
            menuEnemigo.graficar(g, tipoSolicitud);
        }
    }

    /**
     * Graficar enemigos.
     *
     * @param g
     *            the g
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void graficarEnemigos(final Graphics g) {
        if (juego.getEnemigos() != null) {
            enemigos = new HashMap(juego.getEnemigos());
            Iterator<Integer> it = enemigos.keySet().iterator();
            int key;
            PaqueteEnemigo actual;
            g.setColor(Color.WHITE);
            g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
            while (it.hasNext()) {
                key = it.next();
                actual = enemigos.get(key);
                if (actual != null && enemigos.get(actual.getId())
                        .getEstado() == Estado.ESTADOJUEGO) {
                    Pantalla.centerString(g, new Rectangle(
                            (int) (actual.getX()
                                    - juego.getCamara().getxOffset() + 32),
                            (int) (actual.getY()
                                    - juego.getCamara().getyOffset() - 20),
                            0, 10), enemigos.get(actual.getId()).getNombre());
                    g.drawImage(Recursos.getSalvaje().get(5)[0],
                            (int) (actual.getX()
                                    - juego.getCamara().getxOffset()),
                            (int) (actual.getY()
                                    - juego.getCamara().getyOffset()),
                            64, 64, null);
                }
            }
        }
    }

    /**
     * Graficar personajes.
     *
     * @param g
     *            the g
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void graficarPersonajes(final Graphics g) {

        if (juego.getPersonajesConectados() != null) {
            personajesConectados = new HashMap(juego.getPersonajesConectados());
            ubicacionPersonajes = new HashMap(juego.getUbicacionPersonajes());
            Iterator<Integer> it = personajesConectados.keySet().iterator();
            int key;
            PaqueteMovimiento actual;
            g.setColor(Color.WHITE);
            g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
            while (it.hasNext()) {
                key = it.next();
                actual = ubicacionPersonajes.get(key);
                if (actual != null
                        && actual.getIdPersonaje() != juego.getPersonaje()
                                .getId()
                        && personajesConectados.get(actual.getIdPersonaje())
                                .getEstado() == Estado.ESTADOJUEGO) {
                    Pantalla.centerString(g, new Rectangle(
                            (int) (actual.getPosX()
                                    - juego.getCamara().getxOffset() + 32),
                            (int) (actual.getPosY()
                                    - juego.getCamara().getyOffset() - 20),
                            0, 10),
                            personajesConectados.get(actual.getIdPersonaje())
                                    .getNombre());
                    g.drawImage(Recursos.getPersonaje()
                            .get(personajesConectados
                                    .get(actual.getIdPersonaje()).getRaza())
                            .get(actual.getDireccion())[actual.getFrame()],
                            (int) (actual.getPosX()
                                    - juego.getCamara().getxOffset()),
                            (int) (actual.getPosY()
                                    - juego.getCamara().getyOffset()),
                            64, 64, null);
                }
            }
        }
    }

    /**
     * Gets the personaje.
     *
     * @return the personaje
     */
    public Entidad getPersonaje() {
        return entidadPersonaje;
    }

    /**
     * Gets the mundo.
     *
     * @return the mundo
     */
    private String getMundo() {
        int mundoParam = juego.getPersonaje().getMapa();

        if (mundoParam == 1) {
            return "Aubenor";
        } else if (mundoParam == 2) {
            return "Aris";
        } else if (mundoParam == 3) {
            return "Eodrim";
        }

        return null;
    }

    /**
     * Sets the hay solicitud.
     *
     * @param b
     *            the b
     * @param enemigo
     *            the enemigo
     * @param tipoSolicitudParam
     *            the tipo solicitud
     */
    public void setHaySolicitud(final boolean b, final PaquetePersonaje enemigo,
            final int tipoSolicitudParam) {
        haySolicitud = b;
        // menu que mostrara al enemigo
        menuEnemigo = new MenuInfoPersonaje(300, 50, enemigo);
        this.tipoSolicitud = tipoSolicitudParam;
    }

    /**
     * Gets the hay solicitud.
     *
     * @return the hay solicitud
     */
    public boolean getHaySolicitud() {
        return haySolicitud;
    }

    /**
     * Actualizar personaje.
     */
    public void actualizarPersonaje() {
        paquetePersonaje = juego.getPersonaje();
    }

    /**
     * Gets the menu enemigo.
     *
     * @return the menu enemigo
     */
    public MenuInfoPersonaje getMenuEnemigo() {
        return menuEnemigo;
    }

    /**
     * Gets the tipo solicitud.
     *
     * @return the tipo solicitud
     */
    public int getTipoSolicitud() {
        return tipoSolicitud;
    }

    /*
     * (non-Javadoc)
     *
     * @see estados.Estado#esEstadoDeJuego()
     */
    @Override
    public boolean esEstadoDeJuego() {
        return true;
    }

}
