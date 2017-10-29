package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteMensaje.
 */
@SuppressWarnings("serial")
public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {

    /**
     * The user emisor.
     */
    private String userEmisor;

    /**
     * The user receptor.
     */
    private String userReceptor;

    /**
     * The msj.
     */
    private String msj;

    /**
     * Instantiates a new paquete mensaje.
     */
    public PaqueteMensaje() {
    }

    /**
     * getter de Mensaje.
     * @return mensaje.
     */
    public String getMensaje() {
        return msj;
    }

    /**
     * setter de Mensaje.
     * @param mensaje mensaje recibido.
     */
    public void setMensaje(final String mensaje) {
        this.msj = mensaje;
    }

    /**
     * Gets the user emisor.
     *
     * @return the user emisor
     */
    public String getUserEmisor() {
        return userEmisor;
    }

    /**
     * Sets the user emisor.
     *
     * @param idEmisorParam
     *            the new user emisor
     */
    public void setUserEmisor(final String idEmisorParam) {
        this.userEmisor = idEmisorParam;
    }

    /**
     * Gets the user receptor.
     *
     * @return the user receptor
     */
    public String getUserReceptor() {
        return userReceptor;
    }

    /**
     * Sets the user receptor.
     *
     * @param idReceptorParam
     *            the new user receptor
     */
    public void setUserReceptor(final String idReceptorParam) {
        this.userReceptor = idReceptorParam;
    }

    /**
     * metodo para clonar.
     * @return el objeto clonado.
     */
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
