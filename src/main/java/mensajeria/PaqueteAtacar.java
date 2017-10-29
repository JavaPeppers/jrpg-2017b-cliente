package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The Class PaqueteAtacar.
 */
@SuppressWarnings("serial")
public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

    /**
     * The id.
     */
    private int id;

    /**
     * The id enemigo.
     */
    private int idEnemigo;

    /**
     * The nueva salud personaje.
     */
    private int nuevaSaludPersonaje;

    /**
     * The nueva energia personaje.
     */
    private int nuevaEnergiaPersonaje;

    /**
     * The nueva salud enemigo.
     */
    private int nuevaSaludEnemigo;

    /**
     * The nueva energia enemigo.
     */
    private int nuevaEnergiaEnemigo;

    /**
     * The map personaje.
     */
    private HashMap<String, Number> mapPersonaje
        = new HashMap<String, Number>();

    /**
     * The map enemigo.
     */
    private HashMap<String, Number> mapEnemigo = new HashMap<String, Number>();

    /**
     * Instantiates a new paquete atacar.
     *
     * @param idParam
     *            the id
     * @param idEnemigoParam
     *            the id enemigo
     * @param nuevaSalud
     *            the nueva salud
     * @param nuevaEnergia
     *            the nueva energia
     * @param nuevaSaludEnemigoParam
     *            the nueva salud enemigo
     * @param nuevaEnergiaEnemigoParam
     *            the nueva energia enemigo
     * @param nuevaDefensa
     *            the nueva defensa
     * @param nuevaDefensaEnemigo
     *            the nueva defensa enemigo
     * @param probEvitarDano
     *            the prob evitar dano
     * @param probEvitarDanoEnemgio
     *            the prob evitar dano enemgio
     */
    public PaqueteAtacar(final int idParam, final int idEnemigoParam,
            final int nuevaSalud, final int nuevaEnergia,
            final int nuevaSaludEnemigoParam,
            final int nuevaEnergiaEnemigoParam, final int nuevaDefensa,
            final int nuevaDefensaEnemigo, final double probEvitarDano,
            final double probEvitarDanoEnemgio) {
        setComando(Comando.ATACAR);
        this.id = idParam;
        this.idEnemigo = idEnemigoParam;
        this.nuevaSaludPersonaje = nuevaSalud;
        this.nuevaEnergiaPersonaje = nuevaEnergia;
        this.nuevaSaludEnemigo = nuevaSaludEnemigoParam;
        this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigoParam;
        mapPersonaje.put("salud", nuevaSalud);
        mapPersonaje.put("energia", nuevaEnergia);
        mapPersonaje.put("defensa", nuevaDefensa);
        mapPersonaje.put("probEvitarDanio", probEvitarDano);
        mapEnemigo.put("salud", nuevaSaludEnemigo);
        mapEnemigo.put("energia", nuevaEnergiaEnemigo);
        mapEnemigo.put("defensa", nuevaDefensaEnemigo);
        mapEnemigo.put("probEvitarDanio", probEvitarDanoEnemgio);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param idParam
     *            the new id
     */
    public void setId(final int idParam) {
        this.id = idParam;
    }

    /**
     * Gets the id enemigo.
     *
     * @return the id enemigo
     */
    public int getIdEnemigo() {
        return idEnemigo;
    }

    /**
     * Sets the id enemigo.
     *
     * @param idEnemigoParam
     *            the new id enemigo
     */
    public void setIdEnemigo(final int idEnemigoParam) {
        this.idEnemigo = idEnemigoParam;
    }

    /**
     * Gets the nueva salud personaje.
     *
     * @return the nueva salud personaje
     */
    public int getNuevaSaludPersonaje() {
        return nuevaSaludPersonaje;
    }

    /**
     * Sets the nueva salud personaje.
     *
     * @param nuevaSaludPersonajeParam
     *            the new nueva salud personaje
     */
    public void setNuevaSaludPersonaje(final int nuevaSaludPersonajeParam) {
        this.nuevaSaludPersonaje = nuevaSaludPersonajeParam;
    }

    /**
     * Gets the nueva energia personaje.
     *
     * @return the nueva energia personaje
     */
    public int getNuevaEnergiaPersonaje() {
        return nuevaEnergiaPersonaje;
    }

    /**
     * Sets the nueva energia personaje.
     *
     * @param nuevaEnergiaPersonajeParam
     *            the new nueva energia personaje
     */
    public void setNuevaEnergiaPersonaje(final int nuevaEnergiaPersonajeParam) {
        this.nuevaEnergiaPersonaje = nuevaEnergiaPersonajeParam;
    }

    /**
     * Gets the nueva salud enemigo.
     *
     * @return the nueva salud enemigo
     */
    public int getNuevaSaludEnemigo() {
        return nuevaSaludEnemigo;
    }

    /**
     * Sets the nueva salud enemigo.
     *
     * @param nuevaSaludEnemigoParam
     *            the new nueva salud enemigo
     */
    public void setNuevaSaludEnemigo(final int nuevaSaludEnemigoParam) {
        this.nuevaSaludEnemigo = nuevaSaludEnemigoParam;
    }

    /**
     * Gets the nueva energia enemigo.
     *
     * @return the nueva energia enemigo
     */
    public int getNuevaEnergiaEnemigo() {
        return nuevaEnergiaEnemigo;
    }

    /**
     * Sets the nueva energia enemigo.
     *
     * @param nuevaEnergiaEnemigoParam
     *            the new nueva energia enemigo
     */
    public void setNuevaEnergiaEnemigo(final int nuevaEnergiaEnemigoParam) {
        this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigoParam;
    }

    /**
     * Gets the map personaje.
     *
     * @return the map personaje
     */
    public HashMap<String, Number> getMapPersonaje() {
        return mapPersonaje;
    }

    /**
     * Gets the map enemigo.
     *
     * @return the map enemigo
     */
    public HashMap<String, Number> getMapEnemigo() {
        return mapEnemigo;
    }

}
