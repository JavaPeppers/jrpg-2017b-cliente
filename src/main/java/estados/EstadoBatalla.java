package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;
import dominio.Personaje;
import interfaz.EstadoDePersonaje;
import interfaz.MenuBatalla;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * The Class EstadoBatalla.
 */
public class EstadoBatalla extends Estado {

    /** The Constant TAMXNPC. */
    private static final int TAMXNPC = 550;

    /** The Constant TAMY. */
    private static final int TAMY = 5;

    /** The Constant TAMX. */
    private static final int TAMX = 25;

    /** The Constant POSYNPC. */
    private static final int POSYNPC = 75;

    /** The Constant POSXNPC. */
    private static final int POSXNPC = 550;

    /** The Constant RAZANPC. */
    private static final int RAZANPC = 7;

    /** The Constant POSYJUGADOR. */
    private static final int POSYJUGADOR = 175;

    /** The Constant RAZA. */
    private static final int RAZA = 3;

    /** The Constant EXPBASE. */
    private static final int EXPBASE = 40;

    /** The Constant ENERGIA. */
    private static final int ENERGIA = 10;

    /** The Constant HABENERGIA. */
    private static final int HABENERGIA = 6;

    /** The Constant HABCASTATRES. */
    private static final int HABCASTATRES = 5;

    /** The Constant HABCASTADOS. */
    private static final int HABCASTADOS = 4;

    /** The Constant HABCASTAUNO. */
    private static final int HABCASTAUNO = 3;

    /** The Constant YOFFSET. */
    private static final int YOFFSET = 150;

    /** The Constant XOFFSET. */
    private static final int XOFFSET = 350;

    /** The Constant QUINTARAZA. */
    private static final int QUINTARAZA = 5;

    /**
     * The Constant ANCHURAALTURA.
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
    private Personaje enemigo;

    /**
     * The pos mouse.
     */
    private int[] posMouse;

    /**
     * The paquete personaje.
     */
    private PaquetePersonaje paquetePersonaje;

    /**
     * The nivel de personaje.
     */
    private int nivelDePersonaje;

    /**
     * The paquete enemigo.
     */
    private PaquetePersonaje paqueteEnemigo;

    /**
     * The nivel de enemigo.
     */
    private int nivelDeEnemigo;

    /**
     * The paquete atacar.
     */
    private PaqueteAtacar paqueteAtacar;

    /**
     * The paquete finalizar batalla.
     */
    private PaqueteFinalizarBatalla paqueteFinalizarBatalla;

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
     * The Constant PUNTOSSKILLSPORNIVEL.
     */
    private static final int PUNTOSSKILLSPORNIVEL = 3;

    /**
     * The Constant ENERGIAMINIMA.
     */
    private static final int ENERGIAMINIMA = 10;

