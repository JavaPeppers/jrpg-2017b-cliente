package juego;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import chat.MiChat;
import cliente.Cliente;
import cliente.EscuchaMensajes;
import dominio.Personaje;
import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoJuego;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

/**
 * The Class Juego.
 */
public class Juego implements Runnable {

    /**
     * The Constant FPS.
     */
    private static final int FPS = 80;

    /**
     * The Constant TAMANIOFONT.
     */
    private static final int TAMANIOFONT = 15;

    /**
     * The Constant NUMERODEBUFFER.
     */
    private static final int NUMERODEBUFFER = 3;

    /**
     * The Constant DIRECCION.
     */
    private static final int DIRECCION = 6;

    /**
     * The Constant NANOSEGUNDOS.
     */
    private static final int NANOSEGUNDOS = 1000000000;

    /**
     * The pantalla.
     */
    private Pantalla pantalla;

    /**
     * The nombre.
     */
    private final String nombre;

    /**
     * The ancho.
     */
    private final int ancho;

    /**
     * The alto.
     */
    private final int alto;

    /**
     * The hilo.
     */
    private Thread hilo;

    /**
     * The corriendo.
     */
    private boolean corriendo;

    /**
     * The bs.
     */
    private BufferStrategy bs; // Estrategia para graficar mediante buffers
                               // (Primero se "grafica" en el/los buffer/s y
    /**
     * The g.
     */
    // finalmente en el canvas)
    private Graphics g;

    /**
     * The estado juego.
     */
    // Estados
    private Estado estadoJuego;

    /**
     * The estado batalla.
     */
    private Estado estadoBatalla;

    /**
     * The estado batalla NPC.
     */
    private Estado estadoBatallaNPC;

    /**
     * The handler mouse.
     */
    // HandlerMouse
    private HandlerMouse handlerMouse;

    /**
     * The camara.
     */
    // Camara
    private Camara camara;

    /**
     * The cliente.
     */
    // Conexion
    private Cliente cliente;

    /**
     * The escucha mensajes.
     */
    private EscuchaMensajes escuchaMensajes;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The paquete enemigo.
     */
    private PaqueteEnemigo paqueteEnemigo;

    /**
     * The ubicacion personaje.
     */
    private PaqueteMovimiento ubicacionPersonaje;

    /**
     * The personajes conectados.
     */
    private Map<Integer, PaquetePersonaje> personajesConectados;

    /**
     * The ubicacion personajes.
     */
    private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;

    /**
     * The enemigos.
     */
    private Map<Integer, PaqueteEnemigo> enemigos;

    /**
     * The chats activos.
     */
    private Map<String, MiChat> chatsActivos = new HashMap<>();

    /**
     * The cargar recursos.
     */
    private CargarRecursos cargarRecursos;

    /**
     * Instantiates a new juego.
     *
     * @param nombreParam
     *            the nombre
     * @param anchoParam
     *            the ancho
     * @param altoParam
     *            the alto
     * @param clienteParam
     *            the cliente
     * @param ppParam
     *            the pp
     */
    public Juego(final String nombreParam, final int anchoParam,
            final int altoParam, final Cliente clienteParam,
            final PaquetePersonaje ppParam) {
        this.nombre = nombreParam;
        this.alto = altoParam;
        this.ancho = anchoParam;
        this.cliente = clienteParam;
        this.paquetePersonaje = ppParam;

        // Inicializo la ubicacion del personaje
        ubicacionPersonaje = new PaqueteMovimiento();
        ubicacionPersonaje.setIdPersonaje(paquetePersonaje.getId());
        ubicacionPersonaje.setFrame(0);
        ubicacionPersonaje.setDireccion(DIRECCION);

        // Creo el escucha de mensajes
        escuchaMensajes = new EscuchaMensajes(this);
        escuchaMensajes.start();

        handlerMouse = new HandlerMouse();

        iniciar();

        cargarRecursos = new CargarRecursos(cliente);
        cargarRecursos.start();
    }

