package entidades;

import java.awt.image.BufferedImage;

/**
 * La clase Animacion tiene como función. controlar las animaciones.
 */
public class Animacion {

    /**
     * The velocidad.
     */
    private int velocidad;

    /**
     * The indice.
     */
    private int indice;

    /**
     * The timer.
     */
    private long ultimoTiempo, timer;

    /**
     * The frames.
     */
    private BufferedImage[] frames;

    /**
     * Constructor de la clase.
     *
     * @param velocidadParam
     *            velocidad con la cual se actualiza
     * @param framesParam
     *            imagen de frame
     */
    public Animacion(final int velocidadParam,
            final BufferedImage[] framesParam) {
        this.velocidad = velocidadParam;
        this.frames = framesParam;
        indice = 0;
        timer = 0;
        ultimoTiempo = System.currentTimeMillis();
    }

    /**
     * Actualiza los frames.
     */
    public void actualizar() {
        timer += System.currentTimeMillis() - ultimoTiempo;
        ultimoTiempo = System.currentTimeMillis();

        if (timer > velocidad) {
            indice++;
            timer = 0;
            if (indice >= frames.length) {
                indice = 0;
            }
        }
    }

    /**
     * Resetea el indice.
     */
    public void reset() {
        indice = 0;
    }

    /**
     * Pide el frame actual.
     *
     * @return devuelve el valor del frame en un indice
     */
    public BufferedImage getFrameActual() {
        return frames[indice];
    }

    /**
     * Pide el frame.
     *
     * @return devuelve el indice del frame
     */
    public int getFrame() {
        return indice;
    }
}