    /**
     * Instantiates a new estado batalla.
     *
     * @param juego
     *            the juego
     * @param paqueteBatalla
     *            the paquete batalla
     */
    public EstadoBatalla(final Juego juego,
            final PaqueteBatalla paqueteBatalla) {
        super(juego);
        mundo = new Mundo(juego, "recursos/mundoBatalla.txt",
                "recursos/mundoBatallaCapaDos.txt");
        miTurno = paqueteBatalla.isMiTurno();

        paquetePersonaje = juego.getPersonajesConectados()
                .get(paqueteBatalla.getId());
        paqueteEnemigo = juego.getPersonajesConectados()
                .get(paqueteBatalla.getIdEnemigo());

        crearPersonajes();

        menuBatalla = new MenuBatalla(miTurno, personaje);

        miniaturaEnemigo = Recursos.getPersonaje().get(enemigo.getNombreRaza())
                .get(QUINTARAZA)[0];
        miniaturaPersonaje = Recursos.getPersonaje()
                .get(personaje.getNombreRaza()).get(QUINTARAZA)[0];

        paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
        paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
        paqueteFinalizarBatalla.setIdEnemigo(enemigo.getIdPersonaje());

        // por defecto batalla perdida
        juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(),
                MenuInfoPersonaje.MENUPERDERBATALLA);

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
                            if (!paqueteEnemigo.isModoDios()
                                    || (paquetePersonaje.isModoDios()
                                            && paqueteEnemigo.isModoDios())) {
                                personaje.habilidadRaza1(enemigo);
                            }
                            if (personaje.getEnergia() >= ENERGIAMINIMA) {
                                personaje.reducirEnergia(ENERGIAMINIMA);
                            }
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == 2) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            if (!paqueteEnemigo.isModoDios()
                                    || (paquetePersonaje.isModoDios()
                                            && paqueteEnemigo.isModoDios())) {
                                personaje.habilidadRaza2(enemigo);
                            }
                            if (personaje.getEnergia() >= ENERGIAMINIMA) {
                                personaje.reducirEnergia(ENERGIAMINIMA);
                            }
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABCASTAUNO) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            if (!paqueteEnemigo.isModoDios()
                                    || (paquetePersonaje.isModoDios()
                                            && paqueteEnemigo.isModoDios())) {
                                personaje.habilidadCasta1(enemigo);
                            }
                            if (personaje.getEnergia() >= ENERGIAMINIMA) {
                                personaje.reducirEnergia(ENERGIAMINIMA);
                            }
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABCASTADOS) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            if (!enemigo.isModoDios() || (personaje.isModoDios()
                                    && enemigo.isModoDios())) {
                                personaje.habilidadCasta2(enemigo);
                            }
                            if (personaje.getEnergia() >= ENERGIAMINIMA) {
                                personaje.reducirEnergia(ENERGIAMINIMA);
                            }
                        }
                        haySpellSeleccionada = true;
                    }

                    if (menuBatalla.getBotonClickeado(posMouse[0],
                            posMouse[1]) == HABCASTATRES) {
                        if (personaje.puedeAtacar()) {
                            seRealizoAccion = true;
                            if (!enemigo.isModoDios() || (personaje.isModoDios()
                                    && enemigo.isModoDios())) {
                                personaje.habilidadCasta3(enemigo);
                            }
                            if (personaje.getEnergia() >= ENERGIAMINIMA) {
                                personaje.reducirEnergia(ENERGIAMINIMA);
                            }
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
                        if (personaje.ganarExperiencia(
                                enemigo.getNivel() * EXPBASE)) {
                            juego.getPersonaje().setNivel(personaje.getNivel());
                            juego.getEstadoJuego().setHaySolicitud(true,
                                    juego.getPersonaje(),
                                    MenuInfoPersonaje.MENUSUBIRNIVEL);
                        }
                        paqueteFinalizarBatalla.setGanadorBatalla(
                                juego.getPersonaje().getId());
                        finalizarBatalla();
                        Estado.setEstado(juego.getEstadoJuego());

                    } else {
                        paqueteAtacar = new PaqueteAtacar(
                                paquetePersonaje.getId(),
                                paqueteEnemigo.getId(), personaje.getSalud(),
                                personaje.getEnergia(), enemigo.getSalud(),
                                enemigo.getEnergia(), personaje.getDefensa(),
                                enemigo.getDefensa(),
                                personaje.getCasta()
                                        .getProbabilidadEvitarDaño(),
                                enemigo.getCasta().getProbabilidadEvitarDaño());
                        enviarAtaque(paqueteAtacar);
                        miTurno = false;
                        menuBatalla.setHabilitado(false);
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
                        .get(RAZA)[0],
                0, POSYJUGADOR, ANCHURAALTURA, ANCHURAALTURA, null);
        g.drawImage(
                Recursos.getPersonaje().get(paqueteEnemigo.getRaza())
                        .get(RAZANPC)[0],
                POSXNPC, POSYNPC, ANCHURAALTURA, ANCHURAALTURA, null);

        mundo.graficarObstaculos(g);
        menuBatalla.graficar(g);

        g.setColor(Color.GREEN);

        EstadoDePersonaje.dibujarEstadoDePersonaje(g, TAMX, TAMY, personaje,
                miniaturaPersonaje);
        EstadoDePersonaje.dibujarEstadoDePersonaje(g, TAMXNPC, TAMY, enemigo,
                miniaturaEnemigo);

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
        this.nivelDePersonaje = paquetePersonaje.getNivel();

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
        nombre = paqueteEnemigo.getNombre();
        salud = paqueteEnemigo.getSaludTope();
        energia = paqueteEnemigo.getEnergiaTope();
        fuerza = paqueteEnemigo.getFuerzaExtra();
        destreza = paqueteEnemigo.getDestreza();
        inteligencia = paqueteEnemigo.getInteligencia();
        experiencia = paqueteEnemigo.getExperiencia();
        nivel = paqueteEnemigo.getNivel();
        id = paqueteEnemigo.getId();
        this.nivelDeEnemigo = paqueteEnemigo.getNivel();

        casta = null;
        if (paqueteEnemigo.getCasta().equals("Guerrero")) {
            casta = new Guerrero();
        } else if (paqueteEnemigo.getCasta().equals("Hechicero")) {
            casta = new Hechicero();
        } else if (paqueteEnemigo.getCasta().equals("Asesino")) {
            casta = new Asesino();
        }

        if (paqueteEnemigo.getRaza().equals("Humano")) {
            enemigo = new Humano(nombre, salud, energia, fuerza, destreza,
                    inteligencia, casta, experiencia, nivel, id);
        } else if (paqueteEnemigo.getRaza().equals("Orco")) {
            enemigo = new Orco(nombre, salud, energia, fuerza, destreza,
                    inteligencia, casta, experiencia, nivel, id);
        } else if (paqueteEnemigo.getRaza().equals("Elfo")) {
            enemigo = new Elfo(nombre, salud, energia, fuerza, destreza,
                    inteligencia, casta, experiencia, nivel, id);
        }
        if (paqueteEnemigo.isModoDios()) {
            enemigo.setModoDios();
        }
    }

    /**
     * Enviar ataque.
     *
     * @param paqueteAtacarParam
     *            the paquete atacar
     */
    public void enviarAtaque(final PaqueteAtacar paqueteAtacarParam) {
        try {
            juego.getCliente().getSalida()
                    .writeObject(gson.toJson(paqueteAtacarParam));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo la conexion con el servidor.");
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
            paquetePersonaje.setFuerzaExtra(personaje.getFuerza());
            paquetePersonaje.setInteligencia(personaje.getInteligencia());
            paquetePersonaje.removerBonus();

            paqueteEnemigo.setSaludTope(enemigo.getSaludTope());
            paqueteEnemigo.setEnergiaTope(enemigo.getEnergiaTope());
            paqueteEnemigo.setNivel(enemigo.getNivel());
            paqueteEnemigo.setExperiencia(enemigo.getExperiencia());
            paqueteEnemigo.setDestreza(enemigo.getDestreza());
            paqueteEnemigo.setFuerzaExtra(enemigo.getFuerza());
            paqueteEnemigo.setInteligencia(enemigo.getInteligencia());
            paqueteEnemigo.removerBonus();

            /**
             * Se verifica si Mi Personaje o El Enemigo subio de nivel al ganar
             * la batalla, para asignar puntos de Skills, esto deberia ir donde
             * sube de nivel (refactorear)
             */
            if (paquetePersonaje.getNivel() > this.nivelDePersonaje) {
                paquetePersonaje.actualizarPuntosSkillsDisponibles(
                        PUNTOSSKILLSPORNIVEL);
            } else if (paqueteEnemigo.getNivel() > this.nivelDeEnemigo) {
                paqueteEnemigo.actualizarPuntosSkillsDisponibles(
                        PUNTOSSKILLSPORNIVEL);
            }

            paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
            paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);

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
     * Gets the paquete personaje.
     *
     * @return the paquete personaje
     */
    public PaquetePersonaje getPaquetePersonaje() {
        return paquetePersonaje;
    }

    /**
     * Gets the paquete enemigo.
     *
     * @return the paquete enemigo
     */
    public PaquetePersonaje getPaqueteEnemigo() {
        return paqueteEnemigo;
    }

    /**
     * Sets the mi turno.
     *
     * @param b
     *            the new mi turno
     */
    public void setMiTurno(final boolean b) {
        miTurno = b;
        menuBatalla.setHabilitado(b);
        juego.getHandlerMouse().setNuevoClick(false);
    }

    /**
     * Gets the personaje.
     *
     * @return the personaje
     */
    public Personaje getPersonaje() {
        return personaje;
    }

    /**
     * Gets the enemigo.
     *
     * @return the enemigo
     */
    public Personaje getEnemigo() {
        return enemigo;
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
