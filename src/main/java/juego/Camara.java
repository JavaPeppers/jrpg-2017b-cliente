package juego;

import entidades.Entidad;

/**
 * The Class Camara.
 */
public class Camara {

    /**
     * The juego.
     */
    private Juego juego;

    /**
     * The y offset.
     */
    private float yOffset;

    /**
     * The x offset.
     */
    private float xOffset;

    /**
     * Instantiates a new camara.
     *
     * @param juegoParam
     *            the juego param
     * @param xOffsetParam
     *            the x offset param
     * @param yOffsetParam
     *            the y offset param
     */
    public Camara(final Juego juegoParam, final float xOffsetParam,
            final float yOffsetParam) {
        this.juego = juegoParam;
        this.xOffset = xOffsetParam;
        this.yOffset = yOffsetParam;
    }

    /**
     * Centrar.
     *
     * @param e
     *            the e
     */
    public void centrar(final Entidad e) {
        xOffset = e.getX() - juego.getAncho() / 2 + e.getAncho() / 2;
        yOffset = e.getY() - juego.getAlto() / 2 + e.getAlto() / 2;
    }

    /**
     * Mover.
     *
     * @param dxParam
     *            the dx param
     * @param dyParam
     *            the dy param
     */
    public void mover(final float dxParam, final float dyParam) {
        xOffset += dxParam;
        yOffset += dyParam;
    }

    /**
     * Gets the y offset.
     *
     * @return the y offset
     */
    public float getyOffset() {
        return yOffset;
    }

    /**
     * Sets the y offset.
     *
     * @param yOffsetParam
     *            the new y offset
     */
    public void setyOffset(final float yOffsetParam) {
        this.yOffset = yOffsetParam;
    }

    /**
     * Gets the x offset.
     *
     * @return the x offset
     */
    public float getxOffset() {
        return xOffset;
    }

    /**
     * Sets the x offset.
     *
     * @param xOffsetParam
     *            the new x offset
     */
    public void setxOffset(final float xOffsetParam) {
        this.xOffset = xOffsetParam;
    }
}
