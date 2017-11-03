package mensajeria;

import com.google.gson.Gson;

/**
 * The Class Comando.
 */
public abstract class Comando {
    // Nombre del paquete donde se encuentran las clases con las
    /**
     * The Constant NOMBREPAQUETE.
     */
    // responsabilidades
    public static final String NOMBREPAQUETE = "comandos";

    /**
     * The Constant CLASSNAMES.
     */
    public static final String[] CLASSNAMES = {"Conexion", "CrearPersonaje",
            "Desconectar", "InicioSesion", "MostrarMapas", "Movimiento",
            "Registro", "Salir", "Batalla", "Atacar", "FinalizarBatalla",
            "ActualizarPersonaje", "ActualizarPersonajeLvl",
            "ActualizarInventario", "Comercio", "ActualizarComercio", "Trueque",
            "ActualizarTrueque", "Talk", "ActualizarPuntosSkills",
            "SetEnemigos", "FinalizarBatallaNPC", "BatallaNPC", "ActualizarEnemigo","DesaparecerEnemigo", "ComandoError"};

    /**
     * The Constant CLASSNAMESBIS.
     */
    public static final String[] CLASSNAMESBIS = {"Conexion", "CrearPersonaje",
            "Desconectar", "InicioSesionSet", "MostrarMapas", "Movimiento",
            "RegistroSet", "SalirSet", "Batalla", "Atacar", "FinalizarBatalla",
            "ActualizarPersonaje", "ActualizarPersonajeLvl",
            "ActualizarInventario", "Comercio", "ActualizarComercio", "Trueque",
            "ActualizarTrueque", "Talk", "ActualizarPuntosSkills",
            "SetEnemigos", "FinalizarBatallaNPC", "BatallaNPC", "ActualizarEnemigo","DesaparecerEnemigo", "ComandoError"};
    /**
     * The Constant CONEXION.
     */
    public static final int CONEXION = 0;

    /**
     * The Constant CREACIONPJ.
     */
    public static final int CREACIONPJ = 1;

    /**
     * The Constant DESCONECTAR.
     */
    public static final int DESCONECTAR = 2;

    /**
     * The Constant INICIOSESION.
     */
    public static final int INICIOSESION = 3;

    /**
     * The Constant MOSTRARMAPAS.
     */
    public static final int MOSTRARMAPAS = 4;

    /**
     * The Constant MOVIMIENTO.
     */
    public static final int MOVIMIENTO = 5;

    /**
     * The Constant REGISTRO.
     */
    public static final int REGISTRO = 6;

    /**
     * The Constant SALIR.
     */
    public static final int SALIR = 7;

    /**
     * The Constant BATALLA.
     */
    public static final int BATALLA = 8;

    /**
     * The Constant ATACAR.
     */
    public static final int ATACAR = 9;

    /**
     * The Constant FINALIZARBATALLA.
     */
    public static final int FINALIZARBATALLA = 10;

    /**
     * The Constant ACTUALIZARPERSONAJE.
     */
    public static final int ACTUALIZARPERSONAJE = 11;

    /**
     * The Constant ACTUALIZARPERSONAJELV.
     */
    public static final int ACTUALIZARPERSONAJELV = 12;

    /**
     * The Constant ACTUALIZARINVENTARIO.
     */
    public static final int ACTUALIZARINVENTARIO = 13;

    /**
     * The Constant COMERCIO.
     */
    public static final int COMERCIO = 14;

    /**
     * The Constant ACTUALIZARCOMERCIO.
     */
    public static final int ACTUALIZARCOMERCIO = 15;

    /**
     * The Constant TRUEQUE.
     */
    public static final int TRUEQUE = 16;

    /**
     * The Constant ACTUALIZARTRUEQUE.
     */
    public static final int ACTUALIZARTRUEQUE = 17;

    /**
     * The Constant TALK.
     */
    public static final int TALK = 18;

    /**
     * The Constant ACTUALIZARPUNTOSSKILLS.
     */
    public static final int ACTUALIZARPUNTOSSKILLS = 19;

    /**
     * The Constant SETENEMIGOS.
     */
    public static final int SETENEMIGOS = 20;

    /**
     * The Constant FINALIZARBATALLANPC.
     */
    public static final int FINALIZARBATALLANPC = 21;

    /**
     * The Constant BATALLANPC.
     */
    public static final int BATALLANPC = 22;
    
    /**
     * The Constant ACTUALIZARENEMIGO
     */
    public static final int ACTUALIZARENEMIGO = 23;

    /**
     * The Constant DESAPARECERENEMIGO
     */
    public static final int DESAPARECERENEMIGO = 24;
    
    /**
     * Constante que indica el comando error.
     */
    public static final int COMANDOERROR = 25;

    /**
     * The gson.
     */
    private final Gson gson = new Gson();

    /**
     * The cadena leida.
     */
    private String cadenaLeida;

    /**
     * Sets the cadena.
     *
     * @param cadenaLeidaParam
     *            the new cadena
     */
    public void setCadena(final String cadenaLeidaParam) {
        this.setCadenaLeida(cadenaLeidaParam);
    }

    /**
     * Ejecutar.
     */
    public abstract void ejecutar();

    /**
     * @return the cadenaLeida
     */
    public String getCadenaLeida() {
        return cadenaLeida;
    }

    /**
     * @param cadenaLeidaParam the cadenaLeida to set
     */
    public void setCadenaLeida(final String cadenaLeidaParam) {
        this.cadenaLeida = cadenaLeidaParam;
    }

    /**
     * @return the gson
     */
    public Gson getGson() {
        return gson;
    }
}
