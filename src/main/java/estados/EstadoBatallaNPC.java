package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import dominio.Casta;
import dominio.Enemigo;
import dominio.Personaje;
import interfaz.EstadoDePersonaje;
import interfaz.EstadoEnemigo;
import interfaz.MenuBatalla;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteBatallaNPC;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteFinalizarBatallaNPC;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoBatallaNPC.
 */
public class EstadoBatallaNPC extends Estado {

    /** Constante TAMXNPC. */
    private static final int TAMXNPC = 550;

    /** Constante TAMY. */
    private static final int TAMY = 5;

    /** Constante TAMX. */
    private static final int TAMX = 25;

    /** Constante POSYNPC. */
    private static final int POSYNPC = 75;

    /** Constante POSXNPC. */
    private static final int POSXNPC = 550;

    /** Constante RAZANPC. */
    // private static final int RAZANPC = 7;

    /** Constante POSYJUGADOR. */
    private static final int POSYJUGADOR = 175;

    /** Constante RAZAJUGADOR. */
    private static final int RAZAJUGADOR = 3;

    /** Constante HABENERGIA. */
    private static final int HABENERGIA = 6;

    /** Constante ENERGIA. */
    private static final int ENERGIA = 10;

    /** Constante HABCASTATRES. */
    private static final int HABCASTATRES = 5;

    /** Constante HABCASTADOS. */
    private static final int HABCASTADOS = 4;

    /** Constante HABCASTAUNO. */
    private static final int HABCASTAUNO = 3;

    /** Constante YOFFSET. */
    private static final int YOFFSET = 150;

    /** Constante XOFFSET. */
    private static final int XOFFSET = 350;

    /** Constante RAZA. */
    private static final int RAZA = 5;

    /**
     * Constante ANCHURAALTURA.
     */
    private static final int ANCHURAALTURA = 256;

    /**
     * The mundo.
     */
    private Mundo mundo;

    /**
     * The personaje.
     */
    private Personaje personaje;

    /**
     * The enemigo.
     */
    private Enemigo enemigo;

    /**
     * The pos mouse.
     */
    private int[] posMouse;

    /**
     * The nivel de personaje.
     */
    private int nivelDePersonaje;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The paquete enemigo.
     */
    private PaqueteEnemigo paqueteEnemigo;

    /**
     * The paquete finalizar batalla.
     */
    private PaqueteFinalizarBatallaNPC paqueteFinalizarBatalla;

    /**
     * The mi turno.
     */
    private boolean miTurno;

    /**
     * The hay spell seleccionada.
     */
    private boolean haySpellSeleccionada;

    /**
     * The se realizo accion.
     */
    private boolean seRealizoAccion;

    /**
     * The gson.
     */
    private Gson gson = new Gson();

    /**
     * The miniatura personaje.
     */
    private BufferedImage miniaturaPersonaje;

    /**
     * The miniatura enemigo.
     */
    private BufferedImage miniaturaEnemigo;

    /**
     * The menu batalla.
     */
    private MenuBatalla menuBatalla;

    /**
     * Constante PUNTOSSKILLSPORNIVEL.
     */
    private static final int PUNTOSSKILLSPORNIVEL = 3;

    /**
     * Instantiates a new estado batalla NPC.
     *
     * @param juego
     *            the juego
     * @param paqueteBatalla
     *            the paquete batalla
     */
    public EstadoBatallaNPC(final Juego juego,
            final PaqueteBatallaNPC paqueteBatalla) {
        super(juego);
        mundo = new Mundo(juego, "recursos/mundoBatalla.txt",
                "recursos/mundoBatallaCapaDos.txt");
        miTurno = paqueteBatalla.isMiTurno();

        paquetePersonaje = juego.getPersonajesConectados()
                .get(paqueteBatalla.getId());
        paqueteEnemigo = juego.getEnemigos().get(paqueteBatalla.getIdEnemigo());

        crearPersonajes();

        menuBatalla = new MenuBatalla(miTurno, personaje);
        if (paqueteEnemigo.getId() != -21) {
            miniaturaEnemigo = Recursos.getWizard().get(0)[0];
        } else {
            miniaturaEnemigo = Recursos.getSkullReaper().get(0)[0];
        }

        miniaturaPersonaje = Recursos.getPersonaje()
                .get(personaje.getNombreRaza()).get(RAZA)[0];

        paqueteFinalizarBatalla = new PaqueteFinalizarBatallaNPC();
        paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
        paqueteFinalizarBatalla.setIdEnemigo(paqueteEnemigo.getId());

        // por defecto batalla perdida
        // juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(),
        // MenuInfoPersonaje.MENUPERDERBATALLA);

        // limpio la accion del mouse
        juego.getHandlerMouse().setNuevoClick(false);
    }

