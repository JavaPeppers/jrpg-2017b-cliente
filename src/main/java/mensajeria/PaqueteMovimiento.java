package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteMovimiento.
 */
@SuppressWarnings("serial")
public class PaqueteMovimiento extends Paquete
        implements Serializable, Cloneable {

    /**
     * The id.
     */
    private int id;

    /**
     * The pos X.
     */
    private float posX;

    /**
     * The pos Y.
     */
    private float posY;

    /**
     * The direccion.
     */
    private int direccion;

    /**
     * The frame.
     */
    private int frame;

    /**
     * Instantiates a new paquete movimiento.
     */
    public PaqueteMovimiento() {
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Instantiates a new paquete movimiento.
     *
     * @param idPersonajeParam
     *            the id personaje
     */
    public PaqueteMovimiento(final int idPersonajeParam) {
        id = idPersonajeParam;
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Instantiates a new paquete movimiento.
     *
     * @param idPersonajeParam
     *            the id personaje
     * @param posXParam
     *            the pos X
     * @param posYParam
     *            the pos Y
     */
    public PaqueteMovimiento(final int idPersonajeParam, final float posXParam,
            final float posYParam) {
        this.id = idPersonajeParam;
        this.posX = posXParam;
        this.posY = posYParam;
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Gets the id personaje.
     *
     * @return the id personaje
     */
    public int getIdPersonaje() {
        return id;
    }

    /**
     * Sets the id personaje.
     *
     * @param idPersonajeParam
     *            the new id personaje
     */
    public void setIdPersonaje(final int idPersonajeParam) {
        this.id = idPersonajeParam;
    }

    /**
     * Gets the pos X.
     *
     * @return the pos X
     */
    public float getPosX() {
        return posX;
    }

    /**
     * Sets the pos X.
     *
     * @param posXParam
     *            the new pos X
     */
    public void setPosX(final float posXParam) {
        this.posX = posXParam;
    }

    /**
     * Gets the pos Y.
     *
     * @return the pos Y
     */
    public float getPosY() {
        return posY;
    }

    /**
     * Sets the pos Y.
     *
     * @param posYParam
     *            the new pos Y
     */
    public void setPosY(final float posYParam) {
        this.posY = posYParam;
    }

    /**
     * Gets the direccion.
     *
     * @return the direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * Sets the direccion.
     *
     * @param direccionParam
     *            the new direccion
     */
    public void setDireccion(final int direccionParam) {
        this.direccion = direccionParam;
    }

    /**
     * Gets the frame.
     *
     * @return the frame
     */
    public int getFrame() {
        return frame;
    }

    /**
     * Sets the frame.
     *
     * @param frameParam
     *            the new frame
     */
    public void setFrame(final int frameParam) {
        this.frame = frameParam;
    }

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