    /**
     * Iniciar.
     */
    public void iniciar() { // Carga lo necesario para iniciar el juego
        pantalla = new Pantalla(nombre, ancho, alto, cliente);

        pantalla.getCanvas().addMouseListener(handlerMouse);

        camara = new Camara(this, 0, 0);

        Personaje.cargarTablaNivel();
    }

    /**
     * Actualizar.
     */
    private void actualizar() { // Actualiza los objetos y sus posiciones

        if (Estado.getEstado() != null) {
            Estado.getEstado().actualizar();
        }
    }

    /**
     * Graficar.
     */
    private void graficar() { // Grafica los objetos y sus posiciones
        bs = pantalla.getCanvas().getBufferStrategy();
        if (bs == null) { // Seteo una estrategia para el canvas en caso de que
                          // no tenga una
            pantalla.getCanvas().createBufferStrategy(NUMERODEBUFFER);
            return;
        }

        g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g

        g.clearRect(0, 0, ancho, alto); // Limpiamos la pantalla

        // Graficado de imagenes
        g.setFont(new Font("Book Antiqua", 1, TAMANIOFONT));

        if (Estado.getEstado() != null) {
            Estado.getEstado().graficar(g);
        }

        // Fin de graficado de imagenes

        bs.show(); // Hace visible el próximo buffer disponible
        g.dispose();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() { // Hilo principal del juego

        int fps = FPS; // Cantidad de actualizaciones por segundo que se desean
        double tiempoPorActualizacion = NANOSEGUNDOS / fps; // Cantidad de
                                                            // nanosegundos en
                                                            // FPS
                                                            // deseados
        double delta = 0;
        long ahora;
        long ultimoTiempo = System.nanoTime();
        long timer = 0; // Timer para mostrar fps cada un segundo
        int actualizaciones = 0; // Cantidad de actualizaciones que se realizan
                                 // realmente

        while (corriendo) {
            ahora = System.nanoTime();
            delta += (ahora - ultimoTiempo) / tiempoPorActualizacion;
            // Calculo para determinar cuando realizar la actualizacion y el
            // graficado
            timer += ahora - ultimoTiempo; // Sumo el tiempo transcurrido hasta
                                           // que se acumule 1 segundo y mostrar
                                           // los FPS
            ultimoTiempo = ahora; // Para las proximas corridas del bucle

            if (delta >= 1) {
                actualizar();
                graficar();
                actualizaciones++;
                delta--;
            }

            if (timer >= NANOSEGUNDOS) { // Si paso 1 segundo muestro los FPS
                pantalla.getFrame()
                        .setTitle(nombre + " | " + "FPS: " + actualizaciones);
                actualizaciones = 0;
                timer = 0;
            }
        }

        stop();
    }

    /**
     * Start.
     */
    public synchronized void start() { // Inicia el juego
        if (corriendo) {
            return;
        }

        estadoJuego = new EstadoJuego(this);
        Estado.setEstado(estadoJuego);
        pantalla.mostrar();
        corriendo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Stop.
     */
    public synchronized void stop() { // Detiene el juego
        if (!corriendo) {
            return;
        }
        try {
            corriendo = false;
            hilo.join();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo al intentar detener el juego.");
        }
    }

    /**
     * Gets the ancho.
     *
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Gets the alto.
     *
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Gets the handler mouse.
     *
     * @return the handler mouse
     */
    public HandlerMouse getHandlerMouse() {
        return handlerMouse;
    }

    /**
     * Gets the camara.
     *
     * @return the camara
     */
    public Camara getCamara() {
        return camara;
    }

    /**
     * Gets the estado juego.
     *
     * @return the estado juego
     */
    public EstadoJuego getEstadoJuego() {
        return (EstadoJuego) estadoJuego;
    }

    /**
     * Gets the estado batalla.
     *
     * @return the estado batalla
     */
    public EstadoBatalla getEstadoBatalla() {
        return (EstadoBatalla) estadoBatalla;
    }

    /**
     * Sets the estado batalla.
     *
     * @param estadoBatallaParam
     *            the new estado batalla
     */
    public void setEstadoBatalla(final EstadoBatalla estadoBatallaParam) {
        this.estadoBatalla = estadoBatallaParam;
    }

    /**
     * Gets the cliente.
     *
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Gets the escucha mensajes.
     *
     * @return the escucha mensajes
     */
    public EscuchaMensajes getEscuchaMensajes() {
        return escuchaMensajes;
    }

    /**
     * Gets the personaje.
     *
     * @return the personaje
     */
    public PaquetePersonaje getPersonaje() {
        return paquetePersonaje;
    }

    /**
     * Gets the ubicacion personaje.
     *
     * @return the ubicacion personaje
     */
    public PaqueteMovimiento getUbicacionPersonaje() {
        return ubicacionPersonaje;
    }

    /**
     * Sets the personaje.
     *
     * @param paquetePersonajeParam
     *            the new personaje
     */
    public void setPersonaje(final PaquetePersonaje paquetePersonajeParam) {
        this.paquetePersonaje = paquetePersonajeParam;
    }

    /**
     * Actualizar personaje.
     */
    public void actualizarPersonaje() {
        paquetePersonaje = (PaquetePersonaje) (personajesConectados
                .get(paquetePersonaje.getId()).clone());
    }

    /**
     * Gets the personajes conectados.
     *
     * @return the personajes conectados
     */
    public Map<Integer, PaquetePersonaje> getPersonajesConectados() {
        return personajesConectados;
    }

    /**
     * Sets the personajes conectados.
     *
     * @param mapParam
     *            the map
     */
    public void setPersonajesConectados(
            final Map<Integer, PaquetePersonaje> mapParam) {
        this.personajesConectados = mapParam;
    }

    /**
     * Gets the ubicacion personajes.
     *
     * @return the ubicacion personajes
     */
    public Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
        return ubicacionPersonajes;
    }

    /**
     * Sets the ubicacion personajes.
     *
     * @param ubicacionPersonajesParam
     *            the ubicacion personajes
     */
    public void setUbicacionPersonajes(
            final Map<Integer, PaqueteMovimiento> ubicacionPersonajesParam) {
        this.ubicacionPersonajes = ubicacionPersonajesParam;
    }

    /**
     * Gets the chats activos.
     *
     * @return the chats activos
     */
    public Map<String, MiChat> getChatsActivos() {
        return chatsActivos;
    }

    /**
     * Gets the enemigos.
     *
     * @return the enemigos
     */
    public Map<Integer, PaqueteEnemigo> getEnemigos() {
        return enemigos;
    }

    /**
     * Sets the enemigos.
     *
     * @param enemigosParam
     *            the enemigos
     */
    public void setEnemigos(final Map<Integer, PaqueteEnemigo> enemigosParam) {
        this.enemigos = enemigosParam;
    }

    /**
     * Gets the estado batalla NPC.
     *
     * @return the estado batalla NPC
     */
    public Estado getEstadoBatallaNPC() {
        return estadoBatallaNPC;
    }

    /**
     * Sets the estado batalla NPC.
     *
     * @param estadoBatallaNPCParam
     *            the new estado batalla NPC
     */
    public void setEstadoBatallaNPC(final Estado estadoBatallaNPCParam) {
        this.estadoBatallaNPC = estadoBatallaNPCParam;
    }

    /**
     * Get paquete Enemigo.
     *
     * @return paqueteEnemigo
     */
    public PaqueteEnemigo getPaqueteEnemigo() {
        return paqueteEnemigo;
    }

    /**
     * Set paquete Enemigo.
     *
     * @param paqueteEnemigoParam
     *            setea el paquete enemigo.
     */
    public void setPaqueteEnemigo(final PaqueteEnemigo paqueteEnemigoParam) {
        this.paqueteEnemigo = paqueteEnemigoParam;
    }

}
