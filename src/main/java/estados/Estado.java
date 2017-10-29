package estados;

import java.awt.Graphics;

import juego.Juego;

/**
 * The Class Estado.
 */
public abstract class Estado {

    /**
     * The estado actual.
     */
    private static Estado estadoActual = null;

    /**
     * The estado offline.
     */
    // Tipo de estados
    public static final int ESTADOOFFLINE = 0;

    /**
     * The estado juego.
     */
    public static final int ESTADOJUEGO = 1;

    /**
     * The estado batalla.
     */
    public static final int ESTADOBATALLA = 2;

    /**
     * The estado batalla NPC.
     */
    public static final int ESTADOBATALLANPC = 3;

    /**
     * The juego.
     */
    protected Juego juego;

    /**
     * Instantiates a new estado.
     *
     * @param juegoParam the juego
     */
    public Estado(final Juego juegoParam) {
        this.juego = juegoParam;
    }

    /**
     * Actualizar.
     */
    public abstract void actualizar();

    /**
     * Graficar.
     *
     * @param g
     *            the g
     */
    public abstract void graficar(Graphics g);

    /**
     * Sets the estado.
     *
     * @param estadoParam the new estado
     */
    public static void setEstado(final Estado estadoParam) {
        estadoActual = estadoParam;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public static Estado getEstado() {
        return estadoActual;
    }

    /**
     * Es estado de juego.
     *
     * @return true, if successful
     */
    public abstract boolean esEstadoDeJuego();
}
