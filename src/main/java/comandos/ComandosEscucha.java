package comandos;

import juego.Juego;
import mensajeria.Comando;

/**
 * The Class ComandosEscucha.
 */
public abstract class ComandosEscucha extends Comando {

    /**
     * The juego.
     */
    protected Juego juego;

    /**
     * Sets the juego.
     *
     * @param juegoParam
     *            the new juego
     */
    public void setJuego(final Juego juegoParam) {
        this.juego = juegoParam;
    }

}
