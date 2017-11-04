package mensajeria;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class PaqueteDePersonajes.
 */
@SuppressWarnings("serial")
public class PaqueteDePersonajes extends Paquete
        implements Serializable, Cloneable {

    /**
     * The personajes.
     */
    private Map<Integer, PaquetePersonaje> personajes;

    /**
     * Instantiates a new paquete de personajes.
     */
    public PaqueteDePersonajes() {
        this.personajes = new HashMap<Integer, PaquetePersonaje>();
    }

    /**
     * Instantiates a new paquete de personajes.
     *
     * @param personajesParam
     *            the personajes
     */
    public PaqueteDePersonajes(
            final Map<Integer, PaquetePersonaje> personajesParam) {
        this.personajes = personajesParam;
    }

    /**
     * Gets the personajes.
     *
     * @return the personajes
     */
    public Map<Integer, PaquetePersonaje> getPersonajes() {
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
