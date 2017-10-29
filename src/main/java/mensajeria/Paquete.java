package mensajeria;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * The Class Paquete.
 */
@SuppressWarnings("serial")
public class Paquete implements Serializable, Cloneable {

    /**
     * The msj exito.
     */
    public static String msjExito = "1";

    /**
     * The msj fracaso.
     */
    public static String msjFracaso = "0";

    /**
     * The mensaje.
     */
    private String mensaje;

    /**
     * The ip.
     */
    private String ip;

    /**
     * The comando.
     */
    private int comando;

    /**
     * Instantiates a new paquete.
     */
    public Paquete() {

    }

    /**
     * Instantiates a new paquete.
     *
     * @param mensajeParam
     *            the mensaje
     * @param nick
     *            the nick
     * @param ipParam
     *            the ip
     * @param comandoParam
     *            the comando
     */
    public Paquete(final String mensajeParam, final String nick,
            final String ipParam, final int comandoParam) {
        this.mensaje = mensajeParam;
        this.ip = ipParam;
        this.comando = comandoParam;
    }

    /**
     * Instantiates a new paquete.
     *
     * @param mensajeParam
     *            the mensaje
     * @param comandoParam
     *            the comando
     */
    public Paquete(final String mensajeParam, final int comandoParam) {
        this.mensaje = mensajeParam;
        this.comando = comandoParam;
    }

    /**
     * Instantiates a new paquete.
     *
     * @param comandoParam
     *            the comando
     */
    public Paquete(final int comandoParam) {
        this.comando = comandoParam;
    }

    /**
     * Sets the mensaje.
     *
     * @param mensajeParam
     *            the new mensaje
     */
    public void setMensaje(final String mensajeParam) {
        this.mensaje = mensajeParam;
    }

    /**
     * Sets the ip.
     *
     * @param ipParam
     *            the new ip
     */
    public void setIp(final String ipParam) {
        this.ip = ipParam;
    }

    /**
     * Sets the comando.
     *
     * @param comandoParam
     *            the new comando
     */
    public void setComando(final int comandoParam) {
        this.comando = comandoParam;
    }

    /**
     * Gets the mensaje.
     *
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Gets the ip.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Gets the comando.
     *
     * @return the comando
     */
    public int getComando() {
        return comando;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Error al clonar");

        }
        return obj;
    }

    /**
     * Gets the objeto.
     *
     * @param nombrePaquete
     *            the nombre paquete
     * @return the objeto
     */
    public Comando getObjeto(final String nombrePaquete) {
        try {
            Comando c;
            c = (Comando) Class
                    .forName(nombrePaquete + "." + Comando.CLASSNAMES[comando])
                    .newInstance();
            return c;
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException e) {
            return null;
        }

    }

    /**
     * Gets the objeto set.
     *
     * @param nombrePaquete
     *            the nombre paquete
     * @param accion
     *            the accion
     * @return the objeto set
     */
    public static Comando getObjetoSet(final String nombrePaquete,
            final int accion) {
        try {
            Comando c;
            c = (Comando) Class
                    .forName(
                            nombrePaquete + "." + Comando.CLASSNAMESBIS[accion])
                    .newInstance();
            return c;
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException e) {
            return null;
        }

    }

}
