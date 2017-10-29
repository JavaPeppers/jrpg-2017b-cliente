package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * The Class PaqueteDeMovimientos.
 */
@SuppressWarnings("serial")
public class PaqueteDeMovimientos extends Paquete
        implements Serializable, Cloneable {

    /**
     * The personajes.
     */
    private Map<Integer, PaqueteMovimiento> personajes;

    /**
     * Instantiates a new paquete de movimientos.
     */
    public PaqueteDeMovimientos() {

    }

    /**
     * Instantiates a new paquete de movimientos.
     *
     * @param personajesParam
     *            the personajes
     */
    public PaqueteDeMovimientos(
            final Map<Integer, PaqueteMovimiento> personajesParam) {
        this.personajes = personajesParam;
    }

    /**
     * Gets the personajes.
     *
     * @return the personajes
     */
    public Map<Integer, PaqueteMovimiento> getPersonajes() {
        return personajes;
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
