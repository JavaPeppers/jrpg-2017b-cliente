package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    /** Constante YPARAM. */
    private static final int YPARAM = 50;

    /** Constante XPARAM. */
    private static final int XPARAM = 300;

    /** Constante ANCHOALTURA. */
    private static final int ANCHOALTURA = 64;

    /** Constante ALTURARECTANGULO. */
    private static final int ALTURARECTANGULO = 10;

    /** Constante YOFFSET. */
    private static final int YOFFSET = 20;

    /** Constante XOFFSET. */
    private static final int XOFFSET = 32;

    /** Constante TAMFONT. */
    private static final int TAMFONT = 15;

    /** Constante ALTOCHAT. */
    private static final int ALTOCHAT = 35;

    /** Constante ANCHOCHAT. */
    private static final int ANCHOCHAT = 102;

    /** Constante POSCHATY. */
    private static final int POSCHATY = 524;

    /** Constante POSCHATX. */
    private static final int POSCHATX = 3;

    /** Constante ALTOMENU. */
    private static final int ALTOMENU = 35;

    /** Constante ANCHOMENU. */
    private static final int ANCHOMENU = 102;

    /** Constante POSMENUY. */
    private static final int POSMENUY = 562;

    /** Constante POSMENUX. */
    private static final int POSMENUX = 3;

    /** Constante ALTOMOCHILA. */
    private static final int ALTOMOCHILA = 52;

    /** Constante ANCHOMOCHILA. */
    private static final int ANCHOMOCHILA = 59;

    /** Constante POSMOCHILAY. */
    private static final int POSMOCHILAY = 545;

    /** Constante POSMOCHILAX. */
    private static final int POSMOCHILAX = 738;

    /** Constante POSJUGADORY. */
    private static final int POSJUGADORY = 5;

    /** Constante POSJUGADORX. */
    private static final int POSJUGADORX = 5;

    /** Constante VELANIMACION. */
    private static final int VELANIMACION = 150;

    /** Constante ANCHOALTO. */
    private static final int ANCHOALTO = 64;

    /** Constante RAZA. */
    private static final int RAZA = 5;

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
     * Lista con los mapas disponibles en el juego.
     */
    private static final ArrayList<String> MUNDOSDISPONIBLES
            = new ArrayList<String>(
            Arrays.asList("Aubenor", "Aris", "Eodrim"));

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
        entidadPersonaje = new Entidad(juego, mundo, ANCHOALTO, ANCHOALTO,
                juego.getPersonaje().getNombre(), 0, 0,
                Recursos.getPersonaje().get(juego.getPersonaje().getRaza()),
                VELANIMACION);
        miniaturaPersonaje = Recursos.getPersonaje()
                .get(paquetePersonaje.getRaza()).get(RAZA)[0];

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
        EstadoDePersonaje.dibujarEstadoDePersonaje(g, POSJUGADORX, POSJUGADORY,
                paquetePersonaje, miniaturaPersonaje);
        g.drawImage(Recursos.getMochila(), POSMOCHILAX, POSMOCHILAY,
                ANCHOMOCHILA, ALTOMOCHILA, null);
        g.drawImage(Recursos.getMenu(), POSMENUX, POSMENUY, ANCHOMENU, ALTOMENU,
                null);
        g.drawImage(Recursos.getChat(), POSCHATX, POSCHATY, ANCHOCHAT, ALTOCHAT,
                null);
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
            g.setFont(new Font("Book Antiqua", Font.PLAIN, TAMFONT));
            while (it.hasNext()) {
                key = it.next();
                actual = enemigos.get(key);
                if (actual != null
                        && enemigos.get(actual.getId())
                                .getEstado() == Estado.ESTADOJUEGO
                        && key != -21) {
                    Pantalla.centerString(g, new Rectangle(
                            (int) (actual.getX()
                                    - juego.getCamara().getxOffset() + XOFFSET),
                            (int) (actual.getY()
                                    - juego.getCamara().getyOffset() - YOFFSET),
                            0, ALTURARECTANGULO),
                            enemigos.get(actual.getId()).getNombre());
                    g.drawImage(Recursos.getWizard().get(0)[0],
                            (int) (actual.getX()
                                    - juego.getCamara().getxOffset()),
                            (int) (actual.getY()
                                    - juego.getCamara().getyOffset()),
                            ANCHOALTURA, ANCHOALTURA, null);
                }
                if (key == -21 && enemigos.get(actual.getId())
                        .getEstado() == Estado.ESTADOJUEGO) {
                    Pantalla.centerString(g, new Rectangle(
                            (int) (actual.getX()
                                    - juego.getCamara().getxOffset() + XOFFSET),
                            (int) (actual.getY()
                                    - juego.getCamara().getyOffset() - YOFFSET),
                            0, ALTURARECTANGULO),
                            enemigos.get(actual.getId()).getNombre());
                    g.drawImage(Recursos.getSkullReaper().get(0)[0],
                            (int) (actual.getX()
                                    - juego.getCamara().getxOffset()),
                            (int) (actual.getY()
                                    - juego.getCamara().getyOffset()),
                            150, 100, null);
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
            g.setFont(new Font("Book Antiqua", Font.PLAIN, TAMFONT));
            while (it.hasNext()) {
                key = it.next();
                actual = ubicacionPersonajes.get(key);
                if (condicionesParaGraficar(actual)) {
                    Pantalla.centerString(g, new Rectangle(
                            (int) (actual.getPosX()
                                    - juego.getCamara().getxOffset() + XOFFSET),
                            (int) (actual.getPosY()
                                    - juego.getCamara().getyOffset() - YOFFSET),
                            0, ALTURARECTANGULO),
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
                            ANCHOALTURA, ANCHOALTURA, null);
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
        return MUNDOSDISPONIBLES.get(juego.getPersonaje().getMapa() - 1);
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
        menuEnemigo = new MenuInfoPersonaje(XPARAM, YPARAM, enemigo);
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

    /**
     * Condiciones para graficar.
     *
     * @param actual the actual
     * @return true, if successful
     */
    public boolean condicionesParaGraficar(final PaqueteMovimiento actual) {
        if (actual != null
                && actual.getIdPersonaje() != juego.getPersonaje().getId()
                && personajesConectados.get(actual.getIdPersonaje())
                        .getEstado() == Estado.ESTADOJUEGO
                && personajesConectados.get(actual.getIdPersonaje())
                        .getMapa() == juego.getPersonaje().getMapa()) {
            if ((!personajesConectados.get(actual.getIdPersonaje())
                    .isModoInvisible())
                    || (personajesConectados.get(actual.getIdPersonaje())
                            .isModoInvisible()
                            && juego.getPersonaje().isModoInvisible())) {
                return true;
            }
        }
        return false;
    }

}
