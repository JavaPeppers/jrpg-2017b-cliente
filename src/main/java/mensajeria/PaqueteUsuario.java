package mensajeria;

import java.io.Serializable;

/**
 * The Class PaqueteUsuario.
 */
@SuppressWarnings("serial")
public class PaqueteUsuario extends Paquete implements Serializable, Cloneable {

    /**
     * The id pj.
     */
    private int idPj;

    /**
     * The username.
     */
    private String username;

    /**
     * The password.
     */
    private String password;

    /**
     * The inicio sesion.
     */
    private boolean inicioSesion;

    /**
     * Instantiates a new paquete usuario.
     */
    public PaqueteUsuario() {

    }

    /**
     * Instantiates a new paquete usuario.
     *
     * @param pj
     *            the pj
     * @param user
     *            the user
     * @param pw
     *            the pw
     */
    public PaqueteUsuario(final int pj, final String user, final String pw) {
        idPj = pj;
        username = user;
        password = pw;
        inicioSesion = false;
    }

    /**
     * Gets the id pj.
     *
     * @return the id pj
     */
    public int getIdPj() {
        return idPj;
    }

    /**
     * Sets the id pj.
     *
     * @param idPjParam
     *            the new id pj
     */
    public void setIdPj(final int idPjParam) {
        this.idPj = idPjParam;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param usernameParam
     *            the new username
     */
    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param passwordParam
     *            the new password
     */
    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    /**
     * Checks if is inicio sesion.
     *
     * @return true, if is inicio sesion
     */
    public boolean isInicioSesion() {
        return inicioSesion;
    }

    /**
     * Sets the inicio sesion.
     *
     * @param inicioSesionParam
     *            the new inicio sesion
     */
    public void setInicioSesion(final boolean inicioSesionParam) {
        this.inicioSesion = inicioSesionParam;
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