    /*
     * (non-Javadoc)
     *
     * @see estados.Estado#actualizar()
     */
    @Override
    public void actualizar() {
        juego.getCamara().setxOffset(-XOFFSET);
        juego.getCamara().setyOffset(YOFFSET);

        seRealizoAccion = false;
        haySpellSeleccionada = false;

        if (miTurno) {

            if (juego.getHandlerMouse().getNuevoClick()) {
                posMouse = juego.getHandlerMouse().getPosMouse();

                if (menuBatalla.clickEnMenu(posMouse[0], posMouse[1])) {

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == 1) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadRaza1(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == 2) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadRaza2(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABCASTAUNO) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadCasta1(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABCASTADOS) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadCasta2(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABCASTATRES) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            personaje.habilidadCasta3(enemigo);
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABENERGIA) {
                        seRealizoAccion = true;
                        personaje.serEnergizado(ENERGIA);
                        haySpellSeleccionada = true;
                    }
                }

                if (haySpellSeleccionada && seRealizoAccion) {
                    if (!enemigo.estaVivo()) {

                        juego.getEstadoJuego().setHaySolicitud(true,
                                juego.getPersonaje(),
                                MenuInfoPersonaje.MENUGANARBATALLA);
                        int exp = (int) (enemigo.otorgarExp()
                                * personaje.getNivel() * 0.2);
                        if (paqueteEnemigo.getId() == -21) {
                            exp = 1000;
                        }
                        if (personaje.ganarExperiencia(exp)) {

                            juego.getPersonaje().setNivel(personaje.getNivel());
                            juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonaje(),
                                    MenuInfoPersonaje.MENUSUBIRNIVEL);
                        }
                        paqueteFinalizarBatalla.setGanadorBatalla(
                                juego.getPersonaje().getId());
                        finalizarBatalla();
                        Estado.setEstado(juego.getEstadoJuego()); // Vuelvo al
                                                                  // mapa

                    } else {
                        enemigo.atacar(personaje);

                        if (!personaje.estaVivo()) {
                            juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonaje(),
                                    MenuInfoPersonaje.MENUPERDERBATALLA);

                            paqueteFinalizarBatalla.setGanadorBatalla(juego
                                    .getEnemigos()
                                    .get(paqueteFinalizarBatalla.getIdEnemigo())
                                    .getId());
                            finalizarBatalla();
                            Estado.setEstado(juego.getEstadoJuego()); // Vuelvo
                                                                      // al mapa
                        }

                        miTurno = true;
                    }
                } else if (haySpellSeleccionada && !seRealizoAccion) {
                    JOptionPane.showMessageDialog(null,
                            "No posees la energía suficiente"
                                    + "para realizar esta habilidad.");
                }

                juego.getHandlerMouse().setNuevoClick(false);
            }
        }
    }

    /**
     * Finalizar batalla.
     */
    private void finalizarBatalla() {
        try {
            juego.getCliente().getSalida()
                    .writeObject(gson.toJson(paqueteFinalizarBatalla));

            paquetePersonaje.setSaludTope(personaje.getSaludTope());
            paquetePersonaje.setEnergiaTope(personaje.getEnergiaTope());
            paquetePersonaje.setNivel(personaje.getNivel());
            paquetePersonaje.setExperiencia(personaje.getExperiencia());
            paquetePersonaje.setDestreza(personaje.getDestreza());
            paquetePersonaje.setFuerza(personaje.getFuerza());
            paquetePersonaje.setInteligencia(personaje.getInteligencia());
            paquetePersonaje.removerBonus();

            paqueteEnemigo.setSaludTope(paqueteEnemigo.getSaludTope());
            int diferenciaNivel = paquetePersonaje.getNivel() - this.nivelDePersonaje;
            if (paquetePersonaje.getNivel() > this.nivelDePersonaje) {
                paquetePersonaje.actualizarPuntosSkillsDisponibles(
                        PUNTOSSKILLSPORNIVEL * diferenciaNivel);
            }

            paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
            paqueteEnemigo.setComando(Comando.ACTUALIZARENEMIGO);

            juego.getCliente().getSalida()
                    .writeObject(gson.toJson(paquetePersonaje));
            juego.getCliente().getSalida()
                    .writeObject(gson.toJson(paqueteEnemigo));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo la conexión con el servidor");
        }

    }

    /**
     * Crear personajes.
     */
    private void crearPersonajes() {

        /** Se crea mi Personaje en la batalla */
        String nombre = paquetePersonaje.getNombre();
        int salud = paquetePersonaje.getSaludTope();
        int energia = paquetePersonaje.getEnergiaTope();
        int fuerza = paquetePersonaje.getFuerzaExtra();
        int destreza = paquetePersonaje.getDestreza();
        int inteligencia = paquetePersonaje.getInteligencia();
        int experiencia = paquetePersonaje.getExperiencia();
        int nivel = paquetePersonaje.getNivel();
        int id = paquetePersonaje.getId();

        nivelDePersonaje = paquetePersonaje.getNivel();

        Casta casta = null;
        try {
            casta = (Casta) Class
                    .forName("dominio" + "." + paquetePersonaje.getCasta())
                    .newInstance();
            personaje = (Personaje) Class
                    .forName("dominio" + "." + paquetePersonaje.getRaza())
                    .getConstructor(String.class, Integer.TYPE, Integer.TYPE,
                            Integer.TYPE, Integer.TYPE, Integer.TYPE,
                            Casta.class, Integer.TYPE, Integer.TYPE,
                            Integer.TYPE)
                    .newInstance(nombre, salud, energia, fuerza, destreza,
                            inteligencia, casta, experiencia, nivel, id);
            if (paquetePersonaje.isModoDios()) {
                personaje.setModoDios();
            }
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la batalla");
        }

        /** Se crea mi Enemigo en la batalla */
        if (paqueteEnemigo.getId() == -21) {
            nombre = "The Skull Reaper";
            salud = 1000;
            fuerza = 500;

            enemigo = new Enemigo(nombre, fuerza, 30, salud);
            enemigo.setSaludTope(salud);
        } else {
            nombre = paqueteEnemigo.getNombre();
            paqueteEnemigo.setSaludTope(personaje.getSalud());
            salud = paqueteEnemigo.getSaludTope();
            if (paquetePersonaje.getNivel() != 1) {
                fuerza = (int) (paqueteEnemigo.getFuerza() * 0.4 * nivel);
            } else {
                fuerza = paqueteEnemigo.getFuerza();
            }

            id = paqueteEnemigo.getId();

            enemigo = new Enemigo("Enemigo", fuerza, nivel, salud);
            enemigo.setSaludTope(salud);
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see estados.Estado#graficar(java.awt.Graphics)
     */
    @Override
    public void graficar(final Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
        mundo.graficar(g);

        g.drawImage(
                Recursos.getPersonaje().get(paquetePersonaje.getRaza())
                        .get(RAZAJUGADOR)[0],
                0, POSYJUGADOR, ANCHURAALTURA, ANCHURAALTURA, null);
        if (paqueteEnemigo.getId() != -21) {
            g.drawImage(Recursos.getWizard().get(0)[0], POSXNPC, POSYNPC,
                    ANCHURAALTURA, ANCHURAALTURA, null);
        } else {
            g.drawImage(Recursos.getSkullReaper().get(0)[0], POSXNPC - 100,
                    POSYNPC, 300, 218, null);
        }

        mundo.graficarObstaculos(g);
        menuBatalla.graficar(g);

        g.setColor(Color.GREEN);

        EstadoDePersonaje.dibujarEstadoDePersonaje(g, TAMX, TAMY, personaje,
                miniaturaPersonaje);
        EstadoEnemigo.dibujarEstadoDeEnemigo(g, TAMXNPC, TAMY, enemigo,
                miniaturaEnemigo);
    }

    /*
     * (non-Javadoc)
     *
     * @see estados.Estado#esEstadoDeJuego()
     */
    @Override
    public boolean esEstadoDeJuego() {
        return false;
    }
}
